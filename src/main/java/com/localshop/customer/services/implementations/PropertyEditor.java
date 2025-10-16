package com.localshop.customer.services.implementations;

import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.beans.PropertyEditorSupport;

@Component
public class PropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String str){
        super.setValue(88899211);
    }

}
