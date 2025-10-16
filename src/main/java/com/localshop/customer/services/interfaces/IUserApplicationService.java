package com.localshop.customer.services.interfaces;

import com.localshop.customer.model.User;

public interface IUserApplicationService {
    void login(User user);

    void login(String email, String password);

    User addUser(User user);
}
