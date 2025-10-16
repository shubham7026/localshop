package com.localshop.customer.services.implementations;

import jakarta.annotation.PostConstruct;

import java.beans.PropertyEditorSupport;


public class PropertyEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String str){
        super.setValue(88899211);
    }

}
