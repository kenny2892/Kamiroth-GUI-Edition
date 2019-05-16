package monsters;
import java.util.Random;
import heroes.*;

public class LowerBoss extends Monster{

	// DVC
	public LowerBoss()
	{
		this.setName(nameGen());
		this.setHp(500);
		this.setAtckSpd(2);
		this.setHitChnce(80);
		this.setDmgMin(40);
		this.setDmgMax(70);
		this.setChance2Heal(50);
		this.setHealMin(40);
		this.setHealMax(80);
		this.setMstrType("Mini-Boss");
		
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
		that.setChance2Block(that.getChance2Block() - 10); // Make it harder to block
		
		if(diceRoll2 <= 20) // Special Attack
		{
			this.dmgMin = 60;
			this.dmgMax = 74;
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			
			if(r.nextInt(101) > that.getChance2Block()) // If block was unsuccessful
			{
				that.setHp(that.getHp() - dmg);
				str = "\n" + this.getName() + " successfuly landed a special attack!";
				str = str + "\nThe monster landed the attack! -" + dmg + " hp\n";
			}
			
			else // Successful Block
			{
				str = "The attack was successfully blocked!\n";
			}
		}
		
		else if(diceRoll <= this.hitChnce) // Normal Attack
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			
			if(r.nextInt(101) > that.getChance2Block()) // If block was unsuccessful
			{
				that.setHp(that.getHp() - dmg);
				str = "The monster landed the attack! -" + dmg + " hp\n";
			}

			else // Successful Block
			{
				str = "The attack was successfully blocked!\n";
			}
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = "The monster's blow was dodged!\n";
		}
		
		str = str + regenHealth();
		return str;
	}
	
	// Name Generator
	private static String nameGen()
	{
		// Got names from: http://www.fantasynamegenerators.com/gargoyle-names.php
		String[] names = new String[10];
		Random r = new Random();
		int diceRoll = r.nextInt(9);		
		names[0] = "Zonnor";
		names[1] = "Inas";
		names[2] = "Koze";
		names[3] = "Senol";
		names[4] = "Sabenas";
		names[5] = "Kevu";
		names[6] = "Vongel";
		names[7] = "Strovus";
		names[8] = "Najoba";
		names[9] = "Lauden";

		return names[diceRoll];
	}
}
