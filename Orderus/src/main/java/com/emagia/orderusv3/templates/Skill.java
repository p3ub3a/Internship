package com.emagia.orderusv3.templates;

public class Skill {
	private String name;
	
	public Skill(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public int activateRapidStrike(int damage, Character player){
		if(getName() == "RS"){
			System.out.println(" ---> " + player.getName() + " used Rapid Strike and the damage became: " + 2*damage);
			return 2*damage;
		}else{
			return damage;
		}
		
	}
	
	public int activateMagicShield(int damage, Character player){
		if(getName() == "MS"){
			System.out.println(" ---> " + player.getName() + " used Magic Shield and the damage became: " + damage/2);
			return damage/2;
		}else{
			return damage;
		}
	}

	@Override
	public String toString() {
		return "Skill [name=" + name + "]";
	}
}