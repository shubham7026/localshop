package com.localshop.customer.services.interfaces;

import com.localshop.customer.model.User;

public interface IUserApplicationService {
    void login(User id);

    User addUser(User user);
}
