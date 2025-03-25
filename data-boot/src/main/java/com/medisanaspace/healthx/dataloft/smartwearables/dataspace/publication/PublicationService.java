package com.medisanaspace.healthx.dataloft.smartwearables.dataspace.publication;

import com.medisanaspace.healthx.dataloft.smartwearables.domain.activity.Activity;
import com.medisanaspace.healthx.dataloft.smartwearables.domain.base.entity.AbstractEntityService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;
import java.util.UUID;

@Service
public class PublicationService extends AbstractEntityService<Publication, UUID, PublicationRepository> {

    public static final String ARGON_2_ID_PREFIX = "$argon2id";
    private static final Random random = new Random();

    @Value("${datatransfer.url.template}")
    String dataTransferUrlTemplate;

    private final Argon2PasswordEncoder passwordEncoder;

    public PublicationService(PublicationRepository repository) {
        super(repository);
        this.passwordEncoder = Argon2PasswordEncoder.defaultsForSpringSecurity_v5_8();
    }

    @Transactional
    public Publication publish(UUID publicationId, UUID userId, Activity activity) {
        String username = UUID.randomUUID().toString();
        String password = generatePassword(20);
        String url = dataTransferUrlTemplate.formatted(activity.getId());
        Publication plainPwPublication = Publication.of(publicationId, userId, activity, url, username, password);
        Publication publication = Publication.of(publicationId, userId, activity, url, username, password);
        save(publication);
        return plainPwPublication;
    }

    @Transactional
    public void unpublish(UUID publicationId, UUID userId) {
        repository.deleteByPublicationIdAndUserId(publicationId, userId);
    }

    @Transactional
    public void suspend(UUID publicationId, UUID userId) {
        repository.setSuspended(publicationId, userId, true);
    }

    @Transactional
    public void unsuspend(UUID publicationId, UUID userId) {
        repository.setSuspended(publicationId, userId, false);
    }

    public boolean publicationExistsFor(UUID publicationId, UUID userId) {
        return repository.existsByPublicationIdAndUserId(publicationId, userId);
    }

    private static String generatePassword(int length) {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789ß-_.?,!";
        StringBuilder sb = new StringBuilder(length);
        random.ints(length, 0, chars.length()).forEach(index -> sb.append(chars.charAt(index)));
        return sb.toString();
    }

    @Override
    public Publication save(Publication entity) {
        boolean passwordIsNotHashed = !entity.getPassword().startsWith(ARGON_2_ID_PREFIX);
        if (passwordIsNotHashed) {
            entity.setPassword(passwordEncoder.encode(entity.getPassword()));
        }
        return super.save(entity);
    }
}
