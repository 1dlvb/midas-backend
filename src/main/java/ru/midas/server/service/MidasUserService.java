package ru.midas.server.service;

import ru.midas.server.api.model.LoginBody;
import ru.midas.server.api.model.RegistrationBody;
import ru.midas.server.exception.UserAlreadyExistsException;
import ru.midas.server.model.MidasUser;

import java.util.List;

public interface MidasUserService {
    List<MidasUser> fetchAllUsers();
    MidasUser findUserById(Long id);
    MidasUser saveUser(MidasUser midasUser);
    MidasUser updateUser(MidasUser midasUser);
    void registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException;
    String loginUser(LoginBody loginBody);
    void deleteUser(Long id);

}
