package com.sample;

public class Person {

	private String name;
	private int money;
	private int score;
	private boolean dispo;
	
	Person(String name, int money, int score, boolean dispo){
		this.name = name;
		this.money = money;
		this.score = score;
		this.dispo = dispo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
			
	public boolean hasDispo() {
		return dispo;
	}

	public void setDispo(boolean dispo) {
		this.dispo = dispo;
	}

	public String toString(){
		return "Person:" +name + ".toString";
	}
	
	
}
