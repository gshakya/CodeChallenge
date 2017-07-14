package service;

import domain.Customer;
import domain.Order;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by i20762 on 7/13/2017.
 */
public class Ingestor {
    HashMap<String, Customer> customerHashMap = new HashMap<String, Customer>();

    public void build(String fileName) throws JSONException {
        FileScrubber fs = new FileScrubber();
        String fileText= fs.getFileString(fileName);
        JSONArray ja = new JSONArray(fileText);
        for (int i = 0; i < ja.length(); i++) {
            JSONObject jsonobject = ja.getJSONObject(i);
            String type = jsonobject.getString("type");
            if (type == "CUSTOMER"){
                String customerID= jsonobject.getString("key");
                String lastName = jsonobject.getString("last_name");
                String city = jsonobject.getString("adr_city");
                String state = jsonobject.getString("adr_state");

                if (!customerHashMap.containsKey(customerID)){
                    customerHashMap.put(customerID, new Customer(lastName,city,state));
                }
            }
            if(type == "ORDER"){
                String customerID= jsonobject.getString("customer_id");
                float totalAmt= Float.parseFloat(jsonobject.getString("total_amount").replace(" USD",""));
                if (!customerHashMap.containsKey(customerID)){
                   Customer c = customerHashMap.get(customerID);
                   c.addOrder(new Order(totalAmt));
                }
            }

        }
    }

}
