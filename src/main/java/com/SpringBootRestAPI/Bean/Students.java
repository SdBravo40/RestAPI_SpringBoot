package com.SpringBootRestAPI.Bean;

//import java.time.LocalDate;

public class Students {
	
	private int id;
	private String name;
	//private LocalDate data;
	
	public Students(int id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
	

}
