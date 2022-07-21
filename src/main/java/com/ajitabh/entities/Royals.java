package com.ajitabh.entities;

import org.springframework.stereotype.Component;

public class Royals implements Team {
    @Override
    public String getName() {
        return "Kansas City Royals";
    }
}
