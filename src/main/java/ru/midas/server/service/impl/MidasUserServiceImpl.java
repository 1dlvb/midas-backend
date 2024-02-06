package ru.midas.server.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.midas.server.api.model.LoginBody;
import ru.midas.server.api.model.RegistrationBody;
import ru.midas.server.exception.UserAlreadyExistsException;
import ru.midas.server.model.MidasUser;
import ru.midas.server.repository.MidasUserRepository;
import ru.midas.server.service.EncryptionService;
import ru.midas.server.service.JWTService;
import ru.midas.server.service.MidasUserService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MidasUserServiceImpl implements MidasUserService {
    @NonNull
    private final MidasUserRepository repository;
    @NonNull
    private final EncryptionService encryptionService;
    @NonNull
    private final JWTService jwtService;

    @Override
    public List<MidasUser> fetchAllUsers(){
        return repository.findAll();
    }

    @Override
    public MidasUser findUserById(Long id) {
        return repository.findUserById(id);
    }

    @Override
    public MidasUser saveUser(MidasUser midasUser) {
        return repository.save(midasUser);
    }

    @Override
    public MidasUser updateUser(MidasUser midasUser) {
        return repository.save(midasUser);
    }

    @Override
    public void deleteUser(Long id) {
        repository.delete(this.findUserById(id));
    }
    @Override
    public void registerUser(RegistrationBody registrationBody) throws UserAlreadyExistsException {
        if(repository.findMidasUserByEmail(registrationBody.getEmail()).isPresent() ||
                repository.findMidasUserByUsernameIgnoreCase(registrationBody.getUsername()).isPresent()){
            throw new UserAlreadyExistsException();
        }
        MidasUser user = new MidasUser();
        user.setEmail(registrationBody.getEmail());
        user.setUsername(registrationBody.getUsername());
        user.setFirstName(registrationBody.getFirstName());
        user.setLastName(registrationBody.getLastName());
        user.setPhoneNumber(registrationBody.getPhoneNumber());
        user.setPassword(encryptionService.encryptPassword(registrationBody.getPassword()));

        repository.save(user);
    }
    @Override
    public String loginUser(LoginBody loginBody){
        Optional<MidasUser> userOptional = repository.findMidasUserByEmail(loginBody.getEmail());

        if(userOptional.isPresent()){
            MidasUser user = userOptional.get();
            if (encryptionService.verifyPassword(loginBody.getPassword(), user.getPassword())){
                return jwtService.generateJWT(user);
            }
        }
        return null;
    }
}
