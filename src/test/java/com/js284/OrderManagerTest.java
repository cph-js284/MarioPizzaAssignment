package com.js284;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

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
    List<Item> items;
    @BeforeEach
    public void SetUpAll(){
        items = Arrays.asList(
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

    @Test
    public void testRemoveOrderFromListWithOneOrder(){
        //start with empty list
        ArrayList<Order> orderlist  = orderManager.GetOrderList();
        assertEquals(0, orderlist.size());

        //add one to list
        orderManager.NewOrder(order);
        String idToRemove = order.GetId();

        assertEquals(1, orderlist.size());


        //remove specific from list
        orderManager.RemoveFromList(idToRemove);
        assertEquals(0, orderlist.size());
        
    }
    @Test
    public void testRemoveOrderFromListWithManyOrders(){
        //start with empty list
        ArrayList<Order> orderlist  = orderManager.GetOrderList();
        assertEquals(0, orderlist.size());

        //add many to list
        orderManager.NewOrder(new Order(items));
        orderManager.NewOrder(new Order(items));
        orderManager.NewOrder(new Order(items));
        assertEquals(3, orderlist.size());


        //remove specific from list
        String idToRemove = orderManager.GetOrderList().get(0).GetId(); // <- the train :(
        orderManager.RemoveFromList(idToRemove);
        assertEquals(2, orderlist.size());
        
    }
    
    
}