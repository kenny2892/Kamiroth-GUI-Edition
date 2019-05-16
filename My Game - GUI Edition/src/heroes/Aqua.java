package heroes;
import java.util.Random;

import main.*;

public class Aqua extends Hero{
	
	String attack1 = "Use God Requiem";
	String attack2 = "Perform a healing spell";
	String info1 = "1% chance of success";
	String info2 = "80% chance of success";

	// DVC
	public Aqua()
	{
		this.setHp(75);
		this.setAtckSpd(5);
		this.setHitChnce(1);
		this.setDmgMin(1000);
		this.setDmgMax(2000);
		this.setChance2Block(30);
		this.setPotions(4);
		this.setCharm(1);
		this.setStrPot(0);
		this.setGender("Female");
		this.setName("Aqua");
		this.setHeroType("Goddess");
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		
		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC (Loading from a Save File)
	public Aqua(String name, String gender)
	{
		super(name);
		this.setGender("Female");
		this.setName("Aqua");
		this.setHeroType("Goddess");

		this.setHp(75);
		this.setAtckSpd(5);
		this.setHitChnce(1);
		this.setDmgMin(1000);
		this.setDmgMax(2000);
		this.setChance2Block(30);
		this.setPotions(4);
		this.setCharm(1);
		this.setStrPot(0);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		
		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC for NPC's
	public Aqua(String name)
	{
		super(name);
		this.setGender("Female");
		this.setName("Aqua");
		this.setHeroType("Goddess");
		
		this.setHp(75);
		this.setAtckSpd(5);
		this.setHitChnce(1);
		this.setDmgMin(1000);
		this.setDmgMax(2000);
		this.setChance2Block(30);
		this.setPotions(4);
		this.setCharm(1);
		this.setStrPot(0);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		
		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}

	@Override
	public String superAttack(DungeonCharacter that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll

		this.setDmgMin(90 + dmgIncrease); // Min heals
		this.setDmgMax(200 + dmgIncrease); // Max heals
		this.setHitChnce(80 + hitChnceIncrease); // Chance to heal

		if(diceRoll <= this.hitChnce)
		{
			int hp = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			int heals = this.hp + hp;
			
			if(heals > this.hp) // To ensure that the hp doesn't go over the maximum limit
			{
				this.hp = 75;
				str = "You restored all of your hp!";
			}
			
			else
			{
				this.hp = heals;
				str = "You restored " + hp + " hp!";
			}
		}

		else if(diceRoll > this.hitChnce)
		{
			str = "Your heal spell failed.";
		}
		
		resetStats();
		return str;
	}
	
	public String healAlly(DungeonCharacter that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll

		this.setDmgMin(90 + dmgIncrease); // Min heals
		this.setDmgMax(200 + dmgIncrease); // Max heals
		this.setHitChnce(80 + hitChnceIncrease); // Chance to heal

		if(diceRoll <= this.hitChnce)
		{
			int hp = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			int heals = that.getHp() + hp;
			
			if(heals > that.getTotalHp()) // To ensure that the hp doesn't go over the maximum limit
			{
				that.setHp(that.getTotalHp());
				str = "Aqua restored all of " + that.getName() + "'s hp!";
			}
			
			else
			{
				that.setHp(heals);
				str = "Aqua restored " + hp + " of " + that.getName() + "'s hp!";
			}
		}

		else if(diceRoll > this.hitChnce)
		{
			str = "Your heal spell failed.";
		}

		resetStats();
		return str;
	}
	
	@Override
	public String attack(DungeonCharacter that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		this.setHitChnce(1 + hitChnceIncrease);
		this.setDmgMin(1000 + dmgIncrease);
		this.setDmgMax(2000 + dmgIncrease);
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			that.setHp(that.getHp() - dmg);
			String line = "You actually landed a hit!";
			str = line + " -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = "You missed the monster!";
		}

		resetStats();
		return str;
	}
	
	@Override
	public String storyAttack(DungeonCharacter that)
	{
		String str = null;
		
		this.setHitChnce(1 + hitChnceIncrease);
		this.setDmgMin(1000 + dmgIncrease);
		this.setDmgMax(2000 + dmgIncrease);
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			that.setHp(that.getHp() - dmg);
			String line = "Aqua actually landed her attack!";
			str = line + " -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = "Aqua was completely useless!";
		}
		
		return str;
	}
}
