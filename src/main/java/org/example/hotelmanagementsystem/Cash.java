package org.example.hotelmanagementsystem;

public class Cash implements Payment {

    @Override
    public boolean processPayment(Double toPayy) {
        return true;
    }
}
