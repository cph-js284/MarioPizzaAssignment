package com.js284;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

/**
 * ItemTest
 */
@RunWith(JUnitPlatform.class)
public class ItemTest {

    @Test
    public void testGetItemData(){
        int id = 1;

        String str = "text";
        double price = 12.25;

        Item item = new Item(id, str, price);

        assertEquals(id, item.GetId());
        assertEquals(str, item.GetText());
        assertEquals(price, item.GetPrice());
    }
    @Test
    public void testGetAnotherItemData(){
        int id = 2;

        String str = "text version 2";
        double price = 22.25;

        Item item = new Item(id, str, price);

        assertEquals(id, item.GetId());
        assertEquals(str, item.GetText());
        assertEquals(price, item.GetPrice());
    }





}