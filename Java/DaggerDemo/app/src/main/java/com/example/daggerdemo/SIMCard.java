package com.example.daggerdemo;

import javax.inject.Inject;

class SIMCard {
    private ServiceProvider serviceProvider;

    @Inject
    public SIMCard(ServiceProvider serviceProvider) {
        this.serviceProvider=serviceProvider;
    }
}
