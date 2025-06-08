package com.jalvis.SciNet.services.interfaces;

import com.jalvis.SciNet.dtos.PaymentInfo;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.jalvis.SciNet.dtos.Purchase;
import com.jalvis.SciNet.dtos.PurchaseResponse;

public interface CheckOutService {

    PurchaseResponse placeOrder(Purchase order);
    PaymentIntent paymentIntent(PaymentInfo info) throws StripeException;
}
