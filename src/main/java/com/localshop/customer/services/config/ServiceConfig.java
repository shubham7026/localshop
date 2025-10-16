package com.localshop.customer.services.config;

import com.localshop.customer.services.implementations.*;
import com.localshop.customer.services.interfaces.IGenerateEmailNotificationContentService;
import com.localshop.customer.services.interfaces.INotificationService;
import com.localshop.customer.services.interfaces.IProductApplicationService;
import com.localshop.customer.services.interfaces.IUserApplicationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.beans.PropertyEditorSupport;

@Configuration
public class ServiceConfig {

    @Bean
    public IGenerateEmailNotificationContentService generateEmailNotificationContentService(){
        return new GenerateEmailNotificationContentService();
    }

    @Bean(name = {"emailNotificationService"})
    public INotificationService emailNotificationService(){
        return new EmailNotificationService(generateEmailNotificationContentService());
    }

    @Bean(name = {"smsNotificationService"})
    public INotificationService smsNotificationService(){
        return new SMSNotificationService();
    }

    @Bean(name={"userApplicationService"})
    public IUserApplicationService userApplicationService(){
        return new UserApplicationService();
    }

    @Bean(name={"productApplicationService"})
    public IProductApplicationService productApplicationService(){
        return new ProductApplicationService();
    }

    @Bean("customPropertyEditor")
    public PropertyEditorSupport propertyEditorSupport(){
        return new PropertyEditor();
    }
}
