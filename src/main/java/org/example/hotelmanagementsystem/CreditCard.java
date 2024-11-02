package org.example.hotelmanagementsystem;

public class CreditCard implements Payment {

    @Override
    public boolean processPayment(Double toPay) {
        return false;
    }
}
