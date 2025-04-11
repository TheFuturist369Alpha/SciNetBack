package com.jalvis.SciNet.services.interfaces;

import com.jalvis.SciNet.dtos.Purchase;
import com.jalvis.SciNet.dtos.PurchaseResponse;

public interface CheckOutService {

    PurchaseResponse placeOrder(Purchase order);
}
