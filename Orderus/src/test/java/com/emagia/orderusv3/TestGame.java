package com.emagia.orderusv3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.emagia.orderusv3.battle.Battle;
import com.emagia.orderusv3.templates.Character;
import com.emagia.orderusv3.templates.Skill;

public class TestGame {

	Character orderus = new Character("Orderus");
	Character theBeast = new Character("The Beast");
	
	@Before
	public void initializeCharacters(){
		String[] orderusStats = {"70-100","70-80","45-55","40-50","10-30"};
		String[] theBeastStats = {"60-90","60-90","40-60","40-60","25-40"};
		
		GameRunner.generateStats(orderus, orderusStats);
		GameRunner.generateStats(theBeast, theBeastStats);
		
		orderus.addSkill(new Skill("RS"));
		orderus.addSkill(new Skill("MS"));
	}
	
	@Test
	public void testStats(){
		assertTrue( (orderus.getHealth() >= 70 && orderus.getHealth() <= 100 ));
		assertTrue( (orderus.getStats().getStrength() >= 70 && orderus.getStats().getStrength() <= 80 ));
		assertTrue( (orderus.getStats().getDefense() >= 45 && orderus.getStats().getDefense() <= 55 ));
		assertTrue( (orderus.getStats().getSpeed() >= 40 && orderus.getStats().getSpeed() <= 50 ));
		assertTrue( (orderus.getStats().getLuck() >= 10 && orderus.getStats().getLuck() <= 30 ));
		
		assertTrue( (theBeast.getHealth() >= 60 && theBeast.getHealth() <= 90 ));
		assertTrue( (theBeast.getStats().getStrength() >= 60 && theBeast.getStats().getStrength() <= 90 ));
		assertTrue( (theBeast.getStats().getDefense() >= 40 && theBeast.getStats().getDefense() <= 60 ));
		assertTrue( (theBeast.getStats().getSpeed() >= 40 && theBeast.getStats().getSpeed() <= 60 ));
		assertTrue( (theBeast.getStats().getLuck() >= 25 && theBeast.getStats().getLuck() <= 40 ));
	}
	
	@Test
	public void testFight(){
		
		System.out.println("------------------- test fight -----------------------");
		
		int initialHealth = theBeast.getHealth();
		int damage = (orderus.getStats().getStrength() - theBeast.getStats().getDefense());
		
		//Character attacker, Character defender, boolean defenderGotLucky, boolean canCastOffensiveSkill,boolean canCastDefensiveSkill
		Battle.fight(orderus, theBeast, true, true, true);
		assertEquals(initialHealth, theBeast.getHealth());
		
		theBeast.setHealth(initialHealth);
		Battle.fight(orderus, theBeast, false, false, false);
		assertEquals(initialHealth - damage, theBeast.getHealth());
		
		theBeast.setHealth(initialHealth);
		Battle.fight(orderus, theBeast, false, true, false);
		assertEquals(initialHealth - 2*damage, theBeast.getHealth());
		
		theBeast.setHealth(initialHealth);
		Battle.fight(orderus, theBeast, false, true, true);
		assertEquals(initialHealth - 2*damage, theBeast.getHealth());
		
		System.out.println("-----------------------------------------------------\n");
	}
	
	@Test
	public void testSkills(){
		System.out.println("------------------ test skills ----------------------");
		int damage = 20, processedDamage;
		Skill skill = new Skill("MS");
		
		processedDamage = skill.activateMagicShield(damage, orderus);
		assertEquals(damage/2, processedDamage);
		
		damage=20;
		skill = new Skill("RS");
		processedDamage = skill.activateRapidStrike(damage, orderus);
		assertEquals(damage*2, processedDamage);
		
		System.out.println("-----------------------------------------------------\n");
	}
	
	@Test
	public void testRemoveSkill(){
		System.out.println("--------------- test remove skill -------------------");
		orderus.removeSkill("RS");
		assertEquals(1, orderus.getSkillList().size());
		orderus.removeSkill("MS");
		assertEquals(0, orderus.getSkillList().size());
		System.out.println("-----------------------------------------------------\n");
	}
	
	@Test
	public void testAddSkill(){
		System.out.println("---------------- test add skill ---------------------");
		orderus.removeSkill("RS");
		orderus.removeSkill("MS");
		
		orderus.addSkill(new Skill("NewSkill"));
		orderus.addSkill(new Skill("NewSkill"));
		assertEquals(1, orderus.getSkillList().size());
		
		theBeast.addSkill(new Skill("NewSkill"));
		theBeast.addSkill(new Skill("NewSkill"));
		assertEquals(1, theBeast.getSkillList().size());
		System.out.println("-----------------------------------------------------\n");
	}
}
