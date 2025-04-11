package com.jalvis.SciNet.dtos;

import lombok.Data;

@Data
public class PurchaseResponse {
    public PurchaseResponse(String code){
       setOrder_tracking_number(code);
    }
    private String order_tracking_number;

    public String getOrder_tracking_number() {
        return order_tracking_number;
    }

    public void setOrder_tracking_number(String order_tracking_number) {
        this.order_tracking_number = order_tracking_number;
    }


}

