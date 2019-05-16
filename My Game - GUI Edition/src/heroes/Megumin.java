package heroes;
import java.util.Random;
import main.*;

public class Megumin extends Hero{
	
	String attack1 = "EXPLOOOOOOOOSION!";
	String attack2 = "EXPLOOOOOOOOOOOOOOOOSION!!!";
	String info1 = "99% chance of success";
	String info2 = "100% chance of success";

	// DVC
	public Megumin()
	{
		this.setHp(50);
		this.setAtckSpd(2);
		this.setHitChnce(99);
		this.setDmgMin(999);
		this.setDmgMax(1000);
		this.setChance2Block(20);
		this.setPotions(0);
		this.setCharm(0);
		this.setStrPot(0);
		this.setName("Megumin");
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Arch Wizard");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC (Load from a Save File)
	public Megumin(String name, String gender)
	{
		super(name);
		this.setHp(50);
		this.setAtckSpd(2);
		this.setHitChnce(99);
		this.setDmgMin(999);
		this.setDmgMax(1000);
		this.setChance2Block(20);
		this.setPotions(0);
		this.setCharm(0);
		this.setStrPot(0);
		this.setName(name);
		this.setGender(gender);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Arch Wizard");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC for Creation from Battle Mage
	public Megumin(String name)
	{
		super(name);
		this.setHp(50);
		this.setAtckSpd(2);
		this.setHitChnce(99);
		this.setDmgMin(999);
		this.setDmgMax(1000);
		this.setChance2Block(20);
		this.setPotions(0);
		this.setCharm(0);
		this.setStrPot(0);
		this.setGender("Female");
		this.setName("Megumin");
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Arch Wizard");

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
		
		this.setDmgMin(1000 + dmgIncrease);
		this.setDmgMax(1000 + dmgIncrease);
		this.setHitChnce(100 + hitChnceIncrease);
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin; 
			that.setHp(that.getHp() - dmg);
			str = "EXPLOOOOOOOOOOOOOSION!!!!!!" + " -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = "Your attack missed!";
		}
		
		return str;
	}
	
	@Override
	public String attack(DungeonCharacter that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		this.setHitChnce(99 + hitChnceIncrease);
		this.setDmgMin(999 + dmgIncrease);
		this.setDmgMax(1000 + dmgIncrease);
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			that.setHp(that.getHp() - dmg);
			str = "EXPLOOOOOOOOOOOOOOOOOOSION!!!!!!!!" + " -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = "You missed the monster!";
		}
		
		return str;
	}
	
	@Override
	public String storyAttack(DungeonCharacter that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		this.setHitChnce(99 + hitChnceIncrease);
		this.setDmgMin(999 + dmgIncrease);
		this.setDmgMax(1000 + dmgIncrease);
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			that.setHp(that.getHp() - dmg);
			str = "Megumin Screamed \"EXPLOOOOOOOOOOOOOOOOOOSION!!!!!!!!\"" + " -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = "Megumin missed the monster!";
		}
		
		return str;
	}
}
