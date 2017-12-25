package com.amazon.models;

public class Product {
private String title;
private double price;
private int quantity;

public Product(double price, String title) {
	this.price=price;
	this.title=title;
	}

public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getTotalPrice() {
	return price * quantity;
}
}
