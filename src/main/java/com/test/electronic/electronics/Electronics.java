package com.test.electronic.electronics;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="com1")
public class Electronics {
	
	
	private int id;
	private String name;
	private String category;
	private String price;

	
	
	public Electronics()
	{
		
	}
	
	
	public Electronics(int id, String name, String category, String price) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}
	

}