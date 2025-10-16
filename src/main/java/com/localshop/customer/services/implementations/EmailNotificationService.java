package com.localshop.customer.services.implementations;

import com.localshop.customer.model.User;
import com.localshop.customer.services.interfaces.IGenerateEmailNotificationContentService;
import com.localshop.customer.services.interfaces.INotificationService;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;


@Slf4j
public class EmailNotificationService implements INotificationService {

    private final IGenerateEmailNotificationContentService generateEmailNotificationContentService;

    @Override
    @Async
    public void notifyLogin(User user) {
        String content = prepareContent() + "email : " + user.getEmail();
        log.info(content);
        generateEmailNotificationContentService.generateContent(user);
    }

    public EmailNotificationService(IGenerateEmailNotificationContentService generateEmailNotificationContentService){
        this.generateEmailNotificationContentService=generateEmailNotificationContentService;
    }

    @PostConstruct
    public void init(){
        System.out.println(this);
    }
}
