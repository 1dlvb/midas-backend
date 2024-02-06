package ru.midas.server.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.midas.server.service.EncryptionService;

@Getter
@Setter
@Service
public class EncryptionServiceImpl implements EncryptionService {

    private String salt;

    @Value("${encryption.salt.rounds}")
    private int saltRounds;
    @Override
    @PostConstruct
    public void postConstruct() {
        salt = BCrypt.gensalt(saltRounds);
    }

    @Override
    public String encryptPassword(String password) {
        return BCrypt.hashpw(password, salt);
    }

    @Override
    public boolean verifyPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}
