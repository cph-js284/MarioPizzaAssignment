package com.js284;

/**
 * Item
 */
public class Item {

    
	private int Id;
    private String Text;
    private double Price;


    public Item(int id, String str, double price) {
        this.Id = id;
        this.Text = str;
        this.Price = price;
    }


	public int GetId() {
		return this.Id;
	}

	public String GetText() {
		return this.Text;
	}

	public Double GetPrice() {
		return this.Price;
	}

}