package com.sample;

public class Request {
	
	private int id;
	private Person requester;
	private boolean valid = true;
	private int amount;
	
	Request(int id, int amount, Person requester){
		this.id = id;
		this.amount=amount;
		this.requester = requester;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Person getRequester() {
		return requester;
	}
	public void setRequester(Person requester) {
		this.requester = requester;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
	

}
