package com.viniweb.boot.model;

import java.util.Date;

public class Team {

	private long id;	
	private String name;	
	private String city;
	private String owner;
	private int stadiumCapacity;
	private String competition; 
	private int numberOfPlayers;
	private String dateOfCreation;//TODO convert as java.util.Date
	
	public Team(){
		id=0;
	}
	
	public Team(long id, String name,String city, String owner, int stadiumCapacity,  String competition,
			int numberOfPlayers, String dateOfCreation){
		this.id = id;
		this.name = name;
		this.city = city;
		this.owner = owner;		
		this.stadiumCapacity = stadiumCapacity;
		this.competition = competition;
		this.numberOfPlayers = numberOfPlayers;
		this.dateOfCreation = dateOfCreation;		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getStadiumCapacity() {
		return stadiumCapacity;
	}

	public void setStadiumCapacity(int stadiumCapacity) {
		this.stadiumCapacity = stadiumCapacity;
	}

	public String getCompetition() {
		return competition;
	}

	public void setCompetition(String competition) {
		this.competition = competition;
	}

	public int getNumberOfPlayers() {
		return numberOfPlayers;
	}

	public void setNumberOfPlayers(int numberOfPlayers) {
		this.numberOfPlayers = numberOfPlayers;
	}

	
	

	public String getDateOfCreation() {
		return dateOfCreation;
	}

	public void setDateOfCreation(String dateOfCreation) {
		this.dateOfCreation = dateOfCreation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Team other = (Team) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {	
		return "Team [name=" + name + ", city=" + city + ", owner=" + owner + ", stadiumCapacity= "+ stadiumCapacity 
				+ ", competition ="+ competition + ", numberOfPlayers="+ numberOfPlayers +", dateOfCreation= "+ dateOfCreation+"]";				
	}
}