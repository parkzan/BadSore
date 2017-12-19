package com.example.parkzan.badsore;

import java.util.ArrayList;

/**
 * Created by ParkZan on 11/19/2017.
 */

public class Customer_select {
    ArrayList<String> name = new ArrayList<>();
    ArrayList<String> resId = new ArrayList<>();

    public Customer_select(){

    }
    public static void main(String[] args){
        Customer_select cus = new Customer_select();
        cus.name.add("นาย รังสิมันตุ์  ขอนแก่น");
        cus.name.add("นางสาว หญิง แสนดี");
        cus.resId.add("0714484895");
        cus.resId.add("0715479451");
    }

}
