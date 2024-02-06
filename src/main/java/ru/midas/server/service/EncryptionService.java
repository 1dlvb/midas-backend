package ru.midas.server.service;

import jakarta.annotation.PostConstruct;

public interface EncryptionService {

    @PostConstruct
    void postConstruct();
    String encryptPassword(String password);
    boolean verifyPassword(String password, String hash);
}
