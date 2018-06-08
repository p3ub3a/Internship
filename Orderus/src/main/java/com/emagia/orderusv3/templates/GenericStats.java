package com.emagia.orderusv3.templates;

public class GenericStats{
	private final int strength; 
	private final int defense; 
	private final int speed; 
	private final int luck; 

	GenericStats(int str,int def,int spd,int lck){
		strength=str;
		defense=def;
		speed=spd;
		luck=lck;
	}
	
	public int getStrength() {
		return strength;
	}
	
	public int getDefense() {
		return defense;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getLuck() {
		return luck;
	}
	
	@Override
	public String toString() {
		return "GenericStats [strength=" + strength + ", defense=" + defense + ", speed=" + speed
				+ ", luck=" + luck;
	}
}

