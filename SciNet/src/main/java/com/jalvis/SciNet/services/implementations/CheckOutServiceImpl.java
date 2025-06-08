package com.jalvis.SciNet.services.implementations;

import com.jalvis.SciNet.dtos.PaymentInfo;
import com.jalvis.SciNet.dtos.Purchase;
import com.jalvis.SciNet.dtos.PurchaseResponse;
import com.jalvis.SciNet.entities.User;
import com.jalvis.SciNet.repos.crud.interfaces.custom.UserCustomRepo;
import com.jalvis.SciNet.repos.crud.interfaces.jpa.User_JPA_Repo;
import com.jalvis.SciNet.services.interfaces.CheckOutService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

@Service
public class CheckOutServiceImpl implements CheckOutService {
    private User_JPA_Repo userRepo;
    private UserCustomRepo urp;
    private static final Logger logger= LoggerFactory.getLogger(CheckOutServiceImpl.class);
    @Autowired
    public CheckOutServiceImpl(User_JPA_Repo user, UserCustomRepo urp,
                               @Value("${stripe.key.gitsecret}") String secretKey){
        userRepo=user;
        this.urp=urp;
        Stripe.apiKey=secretKey;
    }

    @Override
    public PurchaseResponse placeOrder(Purchase purchase) {

        logger.debug("TOTAL PRICE: ",purchase.getOrder().getTotal_price());
        String tracking_code=generateRandomCode();
       purchase.getOrder().setTracking_code(tracking_code);
      purchase.getItems().forEach(item->{ purchase.getOrder().addItem(item);});
        User user=urp.getUserByEmail(purchase.getUser().getEmail());
        if(user==null) {
            user=purchase.getUser();
            user.addOrder(purchase.getOrder());
            urp.addUser(user);
        }
        else{
           user.addOrder(purchase.getOrder());
           userRepo.save(user);
        }


        return new PurchaseResponse(tracking_code );
    }

    @Override
    public PaymentIntent paymentIntent(PaymentInfo info) throws StripeException {
        List<String> paymentMethods=new ArrayList<>();
        paymentMethods.add("Card");
        Map<String, Object> paymentInfo=new HashMap<>();
        paymentInfo.put("amount", info.getAmount());
        paymentInfo.put("Currency", info.getCurrrency());
        paymentInfo.put("Payment_Methods", paymentMethods);
        return PaymentIntent.create(paymentInfo);
    }

    private String generateRandomCode(){
        return UUID.randomUUID().toString();
    }
}
