package ru.midas.server.service.impl;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import ru.midas.server.exception.UserAlreadyExistsException;
import ru.midas.server.model.LoginBody;
import ru.midas.server.model.MidasUser;
import ru.midas.server.model.RegistrationBody;
import ru.midas.server.model.Role;
import ru.midas.server.repository.MidasUserRepository;
import ru.midas.server.service.EncryptionService;
import ru.midas.server.service.MidasUserService;

import java.util.*;

@Service
@RequiredArgsConstructor
public class MidasUserServiceImpl implements MidasUserService {

    private final MidasUserRepository userRepository;
    private final EncryptionService encryptionService;
    private static final Logger log = LoggerFactory.getLogger(MidasUserService.class);

    @Override
    public List<MidasUser> fetchAllUsers(){
        return userRepository.findAll();
    }

    @Override
    public MidasUser findUserById(Long id) {
        log.info("Searching for user by his id.");
        return userRepository.findUserById(id);
    }

    @Override
    public Optional<MidasUser> findUserByPhoneNumber(String phoneNumber) {
        return userRepository.findUserByPhoneNumber(phoneNumber);
    }

    @Override
    public MidasUser saveUser(MidasUser midasUser) {
        log.info(String.format("Saving new user with id %d to the database.", midasUser.getId()));
        return userRepository.save(midasUser);
    }

    @Override
    public MidasUser updateUser(MidasUser midasUser) {
        return userRepository.save(midasUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public void registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if(userRepository.findUserByPhoneNumber(registrationBody.getEmail()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        MidasUser user = new MidasUser();
        user.setPhoneNumber(registrationBody.getPhoneNumber());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));

        user.setName(registrationBody.getName());
        user.setEmail(registrationBody.getEmail());
        user.setRoles(Collections.singleton(Role.USER));
        user.setAddress(null);
        userRepository.save(user);
    }

    @Override
    public String loginUser(LoginBody loginBody) {
        return null;
    }


}
