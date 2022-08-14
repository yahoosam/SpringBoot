package com.curiousbinary;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout(String status) {
        //Below listed comments are individual aspects
        //logging
        //authentication & authorization
        //sanitize the data
        System.out.println("checkout method from ShoppingCart called...");
    }

    public int getQuantity() {
        return 10;
    }
}
