package com.localshop.customer.services.implementations;

import com.localshop.customer.enttity.UserEntity;
import com.localshop.customer.exceptions.PasswordMissMatchedException;
import com.localshop.customer.exceptions.UserAlreadyExistException;
import com.localshop.customer.mapper.IMapUserEntityToUser;
import com.localshop.customer.mapper.IMapUserToUserEntity;
import com.localshop.customer.model.User;
import com.localshop.customer.persistence.interfaces.IUserRepository;
import com.localshop.customer.services.interfaces.IUserApplicationService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserApplicationService implements IUserApplicationService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IMapUserEntityToUser mapUserEntityToUser;

    @Autowired
    private IMapUserToUserEntity mapUserToUserEntity;

    @Override
    public void login(User user) {
        UserEntity userFound =  iUserRepository.findByEmail(user.getEmail());

        if (userFound == null){
            log.error("entity with email: {} not found", user.getEmail());
            throw new EntityNotFoundException();
        }

        if (!userFound.getPassword().equals(user.getPassword())){
            log.error("Password is incorrect");
            throw new PasswordMissMatchedException("Password is incorrect");
        }

    }

    @Override
    public User addUser(User user) {

        UserEntity foundUser = getUserByEmail(user.getEmail());
        if (foundUser!=null){
            throw new UserAlreadyExistException("user exists");
        }

        UserEntity userEntity = iUserRepository.save(mapUserToUserEntity.map(user));
        return mapUserEntityToUser.map(userEntity);
    }

    private UserEntity getUserByEmail(String email){
        UserEntity user = iUserRepository.findByEmail(email);
        return user;
    }
}
