package ru.midas.server.service;

import ru.midas.server.model.LoginBody;
import ru.midas.server.model.RegistrationBody;
import ru.midas.server.exception.UserAlreadyExistsException;
import ru.midas.server.model.MidasUser;

import java.util.List;
import java.util.Optional;

public interface MidasUserService {
    List<MidasUser> fetchAllUsers();
    MidasUser findUserById(Long id);
    Optional<MidasUser> findUserByPhoneNumber(String phoneNumber);
    MidasUser saveUser(MidasUser midasUser);
    MidasUser updateUser(MidasUser midasUser);
    void registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException;
    String loginUser(LoginBody loginBody);
    void deleteUser(Long id);

}
