package com.jalvis.SciNet.apicontrollers;

import com.jalvis.SciNet.dtos.Purchase;
import com.jalvis.SciNet.dtos.PurchaseResponse;
import com.jalvis.SciNet.services.interfaces.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin("https://localhost:4200")
@RequestMapping("/checkout")
public class PurchaseAPI {
    @Autowired
    private CheckOutService service;

    @PostMapping("purchase")
    public PurchaseResponse makePurchase(@RequestBody Purchase purchase){



        return service.placeOrder(purchase);

    }

}
