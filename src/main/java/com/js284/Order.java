package com.js284;

import java.util.List;

/**
 * Order
 */



public class Order {

    private List<Item> items;
    private Status status;

    public enum Status  {
        New,
        Done,
        Pickedup
    }
    
    public Order(List<Item> items) {
        this.items=items;
        this.status = Status.New;
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
}