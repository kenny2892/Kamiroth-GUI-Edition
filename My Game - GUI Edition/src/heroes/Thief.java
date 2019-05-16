package heroes;
import java.util.Random;
import main.*;

public class Thief extends Hero{
	
	String attack1 = "Perform a standard attack";
	String attack2 = "Perform a sneak attack";
	String info1 = "80% chance of success";
	String info2 = "40% chance of success";

	// DVC
	public Thief()
	{
		this.setHp(75);
		this.setAtckSpd(6);
		this.setHitChnce(80);
		this.setDmgMin(20);
		this.setDmgMax(40);
		this.setChance2Block(40);
		this.setPotions(2);
		this.setCharm(3);
		this.setStrPot(0);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Thief");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC (Load from a Save File)
	public Thief(String name, String gender)
	{
		super(name);
		this.setHp(75);
		this.setAtckSpd(6);
		this.setHitChnce(80);
		this.setDmgMin(20);
		this.setDmgMax(40);
		this.setChance2Block(40);
		this.setPotions(2);
		this.setCharm(3);
		this.setStrPot(0);
		this.setName(name);
		this.setGender(gender);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Thief");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC for NPC's
	public Thief(String name)
	{
		super(name);
		Random gen = new Random();
		int gender = gen.nextInt(1);
		
		if(gender == 0)
		{
			this.setGender("Male");
			this.setName("Thief " + nameGenMale());
		}
		
		else
		{
			this.setGender("Female");
			this.setName("Thief " + nameGenFemale());
		}
		
		this.setHp(75);
		this.setAtckSpd(6);
		this.setHitChnce(80);
		this.setDmgMin(20);
		this.setDmgMax(40);
		this.setChance2Block(40);
		this.setPotions(2);
		this.setCharm(3);
		this.setStrPot(0);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Thief");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	@Override
	public String superAttack(DungeonCharacter that)
	{
		String str = null;
		
		this.setHitChnce(40 + hitChnceIncrease);
		this.setDmgMin(30 + dmgIncrease);
		this.setDmgMax(60 + dmgIncrease);
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		if(diceRoll <= 80 && diceRoll > 40) // Surprise Attack
		{
			Random r2 = new Random(); // Random

			int dmg = r2.nextInt(dmgMax - dmgMin + 1) + dmgMin; // Amount of damage the sneak attack will do
			that.setHp(that.getHp() - dmg);
			str = "Sneak Attack Successful!";
			String line2 = lines2Gen();
			str = str + "\n" + line2 + " -" + dmg + " hp\n";		

			// Extra Attack
			this.setHitChnce(80 + hitChnceIncrease);
			this.setDmgMin(20 + dmgIncrease);
			this.setDmgMax(40 + dmgIncrease);
			
			Random r3 = new Random(); // Random
			int diceRoll3 = r3.nextInt(101); // Dice Roll
			
			if(diceRoll3 <= this.hitChnce)
			{
				int dmg2 = r3.nextInt(dmgMax - dmgMin + 1) + dmgMin; 
				that.setHp(that.getHp() - dmg2);
				String line = linesGen();
				str = str + line + " -" + dmg2 + " hp";
			}
			
			else if(diceRoll3 > this.hitChnce)
			{
				str = str + "You missed the monster!";
			}
		}
		
		else if(diceRoll <= 40) // Just normal attack
		{
			str = "You were unable to peform a sneak attack, but may be able to get in a normal attack.\n";
			
			this.setHitChnce(80 + hitChnceIncrease);
			this.setDmgMin(20 + dmgIncrease);
			this.setDmgMax(40 + dmgIncrease);
			
			Random r2 = new Random(); // Random
			int diceRoll2 = r2.nextInt(101); // Dice Roll
			
			if(diceRoll2 <= this.hitChnce)
			{
				int dmg = r2.nextInt(dmgMax - dmgMin + 1) + dmgMin; 
				that.setHp(that.getHp() - dmg);
				String line = linesGen();
				str = str + line + " -" + dmg + " hp\n";
			}
			
			else if(diceRoll2 > this.hitChnce)
			{
				str = str + "You missed the monster!";
			}
		}
		
		else
		{
			str = "You were caught before you could attack.";
		}
		
		return str;
	}
	
	@Override
	public String attack(DungeonCharacter that)
	{
		String str = null;
		
		this.setHitChnce(80 + hitChnceIncrease);
		this.setDmgMin(20 + dmgIncrease);
		this.setDmgMax(40 + dmgIncrease);
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
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
		
		this.setHitChnce(80 + hitChnceIncrease);
		this.setDmgMin(20 + dmgIncrease);
		this.setDmgMax(40 + dmgIncrease);
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin; 
			that.setHp(that.getHp() - dmg);
			String line = this.getName() + " sliced at the monster!";
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
		int diceRoll = r.nextInt(10); // Dice Roll
		
		attackLines[0] = "You jabbed at the monster!";
		attackLines[1] = "You lunged towards the monster!";
		attackLines[2] = "You fought the monster!";
		attackLines[3] = "You jabbed at the monster!";
		attackLines[4] = "You sliced at the monster!";
		attackLines[5] = "You waited for your moment to strike, and then attacked the monster!";
		attackLines[6] = "You dashed towards the beast, pushed through their defences and landed a slash with your sword!";
		attackLines[7] = "You saw an oppening in the beast's defences and struck!";
		attackLines[8] = "The monster got distracted by a sound out in the distance. You took this moment of confusion to deal a painful blow!";
		attackLines[9] = "You closed the distance between you and the monster and took a swing at its head!";
		
		return attackLines[diceRoll];
	}
	
	private static String lines2Gen()
	{
		String[] attack2Lines = new String[5];
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(5); // Dice Roll
		
		attack2Lines[0] = "You snuck up on the monster and went for the neck!";
		attack2Lines[1] = "You crawled behind the beast and cut its ankles!";
		attack2Lines[2] = "You crept in the shadow of the monster and stabbed it in the back!";
		attack2Lines[3] = "You evaded the beast's line of sight and got a sneak attack in!";
		attack2Lines[4] = "You hid in a nearby bush and ambushed the beast when it passed by!";
		
		return attack2Lines[diceRoll];
	}
	
	// Name Generator - Male
	private static String nameGenMale()
	{
		String[] names = new String[10];
		Random r = new Random();
		int diceRoll = r.nextInt(9);		
		names[0] = "Craig";
		names[1] = "Evan";
		names[2] = "Brian";
		names[3] = "Marcel";
		names[4] = "Brock";
		names[5] = "Scotty";
		names[6] = "Jordan";
		names[7] = "Arin";
		names[8] = "Dan";
		names[9] = "Jacob";

		return names[diceRoll];
	}
	
	// Name Generator - Female
	private static String nameGenFemale()
	{
		String[] names = new String[10];
		Random r = new Random();
		int diceRoll = r.nextInt(9);		
		names[0] = "Lola";
		names[1] = "Lena";
		names[2] = "Angela";
		names[3] = "Ana";
		names[4] = "Sarah";
		names[5] = "Ellie";
		names[6] = "Abby";
		names[7] = "Rebecca";
		names[8] = "Hannah";
		names[9] = "Selena";

		return names[diceRoll];
	}
}
