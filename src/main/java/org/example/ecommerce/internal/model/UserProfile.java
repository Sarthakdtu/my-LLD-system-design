package org.example.ecommerce.internal.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UserProfile {
    private List<Order> orderHistory;
    private List<String> addresses;
    private String currentAddress;

    private String mobileNumber;


    public UserProfile() {
        orderHistory = new ArrayList<>();
        addresses = new ArrayList<>();
        currentAddress = "";
        mobileNumber = "";
    }

    public void setCurrentAddress(String currentAddress) {
        if(!addresses.contains(currentAddress)){
            addresses.add(currentAddress);
        }
        this.currentAddress = currentAddress;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<Order> getOrderHistory() {
        return orderHistory;
    }

    public void addAddresses(String address) {
        this.addresses.add(address);
    }

    public void addOrder(Order order) {
        orderHistory.add(order);
    }
}
