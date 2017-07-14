package domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by i20762 on 7/13/2017.
 */
public class Customer {
    String lastName;
    String addressCity;
    String addressState;
    Collection<SiteVisit> siteVisits;
    Collection<Order> orders;


    public Customer(String lastName, String addressCity, String addressState) {
        this.lastName = lastName;
        this.addressCity = addressCity;
        this.addressState = addressState;
        siteVisits = new ArrayList<SiteVisit>();
        orders= new ArrayList<Order>();
    }

    public  void addOrder(Order order){
        orders.add(order);
    }



}
