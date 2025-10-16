package com.localshop.customer.services.implementations;

import com.localshop.customer.model.User;
import com.localshop.customer.services.interfaces.INotificationService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;


@Slf4j
public class SMSNotificationService implements INotificationService {

    @Override
    @Async
    public void notifyLogin(User user) {
        String content = prepareContent() + "sms : " + user.getMobileNo();
        log.info(content);
    }
}
