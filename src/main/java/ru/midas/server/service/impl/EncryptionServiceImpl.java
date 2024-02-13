package ru.midas.server.service.impl;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import ru.midas.server.service.EncryptionService;

@Service
public class EncryptionServiceImpl implements EncryptionService {

    private String salt;

    @Value("${encryption.salt.rounds}")
    private String saltRounds;

    @Override
    @PostConstruct
    public void postConstruct() {
        salt = BCrypt.gensalt(Integer.parseInt(saltRounds));
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