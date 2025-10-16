package com.localshop.customer.services.interfaces;

import com.localshop.customer.model.User;

public interface IGenerateEmailNotificationContentService {
    void generateContent(User user);
}
