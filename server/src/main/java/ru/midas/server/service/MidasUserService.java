package ru.midas.server.service;

import ru.midas.server.model.MidasUser;

import java.util.List;

public interface MidasUserService {
    List<MidasUser> fetchAllUsers();
    MidasUser findUserById(Long id);
    MidasUser saveUser(MidasUser midasUser);
    MidasUser updateUser(MidasUser midasUser);
    void deleteUser(Long id);

}
