package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.services.interfaces.ConfirmationTokenService;
import com.jalvis.SciNet.entities.ConfirmationToken;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfirmationTokenServiceImpl {
    private ConfirmationTokenService service;

    @Autowired
    public ConfirmationTokenServiceImpl(ConfirmationTokenService service){
        this.service=service;
    }

    public void saveToken(ConfirmationToken token){
        service.save(token);
    }
}
