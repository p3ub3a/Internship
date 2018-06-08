package com.emagia.orderusv3.templates;

import java.util.ArrayList;
import java.util.List;

public class Character{
	
	private final String name;
	
	private GenericStats stats;
	private int health;
	
	private List<Skill> skillList = new ArrayList<>();

	public Character(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public GenericStats getStats(){
		return stats;
	}
	
	public void setStats(int hp,int str,int def,int spd,int lck){
		health = hp;
		stats = new GenericStats(str,def,spd,lck);
	}
	
	public void addSkill(Skill skill){
		boolean isSkillPresent=false;
		
		if(!getSkillList().isEmpty()){
			for(Skill skillInList: getSkillList()){
				if(skillInList.getName().equals(skill.getName())){
					System.out.println(skill.getName() + "<" + getName()+ ">" + " already in skill list");
					isSkillPresent=true;
					break;
				}
			}
		}
		
		if(!isSkillPresent)	skillList.add(skill);
	}
	
	public void removeSkill(String skillName){
		if(!getSkillList().isEmpty()){
			for(Skill skill: getSkillList()){
				if(skill.getName().equals(skillName)){
					skillList.remove(skill);
					
					System.out.println(skillName + " has been removed from " + getName());
					break;
				}
			}
		}
	}
	
	public List<Skill> getSkillList() {
		return skillList;
	}
	
	public int calculateDamage(Character defender){
		int damage = getStats().getStrength() - defender.getStats().getDefense();
		return damage;
	}
	
	@Override
	public String toString() {
		return getName()+ " [health=" + health + ", strength=" + stats.getStrength() + ", defense=" + stats.getDefense() + ", speed=" + stats.getSpeed()
				+ ", luck=" + stats.getLuck() + "]";
	}
}
