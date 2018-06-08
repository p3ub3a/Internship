package com.emagia.orderusv3;

import com.emagia.orderusv3.templates.Character;
import com.emagia.orderusv3.templates.Skill;
import com.emagia.orderusv3.battle.Battle;

public class GameRunner {

	public static void main(String[] args) {
		Character orderus = new Character("Orderus");
		Character theBeast = new Character("The Beast");
		
		String[] orderusStats = {"70-100","70-80","45-55","40-50","10-30"};
		String[] theBeastStats = {"60-90","60-90","40-60","40-60","25-40"};
		generateStats(orderus, orderusStats);
		generateStats(theBeast, theBeastStats);
				
		System.out.println(orderus.toString());
		System.out.println(theBeast.toString());
		
		orderus.addSkill(new Skill("RS"));
		orderus.addSkill(new Skill("MS"));
		
//		theBeast.addSkill(new Skill("skill1"));
//		theBeast.addSkill(new Skill("skill1"));
//		theBeast.addSkill(new Skill("skill2"));
//		theBeast.addSkill(new Skill("RS"));
//		theBeast.addSkill(new Skill("MS"));
//		theBeast.removeSkill("RS");
//		System.out.println(theBeast.getSkillList().toString());
		
		commenceBattle(orderus,theBeast);
		
	}
	
	public static void generateStats(Character character,String[] stats) {
		//health,strength,defense,speed,luck
		int[] statsToBeSet = new int[5];
		
		String[] singleStat;
		int lowerValue,higherValue;
		
		for(int i=0; i<stats.length;i++){
			singleStat = stats[i].split("-");
			lowerValue = Integer.parseInt(singleStat[0]);
			higherValue = Integer.parseInt(singleStat[1]);
			statsToBeSet[i] = (int) (lowerValue + Math.random() * (higherValue - lowerValue));	
		}
		
		character.setStats(statsToBeSet[0],statsToBeSet[1],statsToBeSet[2],statsToBeSet[3],statsToBeSet[4]);
	}
	
	public static void commenceBattle(Character character1, Character character2){
		if(character1.getStats().getSpeed() == character2.getStats().getSpeed()){
			if(character1.getStats().getLuck() > character2.getStats().getLuck()){
				run(character1,character2);
			}else{
				run(character2,character1);
			}
		}else if(character1.getStats().getSpeed() > character2.getStats().getSpeed()){
			run(character1,character2);
		}else{
			run(character2,character1);
		}
	}

	private static void run(Character firstPlayer,Character secondPlayer) {
		int phaseCounter = 1;
		boolean isGameOver = false;
		
		while (!isGameOver && phaseCounter <= 20){
			System.out.println("\n******** PHASE " + phaseCounter + " ********\n");
			
			if(phaseCounter%2 != 0){
				Battle.fight(firstPlayer, secondPlayer, isLucky(secondPlayer),isLucky(firstPlayer),isLucky(secondPlayer));
			}else{
				Battle.fight(secondPlayer, firstPlayer, isLucky(firstPlayer),isLucky(secondPlayer),isLucky(firstPlayer));
			}
			
			System.out.println("\n*************************");
			
			if(firstPlayer.getHealth() <= 0 || secondPlayer.getHealth() <= 0){
				isGameOver = true;
			}
			
			phaseCounter++;
		}
		
		if(isGameOver){
			System.out.println("\n******* GAME OVER *******\n");
			
			if(firstPlayer.getHealth() == 0){
				System.out.println(secondPlayer.getName() + " won the battle!");
			}
			
			if(secondPlayer.getHealth() == 0){
				System.out.println(firstPlayer.getName() + " won the battle!");
			}
			
			System.out.println("\n*************************");
		} else {
			System.out.println("Remiza frate");
		}
	}
	
	private static boolean isLucky(Character player) {
		int chance = (int) (Math.random() * 100);
		return player.getStats().getLuck() > chance;
	}
}
