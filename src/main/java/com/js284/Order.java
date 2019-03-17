package com.js284;

import java.util.List;
import java.util.UUID;

/**
 * Order
 */



public class Order {

    private List<Item> items;
    private Status status;
    private String uuid;

    public enum Status  {
        New,
        Done,
        Pickedup
    }
    
    public Order(List<Item> items) {
        this.items=items;
        this.status = Status.New;
        this.uuid = UUID.randomUUID().toString();
    }

    public List<Item> GetItems(){
        return items;
    }

	public void SetStatus(Status Newstatus) {
        this.status = Newstatus;
	}

	public Status GetStatus() {
		return this.status;
	}

	public String GetId() {
		return uuid;
	}

}