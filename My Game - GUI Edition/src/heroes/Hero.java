package heroes;
import java.util.*;
import main.*;

public abstract class Hero extends DungeonCharacter{

	double chance2Block = 1.0;
	int roundTurns = 1;
	int potions = 0; // Health Potion: Boost Health, + 25 hp
	int charm = 0; // Good Luck Charm: Boost Chance to Hit, + 15%
	int strPot = 0; // Strength Potion: Boost Max & Min Damage, + 25 dmg
	String attack1, attack2, attackInfo1, attackInfo2 = "Default Text";
	String heroType = "Default Hero";
	
	// Just for Megumin
	protected static int attackCounter = 5;
	protected static boolean canAttack = true;
	
	// DVC
	public Hero()
	{
		this.chance2Block = 10.0;
		this.roundTurns = 1;
		inputValues();
	}
	
	// EVC (For NPC's & Save Loading)
	public Hero(String name)
	{
		this.name = name;
		this.gender = "Male";
	}
	
	public double getChance2Block() 
	{
		return chance2Block;
	}

	public void setChance2Block(double chance2Block) 
	{
		this.chance2Block = chance2Block;
	}

	public int getRoundTurns() 
	{
		return roundTurns;
	}

	public void setRoundTurns(int roundTurns) 
	{
		this.roundTurns = roundTurns;
	}

	public int getPotions() 
	{
		return potions;
	}

	public void setPotions(int num)
	{
		this.potions = num;
	}

	public int getCharm()
	{
		return charm;
	}

	public void setCharm(int charm) 
	{
		this.charm = charm;
	}

	public int getStrPot()
	{
		return strPot;
	}

	public void setStrPot(int strPot) 
	{
		this.strPot = strPot;
	}
	
	public String getMenu(int num)
	{
		if(num == 1)
			return attack1;
		
		else
			return attack2;
	}

	public void setMenu(String menu, int num) 
	{
		if(num == 1)
			this.attack1 = menu;
		
		else
			this.attack2 = menu;
	}
	
	public String getMenuInfo(int num)
	{
		if(num == 1)
			return attackInfo1;
		
		else
			return attackInfo2;
	}

	public void setMenuInfo(String info, int num) 
	{
		if(num == 1)
			this.attackInfo1 = info;
		
		else
			this.attackInfo2 = info;
	}
	
	public String getHeroType()
	{
		return heroType;
	}

	public void setHeroType(String heroType) 
	{
		this.heroType = heroType;
	}
	
	// For Megumin
	public int getAttackCounter() 
	{
		return attackCounter;
	}

	public void setAttackCounter(int attackCounter) 
	{
		Hero.attackCounter = attackCounter;
	}

	public boolean getCanAttack() 
	{
		return canAttack;
	}

	public void setCanAttack(boolean canAttack) 
	{
		Hero.canAttack = canAttack;
	}

	public void inputValues()
	{
		Scanner kb = new Scanner(System.in);
		System.out.print("What is your name: ");
		name = kb.nextLine();
		name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();		
		this.setName(name);
		
		while(gender.equals(""))
		{
			System.out.print("What is your gender (M, F, or Other): ");
			gender = kb.nextLine();
			
			if(gender.toUpperCase().equals("M") == false && gender.toUpperCase().equals("MALE") == false && gender.toUpperCase().equals("F") == false && gender.toUpperCase().equals("FEMALE") == false && gender.toUpperCase().equals("OTHER") == false && gender.toUpperCase().equals("O") == false)
			{
				System.out.println("Please select type in Male, Female, or Other.");
				gender = "";
			}
			
			else if(gender.toUpperCase().equals("M"))
			{
				gender = "Male";
			}
			
			else if(gender.toUpperCase().equals("F"))
			{
				gender = "Female";
			}
			
			else if(gender.toUpperCase().equals("O"))
			{
				gender = "Other";
			}
			
			else
			{
				gender = gender.substring(0,1).toUpperCase() + gender.substring(1).toLowerCase();
			}
		}
		this.setGender(gender);
	}
	
	public int calcTurns(DungeonCharacter that) // Do at the beginning of a game
	{
		int speed = this.atckSpd / that.getAtckSpd();
		if(speed <= 0)
		{
			speed = 1;
		}
		
		return speed;
	}
	
	@Override
	public String attack(DungeonCharacter that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			that.setHp(that.getHp() - dmg);
			str = "You have attacked the monster! You did: " + dmg + " damage";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = "You missed the monster!";
		}
		
		return str;
	}
	
	@Override
	public String superAttack(DungeonCharacter that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin; 
			that.setHp(that.getHp() - dmg);
			String line2 = "You did";
			str = line2 + " -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = "Your attack missed!";
		}
		
		return str;
	}
	
	public String storyAttack(DungeonCharacter that)
	{
		String str = null;
		
		Random r = new Random(); // Random
		int diceRoll = r.nextInt(101); // Dice Roll
		
		if(diceRoll <= this.hitChnce)
		{
			int dmg = r.nextInt(dmgMax - dmgMin + 1) + dmgMin;
			that.setHp(that.getHp() - dmg);
			str = this.name + " hit the beast! -" + dmg + " hp";
		}
		
		else if(diceRoll > this.hitChnce)
		{
			str = this.name + " missed the monster!";
		}
		
		return str;
	}
	
	@Override
	public void resetStats()
	{
		this.setHp(totalHp);
		this.setHitChnce(hitChnceOG);
		this.setDmgMin(dmgMinOG);
		this.setDmgMax(dmgMaxOG);
	}
}
