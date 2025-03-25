package com.medisanaspace.healthx.dataloft.smartwearables.domain.provider;

import com.medisanaspace.healthx.dataloft.smartwearables.crypto.HashUtils;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.AccountLinkPropertySetter;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.AccountLinkPropertySetterFactory;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.oauth.AccessTokenData;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.User;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.auth.user.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;

import static org.mockito.Mockito.mock;

class ActivityProviderAccountLinkServiceTest {

    private final ActivityProviderAccountLinkService service = createServiceStub();

    private static final String ENCRYPTION_KEY = "S3cret123!";

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void createsLinkWithHashedToken(boolean saveTokenData) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeySpecException, InvalidKeyException {

        ActivityProvider provider = new ActivityProvider();
        provider.setPersistAccessToken(saveTokenData);

        String tokenValue = "123";
        String tokenSecret = "123-secret";
        AccessTokenData tokenData = AccessTokenData.of(tokenValue, tokenSecret, "key", "secret");

        User user = new User();
        user.setKeycloakId(UUID.randomUUID());

        ActivityProviderAccountLink link = service.createAccountLinkFor(user, provider, tokenData);

        String hashedToken = HashUtils.createSHA256Hash(tokenValue);

        Assertions.assertEquals(hashedToken, link.getAccessTokenSHA256());

        if(saveTokenData) {
            Assertions.assertEquals(tokenValue, link.getAccessToken());
            Assertions.assertEquals(tokenSecret, link.getAccessTokenSecret());
        } else {
            Assertions.assertNull(link.getAccessToken());
            Assertions.assertNull(link.getAccessTokenSecret());
        }
    }

    ActivityProviderAccountLinkService createServiceStub() {
        AccountLinkPropertySetterFactory dummySetterFactory = new AccountLinkPropertySetterFactory() {
            @Override
            public AccountLinkPropertySetter forProvider(ActivityProviders provider, AccessTokenData accessTokenData) {
                return link -> link.setExternalApiUserId(null);
            }
        };
        UserService userService = mock(UserService.class);
        return new ActivityProviderAccountLinkService(null, dummySetterFactory, userService) {
            @Override
            public ActivityProviderAccountLink save(ActivityProviderAccountLink entity) {
                return entity;
            }
        };
    }
}
