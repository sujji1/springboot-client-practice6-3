package com.example.demo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.*;

@Entity
public class Vechile {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int vid;
	private String vname;
	private String model;
	public Vechile() {
		
	}
	public Vechile(int vid, String vname, String model) {
		super();
		this.vid = vid;
		this.vname = vname;
		this.model = model;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	@Override
	public String toString() {
		return "Vechile [vid=" + vid + ", vname=" + vname + ", model=" + model + "]";
	}
	
}
