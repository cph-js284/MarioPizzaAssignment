package com.js284;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public final class App {
    private App() {
    }

    public static void uiMenu(){
        System.out.println("Options:");
        System.out.println("------------------------------------------");
        System.out.println("exit\tExit system");
        System.out.println("1\tPlace new order");
        System.out.println("2\tShow orders");
        System.out.println("3\tRemove order");
    }

    public static void main(String[] args) {
        OrderManager ordermng = new OrderManager();
        String inputString = "";
        String idToRemovestr = "";
        

        uiMenu();
        /*UI-loop */
        while(true){
            inputString = System.console().readLine().toLowerCase().trim();
            
            if(inputString.equals("exit"))
                System.exit(1);
            
            if(inputString.equals("1")){
                try {
                    System.out.println("Placing new order");
                    System.out.println("------------------------------------------");
                    System.out.print("Type ID:");
                    int id = Integer.parseInt(System.console().readLine());
                    System.out.print("Type TEXT:");
                    String str = System.console().readLine();
                    System.out.print("Type PRICE:");
                    double price = Double.parseDouble(System.console().readLine());
                    Item item = new Item(id, str, price);
    
                    List<Item> items = Arrays.asList(item);
                    Order order = new Order(items);
                    ordermng.NewOrder(order);
                    System.out.println("------------------------------------------");
                    System.out.println("Order Placed");
                    System.out.println("------------------------------------------");
                    uiMenu();
                        
                } catch (Exception e) {
                    System.out.println("------------------------------------------");
                    System.out.println("------------------------------------------");
                    System.out.println("Invalid input - order not placed");
                    System.out.println("------------------------------------------");
                    System.out.println("------------------------------------------");
                    uiMenu();
                }//try
            }//if

            if(inputString.equals("2")){
                System.out.println("Orders in system");
                for (Order order : ordermng.GetOrderList()) {
                    System.out.println("OrderID : " + order.GetId());
                    System.out.println("Order item(s): ");
                        for (Item orderitem : order.GetItems()) {
                            System.out.println("ItemID \t\t" + orderitem.GetId());
                            System.out.println("ItemTEXT \t" + orderitem.GetText());
                            System.out.println("ItemPRICE \t" + orderitem.GetPrice());
                        }
                    System.out.println("------------------------------------------");
                }
            }//if
            
            if(inputString.equals("3")){
                try {
                    System.out.println("Enter orderID:");
                    idToRemovestr = System.console().readLine().toLowerCase().trim();
                    ordermng.RemoveFromList(idToRemovestr);
                    System.out.println("------------------------------------------");
                    System.out.println("Order removed");
                    System.out.println("------------------------------------------");
                    
                } catch (Exception e) {
                    System.out.println("------------------------------------------");
                    System.out.println("------------------------------------------");
                    System.out.println("Invalid input - order not removed");
                    System.out.println("------------------------------------------");
                    System.out.println("------------------------------------------");
                    uiMenu();
                }
            }//if
    


        }
    }
}
