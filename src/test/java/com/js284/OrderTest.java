package com.js284;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * OrderTest
 */
@RunWith(JUnitPlatform.class)

public class OrderTest {

    @Test
    public void testCreateOrder(){
        List<Item> items = Arrays.asList(
            new Item(1, "pizza1", 12.34),
            new Item(2, "pizza2", 22.34)
        );

        Order order = new Order(items);

        assertArrayEquals(items.toArray(), order.GetItems().toArray());
    }

    @Test
    public void testUpdateStatus(){
        List<Item> items = Arrays.asList(
            new Item(1, "pizza1", 12.34),
            new Item(2, "pizza2", 22.34)
        );

        Order order = new Order(items);
        order.SetStatus(Order.Status.Done);

        assertEquals(Order.Status.Done, order.GetStatus());
    }
    @Test
    public void testDefaultStatus(){
        List<Item> items = Arrays.asList(
            new Item(1, "pizza1", 12.34),
            new Item(2, "pizza2", 22.34)
        );

        Order order = new Order(items);

        assertEquals(Order.Status.New, order.GetStatus());
    }
    
}