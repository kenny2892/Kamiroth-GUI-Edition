package heroes;
import java.util.Random;
import main.*;

public class GameMaster extends Hero{
	
	String attack1 = "Perform a stupidly powerful attack";
	String attack2 = "Perform an overpowered attacked";
	String info1 = "99% chance of success";
	String info2 = "100% chance of success";
	
	// DVC
	public GameMaster()
	{
		this.setHp(1000);
		this.setAtckSpd(6);
		this.setHitChnce(99);
		this.setDmgMin(100);
		this.setDmgMax(200);
		this.setChance2Block(70);
		this.setPotions(7);
		this.setCharm(7);
		this.setStrPot(7);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Game Master");
		
		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC (Load from a Save File)
	public GameMaster(String name, String gender)
	{
		super(name);
		this.setHp(1000);
		this.setAtckSpd(6);
		this.setHitChnce(99);
		this.setDmgMin(100);
		this.setDmgMax(200);
		this.setChance2Block(70);
		this.setPotions(7);
		this.setCharm(7);
		this.setStrPot(7);
		this.setName(name);
		this.setGender(gender);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Game Master");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC for NPC's
	public GameMaster(String name)
	{
		super(name);
		Random gen = new Random();
		int gender = gen.nextInt(1);
		
		if(gender == 0)
		{
			this.setGender("Male");
			this.setName("Game Master " + nameGenMale());
		}
		
		else
		{
			this.setGender("Female");
			this.setName("Game Master " + nameGenFemale());
		}
		
		this.setHp(1000);
		this.setAtckSpd(6);
		this.setHitChnce(99);
		this.setDmgMin(100);
		this.setDmgMax(200);
		this.setChance2Block(70);
		this.setPotions(7);
		this.setCharm(7);
		this.setStrPot(7);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Game Master");

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
			String line2 = lines2Gen();
			str = line2 + " -" + dmg + " hp";
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
		this.setDmgMin(100 + dmgIncrease);
		this.setDmgMax(200 + dmgIncrease);
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			that.setHp(that.getHp() - dmg);
			String line = linesGen();
			str = line + " -" + dmg + " hp";
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
		this.setDmgMin(100 + dmgIncrease);
		this.setDmgMax(200 + dmgIncrease);
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			that.setHp(that.getHp() - dmg);
			String line = this.getName() + " snapped at the beast!";
			str = line + " -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = this.getName() + " missed the monster!";
		}
		
		return str;
	}
	
	private static String linesGen()
	{
		String[] attackLines = new String[10];
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(5); // Dice Roll
		
		attackLines[0] = "You snapped your fingers and lightning struck the beast!";
		attackLines[1] = "You shot lasers out of your eyes towards the beast!";
		attackLines[2] = "You glanced at the beast, only for an anvil to fall from the sky and land on the monster!";
		attackLines[3] = "You summoned an army of kittens to fight the beast for you!";
		attackLines[4] = "You sneezed and summoned a tornado!";
		
		return attackLines[diceRoll];
	}
	
	private static String lines2Gen()
	{
		String[] attack2Lines = new String[5];
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(3); // Dice Roll
		
		attack2Lines[0] = "You got tired of fighting and ended the fight!";
		attack2Lines[1] = "You rolled your eyes and the monster exploded!";
		attack2Lines[2] = "You sped up time until the monster had died of old age!";
		
		return attack2Lines[diceRoll];
	}
	
	// Name Generator - Male
	private static String nameGenMale()
	{
		String[] names = new String[10];
		Random r = new Random();
		int diceRoll = r.nextInt(9);		
		names[0] = "Andrew";
		names[1] = "Gabe";
		names[2] = "Josh";
		names[3] = "Henry";
		names[4] = "Nick";
		names[5] = "Peter";
		names[6] = "Stan";
		names[7] = "Kyle";
		names[8] = "Kenny";
		names[9] = "Eric";

		return names[diceRoll];
	}

	// Name Generator - Female
	private static String nameGenFemale()
	{
		String[] names = new String[10];
		Random r = new Random();
		int diceRoll = r.nextInt(9);		
		names[0] = "Katie";
		names[1] = "Suzy";
		names[2] = "Wendy";
		names[3] = "Lucy";
		names[4] = "Rose";
		names[5] = "Daisy";
		names[6] = "Alexis";
		names[7] = "Sabrina";
		names[8] = "Penny";
		names[9] = "Leah";

		return names[diceRoll];
	}
}
