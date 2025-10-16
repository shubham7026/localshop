package com.localshop.customer.services.interfaces;

import com.localshop.customer.model.User;

public interface INotificationService {
    void notifyLogin(User user);
    default String prepareContent(){
        return getContent();
    }

    private String getContent(){
        return "a login transaction happen via ";
    }
}
