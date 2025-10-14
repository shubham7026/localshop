package com.localshop.customer.persistence.interfaces;

import com.localshop.customer.enttity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<UserEntity, Integer> {
    UserEntity findByEmail(String email);
}
