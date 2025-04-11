package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.dtos.Purchase;
import com.jalvis.SciNet.dtos.PurchaseResponse;
import com.jalvis.SciNet.repos.crud.interfaces.jpa.User_JPA_Repo;
import com.jalvis.SciNet.services.interfaces.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CheckOutServiceImpl implements CheckOutService {
    private User_JPA_Repo userRepo;

    @Autowired
    public CheckOutServiceImpl(User_JPA_Repo user){
        userRepo=user;
    }

    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {


        String tracking_code=generateRandomCode();
       purchase.getOrder().setTracking_code(tracking_code);
       purchase.getUser().addOrder(purchase.getOrder());
       userRepo.save(purchase.getUser());

        return new PurchaseResponse(tracking_code);
    }

    private String generateRandomCode(){
        return UUID.randomUUID().toString();
    }
}
