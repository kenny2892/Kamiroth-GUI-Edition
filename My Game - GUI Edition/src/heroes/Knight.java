package heroes;
import java.util.Random;
import main.*;

public class Knight extends Hero{
	
	String attack1 = "Perform a standard attack";
	String attack2 = "Perform a shield bash";
	String info1 = "70% chance of success";
	String info2 = "50% chance of success";

	// DVC
	public Knight()
	{
		this.setHp(200);
		this.setAtckSpd(1);
		this.setHitChnce(70);
		this.setDmgMin(20);
		this.setDmgMax(50);
		this.setChance2Block(70);
		this.setPotions(1);
		this.setCharm(1);
		this.setStrPot(3);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Knight");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC (Load from a Save File)
	public Knight(String name, String gender)
	{
		super(name);
		this.setHp(200);
		this.setAtckSpd(1);
		this.setHitChnce(70);
		this.setDmgMin(20);
		this.setDmgMax(50);
		this.setChance2Block(70);
		this.setPotions(1);
		this.setCharm(1);
		this.setStrPot(3);
		this.setName(name);
		this.setGender(gender);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Knight");

		this.setTotalHp(hp);
		this.setHitChnceOG(hitChnce);
		this.setDmgMinOG(dmgMin);
		this.setDmgMaxOG(dmgMax);
	}
	
	// EVC for NPC's
	public Knight(String name)
	{
		super(name);
		Random gen = new Random();
		int gender = gen.nextInt(1);
		
		if(gender == 0)
		{
			this.setGender("Male");
			this.setName("Knight " + nameGenMale());
		}
		
		else
		{
			this.setGender("Female");
			this.setName("Knight " + nameGenFemale());
		}
		
		this.setHp(200);
		this.setAtckSpd(1);
		this.setHitChnce(70);
		this.setDmgMin(20);
		this.setDmgMax(50);
		this.setChance2Block(70);
		this.setPotions(1);
		this.setCharm(1);
		this.setStrPot(3);
		this.setMenu(attack1, 1);
		this.setMenu(attack2, 2);
		this.setMenuInfo(info1, 1);
		this.setMenuInfo(info2, 2);
		this.setHeroType("Knight");

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
		
		this.setDmgMin(40 + dmgIncrease);
		this.setDmgMax(75 + dmgIncrease);
		this.setHitChnce(50 + hitChnceIncrease);
		
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
		
		this.setHitChnce(70 + hitChnceIncrease);
		this.setDmgMin(20 + dmgIncrease);
		this.setDmgMax(50 + dmgIncrease);
		
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
		
		this.setHitChnce(70 + hitChnceIncrease);
		this.setDmgMin(20 + dmgIncrease);
		this.setDmgMax(50 + dmgIncrease);
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			that.setHp(that.getHp() - dmg);
			String line = this.getName() + " lunged at the beast!";
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
		attackLines[3] = "You stabbed at the monster!";
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
		
		attack2Lines[0] = "You delivered a crushing bash to the enemy's head!";
		attack2Lines[1] = "You lunged at the beast and smashed your shield into their face!";
		attack2Lines[2] = "You charged at the monster shield first, knocking it over and allowing you to deal a devastating blow!";
		attack2Lines[3] = "You kicked up some dirt to blind the beast, and then swung your shield into its chest!";
		attack2Lines[4] = "You ran forward, smack the beasts arms away, and swung at their face!";
		
		return attack2Lines[diceRoll];
	}
	
	// Name Generator - Male
	private static String nameGenMale()
	{
		String[] names = new String[10];
		Random r = new Random();
		int diceRoll = r.nextInt(9);		
		names[0] = "Anthony";
		names[1] = "Ian";
		names[2] = "Ray";
		names[3] = "Fred";
		names[4] = "Gary";
		names[5] = "Cade";
		names[6] = "Dillion";
		names[7] = "Shaun";
		names[8] = "Phil";
		names[9] = "Tony";

		return names[diceRoll];
	}
	
	// Name Generator - Female
	private static String nameGenFemale()
	{
		String[] names = new String[10];
		Random r = new Random();
		int diceRoll = r.nextInt(9);		
		names[0] = "Tamara";
		names[1] = "Jeanie";
		names[2] = "Sonja";
		names[3] = "Ruby";
		names[4] = "Zoe";
		names[5] = "Natasha";
		names[6] = "Daniela";
		names[7] = "Paige";
		names[8] = "Alice";
		names[9] = "Rachel";

		return names[diceRoll];
	}
}
