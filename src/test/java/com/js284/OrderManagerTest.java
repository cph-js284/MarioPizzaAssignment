package com.js284;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * Orders
 */
@RunWith(JUnitPlatform.class)
public class OrderManagerTest {

    Order order;
    OrderManager orderManager;

    @BeforeEach
    public void SetUpAll(){
        List<Item> items = Arrays.asList(
            new Item(1, "pizza1", 12.34),
            new Item(2, "pizza2", 22.34)
        );

        order = new Order(items);
        orderManager = new OrderManager();

    }


    @Test
    public void testEmptymanager(){

        ArrayList<Order> orderlist  = orderManager.GetOrderList();

        assertEquals(0, orderlist.size());
    }

    @Test
    public void testNotEmptymanager(){

        orderManager.NewOrder(order);
        
        ArrayList<Order> orderlist  = orderManager.GetOrderList();

        assertEquals(1, orderlist.size());
    }

    @Test
    public void testPrintOrderNewStatusOneOrder(){
        orderManager.NewOrder(order);

        String output = orderManager.Print(Order.Status.New);

        assertEquals("1-pizza1, 2-pizza2, \n", output);

    }

    @Test
    public void testPrintOrderNewStatusMoreOrders(){
        orderManager.NewOrder(order);
        orderManager.NewOrder(order);

        String output = orderManager.Print(Order.Status.New);

        assertEquals("1-pizza1, 2-pizza2, \n1-pizza1, 2-pizza2, \n", output);

    }

    @Test
    public void testPrintOrderDoneStatusOneOrders(){
        orderManager.NewOrder(order);
        orderManager.NewOrder(order);

        String output = orderManager.Print(Order.Status.Done);

        assertEquals("", output);

    }

    
}