package com.localshop.customer.services.implementations;

import com.localshop.customer.model.User;
import com.localshop.customer.services.interfaces.INotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("emailNotificationService")
@Slf4j
public class EmailNotificationService implements INotificationService {
    @Override
    @Async
    public void notifyLogin(User user) {
        String content = prepareContent() + "email : " + user.getEmail();
        log.info(content);
    }
}
