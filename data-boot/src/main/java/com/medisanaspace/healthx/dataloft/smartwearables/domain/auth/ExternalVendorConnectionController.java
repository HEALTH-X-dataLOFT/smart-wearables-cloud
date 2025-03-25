package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth;

import com.google.api.client.auth.oauth.OAuthAuthorizeTemporaryTokenUrl;
import com.medisanaspace.healthx.dataloft.smartwearables.auth.SwcAuthToken;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.AccessTokenData;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.OAuthClient;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.OAuthException;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.OAuthProperties;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.UserService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.helper.UserIdHelper;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProvider;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderAccountLinkService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviderRepository;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.ActivityProviders;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.transport.OAuthRequestFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Controller
@RequestMapping("/external-vendors")
public class ExternalVendorConnectionController {

    private static String OAUTH_CALLBACK_LITERAL = "&oauth_callback=";
    private static final ConcurrentHashMap<String, String> USER_ID_STORE = new ConcurrentHashMap<>();

    private final OAuthClient oAuthClient;
    private final ProviderAuthConfigRegistry authConfigRegistry;
    private final ActivityProviderRepository providerRepository;
    private final ActivityProviderAccountLinkService accountLinkService;
    private final UserService userService;


    @Autowired
    public ExternalVendorConnectionController(OAuthClient oAuthClient, ProviderAuthConfigRegistry authConfigRegistry, ActivityProviderRepository providerRepository, ActivityProviderAccountLinkService accountLinkService, OAuthRequestFactory oAuthRequestFactory, UserService userService) {
        this.oAuthClient = oAuthClient;
        this.authConfigRegistry = authConfigRegistry;
        this.providerRepository = providerRepository;
        this.accountLinkService = accountLinkService;
        this.userService = userService;
    }

    @GetMapping("/{providerKey}")
    @RolesAllowed("swc-user")
    String createLinkToProvider(@PathVariable String providerKey, Principal userPrincipal) throws OAuthException {
        UUID subjectId = parseUserIdFromPrincipal(userPrincipal);
        ActivityProviders providerIdentifier = ActivityProviders.valueOf(providerKey.toUpperCase());
        log.debug("User requested link creation for {}. Trying to obtain Request Token from vendor API", providerIdentifier);
        OAuthProperties oAuthProperties = authConfigRegistry.configurationFor(providerIdentifier);
        OAuthAuthorizeTemporaryTokenUrl temporaryTokenUrl = oAuthClient.obtainTemporaryRequestToken(oAuthProperties);
        USER_ID_STORE.put(temporaryTokenUrl.temporaryToken, subjectId.toString());

        log.debug("Successfully retrieved Request Token from provider {}. Redirecting user to Login page now.", providerIdentifier);
        String redirectUrl = temporaryTokenUrl.build() + OAUTH_CALLBACK_LITERAL + oAuthProperties.getEncodedSuccessfulAuthorizationRedirectCallbackUrl();
        return "redirect:" + redirectUrl;
    }

    @GetMapping("/{providerKey}/authorization-granted")
    @RolesAllowed("swc-user")
    @Transactional
    public String obtainProviderAccessToken(@PathVariable String providerKey, @RequestParam(name = "oauth_token") String oauthToken, @RequestParam(name = "oauth_verifier") String oauthVerifier, @RequestParam(name = "redirect_to") String redirectTo) throws OAuthException, NoSuchAlgorithmException {
        ActivityProviders providerIdentifier = ActivityProviders.valueOf(providerKey.toUpperCase());
        ActivityProvider provider = providerRepository.findByProviderKey(providerIdentifier).orElseThrow();

        log.info("User authorized Temporary Request Token for provider {}. Now trying to obtain Access Token from vendor API.", providerKey);

        OAuthProperties oAuthProperties = authConfigRegistry.configurationFor(providerIdentifier);
        AccessTokenData accessTokenData = oAuthClient.obtainAccessToken(oauthToken, oauthVerifier, oAuthProperties);

        log.info("Obtained access token and secret from {}", providerIdentifier);

        String userId = USER_ID_STORE.get(oauthToken);
        User user = userService.findByKeycloakId(UUID.fromString(userId));

        USER_ID_STORE.remove(oauthToken);
        accountLinkService.createAccountLinkFor(user, provider, accessTokenData);

        log.info("The access token for provider {} was retrieved and persisted successfully. The user is now redirected back to the Smart Wearables UI.", provider.getProviderKey());
        return "redirect:" + redirectTo;
    }

    @DeleteMapping("/{provider}")
    @RolesAllowed("swc-user")
    @Transactional
    @ResponseBody
    public void removeLinkToProvider(@PathVariable ActivityProviders provider, Principal userPrincipal) throws IOException {
        UUID userId = parseUserIdFromPrincipal(userPrincipal);
        User user = userService.findByKeycloakId(userId);
        DeregistrationStrategy deregistrationStrategy = authConfigRegistry.deregistrationStrategyFor(provider);
        deregistrationStrategy.performDeregistration(userId.toString());
        accountLinkService.removeAccountLinkFor(provider, user);
    }

    @GetMapping("/{provider}/status")
    @RolesAllowed("swc-user")
    @ResponseBody
    @Transactional
    public Map<String, Boolean> connectionStatus(@PathVariable ActivityProviders provider, Principal userPrincipal) {
        UUID userId = parseUserIdFromPrincipal(userPrincipal);
        User user = userService.findByKeycloakId(userId);
        boolean exists = accountLinkService.existsByProviderAndUser(provider, user);
        Map<String, Boolean> status = new HashMap<>();
        status.put("connected", exists);
        return status;
    }

    private UUID parseUserIdFromPrincipal(Principal userPrincipal) {
        return UserIdHelper.parseUserIdFromPrincipal(userPrincipal);
    }
}
