package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String adress;
	@ManyToMany(cascade=CascadeType.ALL)
	List<Vechile> vechile = new ArrayList<>();
	public User() {
		
	}
	public User(int id, String name, String adress, List<Vechile> vechile) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.vechile = vechile;
	}
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public List<Vechile> getVechile() {
		return vechile;
	}
	public void setVechile(List<Vechile> vechile) {
		this.vechile = vechile;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", adress=" + adress + ", vechile=" + vechile + "]";
	}
	
}
