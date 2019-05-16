package heroes;
import java.util.Random;
import main.*;

public class Darkness extends Hero{
	
	String attack1 = "Use your sword";
	String attack2 = "Exhaust the Enemy";
	String info1 = "0% chance of success";
	String info2 = "90% chance of success";
	
	// DVC
	public Darkness()
	{
		this.setHp(400);
		this.setAtckSpd(1);
		this.setHitChnce(0);
		this.setDmgMin(10);
		this.setDmgMax(40);
		this.setChance2Block(70);
		this.setPotions(0);
		this.setCharm(0);
		this.setStrPot(0);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setName("Darkness");
		this.setHeroType("Crusader");
		this.setGender("Female");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC (Load from a Save File)
	public Darkness(String name, String gender)
	{
		super(name);
		this.setHp(200);
		this.setAtckSpd(1);
		this.setHitChnce(70);
		this.setDmgMin(10);
		this.setDmgMax(40);
		this.setChance2Block(70);
		this.setPotions(0);
		this.setCharm(0);
		this.setStrPot(0);
		this.setGender("Female");
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setName("Darkness");
		this.setHeroType("Crusader");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC for NPC's
	public Darkness(String name)
	{
		super(name);		
		this.setHp(200);
		this.setAtckSpd(1);
		this.setHitChnce(70);
		this.setDmgMin(10);
		this.setDmgMax(40);
		this.setChance2Block(70);
		this.setPotions(0);
		this.setCharm(0);
		this.setStrPot(0);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setName("Darkness");
		this.setHeroType("Crusader");
		this.setGender("Female");

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
		
		this.setHitChnce(90 + hitChnceIncrease);
		this.setDmgMin(10 + dmgIncrease);
		this.setDmgMax(40 + dmgIncrease);
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin; 
			that.setHp(that.getHp() - dmg);
			String line2 = that.getName() + " is getting tired.";
			str = line2 + " -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = that.getName() + " didn't get tired.";
		}
		
		this.setHitChnce(0);
		
		return str;
	}
	
	@Override
	public String attack(DungeonCharacter that)
	{
		// .. why would I program an attack that can never hit.
		return "The monster stood perfectly still, yet you still missed";
	}
	
	@Override
	public String storyAttack(DungeonCharacter that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		this.setHitChnce(90 + hitChnceIncrease);
		this.setDmgMin(10 + dmgIncrease);
		this.setDmgMax(40 + dmgIncrease);
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin; 
			that.setHp(that.getHp() - dmg);
			String line2 = "Darkness' wierdness is tiring out " + that.getName();
			str = line2 + " -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = that.getName() + " didn't get tired.";
		}
		
		this.setHitChnce(0);
		
		return str;
	}
}
