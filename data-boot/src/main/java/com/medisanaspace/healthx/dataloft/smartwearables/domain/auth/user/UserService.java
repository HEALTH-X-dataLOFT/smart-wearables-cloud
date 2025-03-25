package com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user;

import com.medisanaspace.healthx.dataloft.smartwearables.auth.SwcAuthToken;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntityService;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.provider.thryve.ThryveClient;
import com.medisanaspace.healthx.dataloft.smartwearables.keycloak.KeycloakClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.OidcUserInfo;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@Slf4j
public class UserService extends AbstractEntityService<User, UUID, UserRepository> {
    private final ThryveClient thryveClient;
    private final KeycloakClient keycloakClient;

    public UserService(UserRepository repository,
                       ThryveClient thryveClient,
                       KeycloakClient keycloakClient) {
        super(repository);
        this.thryveClient = thryveClient;
        this.keycloakClient = keycloakClient;
    }

    public User currentUser() {
        return findByKeycloakId(getCurrentUserId());
    }

    private static Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public static UUID getCurrentUserId() {
        return ((SwcAuthToken) getAuthentication()).getId();
    }

    @EventListener
    @Transactional
    public void onSuccess(InteractiveAuthenticationSuccessEvent event) {
        var authentication = (OAuth2AuthenticationToken) event.getAuthentication();
        log.info("User {} successfully logged in", authentication.getName());

        var principal = (DefaultOidcUser) authentication.getPrincipal();
        var userInfo = principal.getUserInfo();
        var subject = (String) principal.getClaims().get("sub");
        UUID userId = UUID.fromString(subject);
        if (!repository.existsByKeycloakId(userId)) {
            createNewUser(userId, userInfo);
            log.info("Created new user '{}'", authentication.getName());
        }
    }

    private void createNewUser(UUID id, OidcUserInfo userInfo) {
        var user = new User();
        user.setFirstName(userInfo.getGivenName());
        user.setLastName(userInfo.getFamilyName());
        user.setKeycloakId(id);

        user = save(user);
        var thryveToken = thryveClient.getAccessTokenFor(user);
        user.setThryveToken(thryveToken);

        save(user);
    }

    public User findByKeycloakId(UUID keycloakId) {
        return repository.findByKeycloakId(keycloakId).orElseThrow();
    }

    @Transactional
    public void deleteUser(User user) {
        thryveClient.deleteUser(user);
        keycloakClient.deleteUser(user);
        delete(user);
    }
}
