package com.jalvis.SciNet.apicontrollers;

import com.jalvis.SciNet.dtos.PaymentInfo;
import com.jalvis.SciNet.dtos.Purchase;
import com.jalvis.SciNet.dtos.PurchaseResponse;
import com.jalvis.SciNet.services.interfaces.CheckOutService;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("https://localhost:4200")
@RequestMapping("/checkout")
public class PurchaseAPI {
    @Autowired
    private CheckOutService service;

    @PostMapping("purchase")
    public PurchaseResponse makePurchase(@RequestBody Purchase purchase){

        return service.placeOrder(purchase);

    }

    @PostMapping("payment_intent")
    public ResponseEntity<String> createIntent(@RequestBody PaymentInfo info) throws StripeException {
        PaymentIntent intent=service.paymentIntent(info);
        return new ResponseEntity<>(intent.toJson(), HttpStatus.OK);
    }

}
