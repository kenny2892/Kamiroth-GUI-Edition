package monsters;
import java.util.Random;
import heroes.Hero;

public class Ogre extends Monster{

	// DVC
	public Ogre()
	{
		this.setName(nameGen());
		this.setHp(200);
		this.setAtckSpd(2);
		this.setHitChnce(60);
		this.setDmgMin(30);
		this.setDmgMax(60);
		this.setChance2Heal(10);
		this.setHealMin(30);
		this.setHealMax(60);
		this.setMstrType("Ogre");
		
		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	@Override
	public String regenHealth()
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll

		if(diceRoll <= this.chance2Heal)
		{
			int heal = r.nextInt(healMax - healMin + 1) + healMin;
			int newHp = this.hp + heal;

			if(newHp > totalHp)
			{
				this.hp = totalHp;
				str = "The monster regained all of its hp back after the fight!\n";
			}
			
			else
			{
				this.hp = newHp;
				str = "The monster regained " + heal + " hp back after the fight!\n";
			}			
		}
		
		else if(diceRoll > this.chance2Heal)
		{
			str = "The monster didn't gain any health back.\n";
		}
		
		return str;
	}
	
	@Override
	public String attack(Hero that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		int diceRoll2 = r.nextInt();
		
		if(diceRoll2 <= 30) // Special Attack
		{
			this.dmgMin = 50;
			this.dmgMax = 70;
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			
			if(r.nextInt(101) > that.getChance2Block()) // If block was unsuccessful
			{
				that.setHp(that.getHp() - dmg);
				str = this.getName() + " successfuly landed a special attack!";
				str = str + "\nThe ogre slammed a club into you! -" + dmg + " hp\n";
			}
			
			else // Successful Block
			{
				str = "\nYou successfully blocked the monster's attack!";
			}
		}
		
		else if(diceRoll <= this.hitChnce) // Normal Attack
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			
			if(r.nextInt(101) > that.getChance2Block()) // If block was unsuccessful
			{
				that.setHp(that.getHp() - dmg);
				str = "The ogre swung a punch at you! -" + dmg + " hp\n";
			}

			else // Successful Block
			{
				str = "\nYou successfully blocked the monster's attack!";
			}
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = "\nYou dodged the monster's blow!\n";
		}
		
		str = str + regenHealth();
		return str;
	}
	
	// Name Generator
	private static String nameGen()
	{
		// Got names from: https://www.fantasynamegenerators.com/ogre-names.php
		String[] names = new String[10];
		Random r = new Random();
		int diceRoll = r.nextInt(9);		
		names[0] = "Shrek";
		names[1] = "Azar";
		names[2] = "Tukag";
		names[3] = "Breakurk";
		names[4] = "Ezog";
		names[5] = "Tagark";
		names[6] = "Kregrok";
		names[7] = "Gerog";
		names[8] = "Yirog";
		names[9] = "Ugrok";
				
		return names[diceRoll];
	}
}
