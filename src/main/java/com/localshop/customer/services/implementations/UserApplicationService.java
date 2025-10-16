package com.localshop.customer.services.implementations;

import com.localshop.customer.entity.UserEntity;
import com.localshop.customer.exceptions.PasswordMissMatchedException;
import com.localshop.customer.exceptions.UserAlreadyExistException;
import com.localshop.customer.mapper.IMapUserEntityToUser;
import com.localshop.customer.mapper.IMapUserToUserEntity;
import com.localshop.customer.model.User;
import com.localshop.customer.persistence.interfaces.IUserRepository;
import com.localshop.customer.services.interfaces.INotificationService;
import com.localshop.customer.services.interfaces.IUserApplicationService;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
public class UserApplicationService implements IUserApplicationService {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IMapUserEntityToUser mapUserEntityToUser;

    @Autowired
    private IMapUserToUserEntity mapUserToUserEntity;

    @Autowired
    @Qualifier("smsNotificationService")
    private INotificationService smsNotificationService;

    @Qualifier("emailNotificationService")
    @Autowired
    private INotificationService emailNotificationService;

    @Override
    public void login(User user) {
        UserEntity userFound = getByEmailOrPhoneNo(user);

        if (userFound == null){
            log.error("entity with email/mobileNo: {} / {} not found", user.getEmail(),user.getMobileNo());
            throw new EntityNotFoundException();
        }

        if (!userFound.getPassword().equals(user.getPassword())){
            log.error("Password is incorrect");
            throw new PasswordMissMatchedException("Password is incorrect");
        }

        log.info("logged in successfully");

        if (user.getEmail()!=null){
            emailNotificationService.notifyLogin(user);
        }

        if (user.getMobileNo()!=null){
            smsNotificationService.notifyLogin(user);
        }

    }

    @Override
    public void login(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        login(user);
    }

    private UserEntity getByEmailOrPhoneNo(User user) {

        if (null != user.getEmail()){
            return iUserRepository.findByEmail(user.getEmail());
        }else{
            return iUserRepository.findByMobileNo(user.getMobileNo());
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
        return iUserRepository.findByEmail(email);
    }
}
