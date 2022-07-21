package com.ajitabh.entities;

import org.springframework.stereotype.Component;

public class Cubs implements Team {

    @Override
    public String getName() {
        return "Chicago Cubs";
    }
}
