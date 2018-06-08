package com.emagia.orderusv3.battle;

import com.emagia.orderusv3.templates.Character;
import com.emagia.orderusv3.templates.Skill;

public class Battle {
	
	public static void fight(Character attacker, Character defender, boolean defenderGotLucky, boolean canCastOffensiveSkill,boolean canCastDefensiveSkill){
		if(!defenderGotLucky){
			int damage = attacker.calculateDamage(defender);
			System.out.println(" ---> " + attacker.getName() + " initial damage: " + damage);
			
			if(canCastOffensiveSkill && !attacker.getSkillList().isEmpty()){
				for(Skill skill: attacker.getSkillList()){
					damage = skill.activateRapidStrike(damage, attacker);
					
				}
			}
			
			if(canCastDefensiveSkill && !defender.getSkillList().isEmpty()){
				for(Skill skill: defender.getSkillList()){
					damage = skill.activateMagicShield(damage, defender);
				}
			}
			
			System.out.println(" ---> Attacker damage:" +damage+ "; Defender health before the attack:" + defender.getHealth());
			if((defender.getHealth() - damage) <= 0){
				defender.setHealth(0);
			}else{
				defender.setHealth(defender.getHealth() - damage);
			}
			
			System.out.println(" ---> " + defender.getName() + " has " + defender.getHealth() + " health left");
		}else{
			System.out.println(attacker.getName() + " missed the target");
		}
	}
	
}

