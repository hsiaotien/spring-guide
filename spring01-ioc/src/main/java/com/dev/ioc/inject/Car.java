package com.dev.ioc.inject;

public class Car {
	private String color;
	private double price;
	private String brand;
	
	public Car(String color, double price, String brand) {
		super();
		this.color = color;
		this.price = price;
		this.brand = brand;
	}
	@Override
	public String toString() {
		return "Car [color=" + color + ", price=" + price + ", brand=" + brand
				+ "]";
	}
}
