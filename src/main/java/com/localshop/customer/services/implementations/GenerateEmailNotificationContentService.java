package com.localshop.customer.services.implementations;

import com.localshop.customer.model.User;
import com.localshop.customer.services.interfaces.IGenerateEmailNotificationContentService;
import jakarta.annotation.PostConstruct;

public class GenerateEmailNotificationContentService implements IGenerateEmailNotificationContentService {

    @Override
    public void generateContent(User user) {
        // do nothing
    }

    @PostConstruct
    public void init(){
        System.out.println(this);
    }
}
