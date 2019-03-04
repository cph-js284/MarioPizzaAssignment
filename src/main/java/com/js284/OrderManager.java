package com.js284;

import java.util.*;

import com.js284.Order.Status;

/**
 * Orderlist
 */
public class OrderManager {

    ArrayList<Order> orders;

    public OrderManager() {
        orders = new ArrayList<>();
    }

	public ArrayList<Order> GetOrderList() {
		return orders;
	}

	public void NewOrder(Order order) {
        orders.add(order);
	}

	public String Print(Status filter) {
        String output = "";

        for (Order order : orders) {
            if (order.GetStatus() != filter)
                continue; //to avoid nesting
            for (Item item : order.GetItems()) {
                output += item.GetId() + "-" + item.GetText() + ", ";
            }    
            output +="\n";
        }
        return output;
	}

}