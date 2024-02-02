package ru.midas.server.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.midas.server.model.MidasUser;
import ru.midas.server.repository.MidasUserRepository;
import ru.midas.server.service.MidasUserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MidasUserServiceImpl implements MidasUserService {
    @NonNull
    private final MidasUserRepository repository;

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


}
