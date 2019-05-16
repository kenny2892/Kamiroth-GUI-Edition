// Jesse Ross
// December 23, 2018
// GUI Edition of My Game

package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import heroes.*;
import monsters.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import javax.swing.ImageIcon;
public class Game 
{
	private static File saveGame = new File("Save.txt");
	private static int jokes = 1;
	private static int hardcore = 0;
	private static Hero player = null;
	private static Monster monster = null;
	private static int playerTurns = 1;
	private static int turns = playerTurns;
//	public MP3Player music = null;
	
	static UI ui = new UI();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	private static VisibilityManager vm = new VisibilityManager(ui);
	
	public static void main(String args[])
	{
		new Game();
	}
	
	public Game()
	{	
		ui.createUI(choiceHandler);
		vm.showTitleScreen();
	}
	
	// Choice Handler
	public class ChoiceHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String playerChoice = event.getActionCommand();
			
			switch(playerChoice)
			{
		// Start Button
			case "start":
				vm.newOrOldScreen();
				break;
				
		// New or Load Save
			case "nL2": // Load
				try
				{
					saveGame = new File("Save.txt");
					player = loadSave(saveGame);
					
					if(player == null)
						throw new Exception("");
					
					changePicHero(player);
					
					vm.showMainMenu();
				}

				catch(Exception e)
				{
					vm.loadError(jokes);
				}
				break;
				
			case "nL1": // New
				vm.heroSelect(jokes);
				break;
			
			case "removeError":
				vm.removeError(jokes);
				break;
				
		// Hero Select
			case "h1": // Warrior
				ui.chooseHero(playerChoice);
				ui.lblClassSelected.setText("Class Selected: Warrior");
				vm.heroSelect(jokes);
				break;
				
			case "h2": // Sorceress
				ui.chooseHero(playerChoice);
				ui.lblClassSelected.setText("Class Selected: Sorcerer");
				vm.heroSelect(jokes);
				break;
				
			case "h3": // Thief
				ui.chooseHero(playerChoice);
				ui.lblClassSelected.setText("Class Selected: Thief");
				vm.heroSelect(jokes);
				break;
				
			case "h4": // Knight
				ui.chooseHero(playerChoice);
				ui.lblClassSelected.setText("Class Selected: Knight");
				vm.heroSelect(jokes);
				break;
				
			case "h5": // Battle Mage
				ui.chooseHero(playerChoice);
				ui.lblClassSelected.setText("Class Selected: Battle Mage");
				vm.heroSelect(jokes);
				break;
				
			case "h6": // GM
				ui.chooseHero(playerChoice);
				ui.lblClassSelected.setText("Class Selected: Game Master");
				vm.heroSelect(jokes);
				break;	
				
			case "defPic":
				ui.rdbtnAttack.setSelected(false);
				ui.rdbtnInjured.setSelected(false);
				
				ui.heroPic.setIcon(new ImageIcon(ui.heroImg));
				break;
			
			case "atkPic":
				ui.rdbtnDefault.setSelected(false);
				ui.rdbtnInjured.setSelected(false);
				
				ui.heroPic.setIcon(new ImageIcon(ui.heroAtkImg));
				break;
				
			case "hurtPic":
				ui.rdbtnDefault.setSelected(false);
				ui.rdbtnAttack.setSelected(false);
				
				ui.heroPic.setIcon(new ImageIcon(ui.heroHurtImg));
				break;
				
		// Hero Input
			case "heroConfirm":
				if(ui.chckbxFemale.isSelected() || ui.chckbxMale.isSelected())
				{
					player = ui.makeHero(jokes);
					vm.showMainMenu();
					changePicHero(player);
				}
				break;
			
			case "male":
				ui.chckbxFemale.setSelected(false);
				ui.heroGender = "Male";
				ui.picUpdate(ui.num);
				vm.heroSelect(jokes);
				break;
			
			case "female":
				ui.chckbxMale.setSelected(false);
				ui.heroGender = "Female";
				ui.picUpdate(ui.num);
				vm.heroSelect(jokes);
				break;
				
		// Hero Info
			case "info":
				vm.heroSelect(jokes);
				break;
				
			case "info1": // Warrior
				ui.txtrInfo.setText("Warrior Stats:"
								  + "\n     Hp: 125"
						   		  + "\n     Attack Speed: 4"
						   		  + "\n     Standard Damage Min: 35"
						   		  + "\n     Standard Damage Max: 60"
						   		  + "\n     Chance to Block: 20%"
						   		  + "\nWarrior's Attacks: "
						   		  + "\n     A standard attack: 80% chance of hitting."
						   		  + "\n     A special attack: 40% chance of hitting."
						   		  + "\nWarrior's Default Inventory:"
						   		  + "\n     2 Potions & 3 Strength Potions");
				break;
				
			case "info2": // Sorceress
				ui.txtrInfo.setText("Socer(ess/er) Stats:"
								  + "\n     Hp: 75"
								  + "\n     Attack Speed: 5"
								  + "\n     Standard Damage Min: 25"
								  + "\n     Standard Damage Max: 45"
								  + "\n     Chance to Block: 70%"
								  + "\nSocer(ess/er)'s Attacks: "
								  + "\n     A standard attack: 70% chance of hitting."
								  + "\n     A healing spell: 80% chance of working."
								  + "\nSocer(ess/er)'s Default Inventory:"
								  + "\n     4 Potions & 1 Good Luck Charm");
				break;
				
			case "info3": // Thief
				ui.txtrInfo.setText("Thief Stats:"
								  + "\n     Hp: 75"
								  + "\n     Attack Speed: 6"
								  + "\n     Standard Damage Min: 20"
								  + "\n     Standard Damage Max: 40"
								  + "\n     Chance to Block: 80%"
								  + "\nThief's Attacks: "
								  + "\n     A standard attack: 80% chance of hitting."
								  + "\n     A sneak attack: 40% chance of hitting."
								  + "\n       (Followed up by a standard attack) "
								  + "\nThief's Default Inventory:"
								  + "\n     2 Potions & 3 Good Luck Charms");
				break;
				
			case "info4": // Knight
				ui.txtrInfo.setText("Knight Stats:"
							      + "\n     Hp: 200"
							      + "\n     Attack Speed: 1"
							      + "\n     Standard Damage Min: 20"
							      + "\n     Standard Damage Max: 50"
							      + "\n     Chance to Block: 70%"
							      + "\nKnight's Attacks: "
							      + "\n     A standard attack: 70% chance of hitting."
							      + "\n     A shield bash: 50% chance of hitting."
							      + "\nKnight's Default Inventory:"
							      + "\n     1 Potions, 1 Good Luck Charm, \n     & 2 Strength Potions");
				break;
				
			case "info5": // Battle Mage
				ui.txtrInfo.setText("Battle Mage Stats:"
								  + "\n     Hp: 95"
								  + "\n     Attack Speed: 3"
								  + "\n     Standard Damage Min: 50"
								  + "\n     Standard Damage Max: 70"
								  + "\n     Chance to Block: 20%"
								  + "\nBattle Mage's Attacks: "
								  + "\n     A standard spell: 70% chance of hitting."
								  + "\n     An advanced spell: 50% chance of hitting."
								  + "\nBattle Mage's Default Inventory:"
								  + "\n     2 Potions, 1 Good Luck Charm, \n     & 2 Strength Potions");
				break;
				
			case "info6": // GM
				ui.txtrInfo.setText("Game Master Stats:"
								  + "\n     Hp: 1000"
								  + "\n     Attack Speed: 6"
								  + "\n     Standard Damage Min: 100"
								  + "\n     Standard Damage Max: 200"
								  + "\n     Chance to Block: 70%"
								  + "\nGame Master's Attacks: "
								  + "\n     A powerful attack: 99% chance of hitting."
								  + "\n     An extremely, stupidly, insanely,\n        powerful attack: 100% chance of hitting."
								  + "\nGame Master's Default Inventory:"
								  + "\n     7 Potions, 7 Good Luck Charm, \n     & 7 Strength Potions");
				break;
			
		// Main Menu
			case "single":
				singleBattle();
				changePicMstr(monster);
				playerTurns = player.calcTurns(monster);
				turns = playerTurns;
				
				vm.showBattleScreen(player, monster, turns, playerTurns);
				break;
				
			case "story":
				
				break;
				
			case "newHero":
				ui.rdbtnDefault.setSelected(true);
				ui.heroType = "h1"; // Warrior by Default
				ui.lblClassSelected.setText("Class Selected: Warrior");
				ui.chooseHero(ui.heroType);
				
				ui.chckbxMale.setSelected(true); // Male by Default
				ui.chckbxFemale.setSelected(false);
				ui.txtrTypeHere.setText("Type Here!!");
				vm.newHero(jokes);
				break;
				
			case "save":
				saveGame();
				break;
				
			case "settings":
				vm.showSettings(jokes, hardcore);
				break;
				
		// Settings
			case "hard":
				if(hardcore == 0)
					hardcore = 1;
				
				else
					hardcore = 0;
				break;
				
			case "joke":
				if(jokes == 0)
					jokes = 1;
				
				else
					jokes = 0;
				break;
				
			case "back":
				vm.showMainMenu();
				
				if(player != null)
					player.resetStats();
				
				if(monster != null)
					monster.resetStats();
				break;
			
		// Save Files
			case "override":
				saveOverride();
				break;
			
		// Single Battle
			case "movesMenu":
				vm.showMoves(player, monster);
				break;
				
			case "m1": // Attack
				String temp = player.attack(monster);
				turns = vm.showAtkMsg(player, monster, turns, playerTurns, temp);
				break;
				
			case "m2": // Super Attack
				String temp2 = player.superAttack(monster);
				turns = vm.showAtkMsg(player, monster, turns, playerTurns, temp2);				
				break;
				
			case "m3":
				
				break;
				
			case "m4":
				vm.showBattleScreen(player, monster, turns, playerTurns);
				break;
				
			case "stats": // Info
				vm.showInfo(player, monster, turns, playerTurns);
				break;
				
			case "items": // Item
				vm.showItem(player, monster, turns, playerTurns);
				break;
			
			case "itemBack":
				vm.showBattleScreen(player, monster, turns, playerTurns);
				break;
				
			case "atkMsg":
				
				if(player.getHp() <= 0)
				{
					vm.showResults(0);
				}
				
				else if(monster.getHp() <= 0)
				{
					vm.showResults(1);
				}
				
				else if(turns <= 0) // Check if its the monster's turn
				{
					turns = vm.showAtkMsg(player, monster, turns, playerTurns, "");
				}
				
				else
					vm.showBattleScreen(player, monster, turns, playerTurns);
				
				break;
				
			case "admitDefeat":
				vm.showResults(0);
				player.resetStats();
				monster.resetStats();
				break;
				
			case "infoDone":
				vm.showBattleScreen(player, monster, turns, playerTurns);
				break;
				
			case "potion":
				if(player.getPotions() <= 0)
				{
					ui.lblYouHaveNone.setVisible(true);
				}
				
				else
				{
					int heals = player.getHp() + 25;

					if(heals > player.getTotalHp()) // To ensure that the hp doesn't go over the maximum limit
					{
						player.setHp(player.getTotalHp());
					}

					else
					{
						player.setHp(heals);
					}

					player.setPotions(player.getPotions() - 1);
					String itemStr = "Potion +25 Hp";
					
					turns = vm.showAtkMsg(player, monster, turns, playerTurns, itemStr);
				}
				break;
			
			case "charm":
				if(player.getCharm() <= 0)
				{
					ui.lblYouHaveNone.setVisible(true);
				}
				
				else
				{
					player.setHitChnce(player.getHitChnce() + 15);
					player.setCharm(player.getCharm() - 1);
					
					String itemStr = "Good Luck Charm +25 Accuracy";
					turns = vm.showAtkMsg(player, monster, turns, playerTurns, itemStr);
				}
				break;
				
			case "strength":
				if(player.getStrPot() <= 0)
				{
					ui.lblYouHaveNone.setVisible(true);
				}
				
				else
				{
					player.setDmgMin(player.getDmgMin() + 25);
					player.setDmgMax(player.getDmgMax() + 25);

					player.setStrPot(player.getStrPot() - 1);
					
					String itemStr = "Strength Potion +25 Damage";
					turns = vm.showAtkMsg(player, monster, turns, playerTurns, itemStr);
				}
				break;
				
		// Quit
			case "quit":
				ui.quit();
				break;
			}
		}
	}
	
	// Load Save
	public static Hero loadSave(File saveGame)
	{
		Hero playerNew = null;
		
		try
		{
			Scanner readFile = new Scanner(saveGame);
			String name = readFile.nextLine();
			String gender = readFile.nextLine();
			String type = readFile.nextLine();
			
			// Discovering the class of Hero
			if(type.equalsIgnoreCase("Warrior")) // Warrior
			{
				playerNew = new Warrior(name, gender);
			}
			
			else if(type.equalsIgnoreCase("Sorceress") || type.equalsIgnoreCase("Sorcerer")) // Sorceress
			{
				playerNew = new Sorceress(name, gender);
			}
			
			else if(type.equalsIgnoreCase("Thief")) // Thief
			{
				playerNew = new Thief(name, gender);
			}
			
			else if(type.equalsIgnoreCase("Knight")) // Knight
			{
				playerNew = new Knight(name, gender);
			}
			
			else if(type.equalsIgnoreCase("Battle Mage")) // Battle Mage
			{
				playerNew = new BattleMage(name, gender);
			}
			
			else if(type.equalsIgnoreCase("Game Master")) // Game Master
			{
				playerNew = new GameMaster(name, gender);
			}
			
			else if(type.equalsIgnoreCase("Arch Wizard")) // Megumin
			{
				playerNew = new Megumin(name);
			}
			
			readFile.close();
			
		} 
		catch (Exception e) 
		{
			vm.loadError(jokes);
		}
		
		return playerNew;
	}
	
	// Save Game
	private static void saveGame()
	{
		// Found Here: https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
		if(saveGame.exists()) // Overwriting the old save
		{
			vm.showSaveMenu(1, saveGame);
		}

		else // Create Save File
		{
			try
			{
				PrintWriter newFile = new PrintWriter("Save.txt", "UTF-8");
				newFile.println(player.getName());
				newFile.println(player.getGender());
				newFile.println(player.getHeroType());
				newFile.close();
				
				vm.showMainMenu();
				vm.saveComplete();
			}

			catch(Exception e)
			{
				vm.showMainMenu();
				vm.saveError();
			}
		}
	}
	
	// Save Override
	private static void saveOverride()
	{
		File backup = new File("SaveBackup.txt");
		// Backing up a file: https://stackoverflow.com/questions/22135156/how-to-backup-file-in-java
		// Getting the current directory: https://stackoverflow.com/questions/4871051/getting-the-current-working-directory-in-java
		Path dir = Paths.get("");
		Path source = Paths.get(dir.toAbsolutePath().toString() + "\\Save.txt");
		Path target = Paths.get(dir.toAbsolutePath().toString() + "\\SaveBackup.txt");
		try 
		{
			if(backup.exists())
			{
				backup.delete(); // Delete Old Backup
			}
			Files.copy(source, target);
			
		} 

		catch (Exception e) 
		{
			vm.showMainMenu();
			vm.saveError();
		}

		// Writing the new save file
		try
		{
			PrintWriter printFile = new PrintWriter(saveGame);

			printFile.println(player.getName());
			printFile.println(player.getGender());
			printFile.println(player.getHeroType());
			printFile.close();

			vm.showMainMenu();
			vm.saveComplete();
		}

		catch(Exception e)
		{
			vm.showMainMenu();
			vm.saveError();
		}
	}
	
	// Single Battle
	private static void singleBattle()
	{
		// Create Monster
		monster = null;
		Random monsterGen = new Random();
		int monInt = monsterGen.nextInt(3);

		switch(monInt)
		{
		case 0: // Ogre
			monster = new Ogre();
			break;
		case 1: // Gremlin
			monster = new Gremlin();
			break;
		case 2: // Skeleton
			monster = new Skeleton();
			break;
		}
	}
	
	// Hero Picture Selection
	public void changePicHero(Hero character)
	{
		String type = character.getHeroType();
		
		switch(type)
		{
		case "Warrior":
			if(character.gender.compareTo("Female") == 0)
				ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F2.png")).getImage();
			
			else
				ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/M2.png")).getImage();
			break;
			
		case "Sorceress":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/F1.png")).getImage();
			break;
			
		case "Sorcerer":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/M1.png")).getImage();
			break;
			
		case "Thief":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Thief/F1.png")).getImage();
			break;
			
		case "Battle Mage":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/F1.png")).getImage();
			break;
			
		case "Knight":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Knight/F1.png")).getImage();
			break;
			
		case "Game Master":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/GM/Hands.png")).getImage();
			break;
			
		case "Goddess":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/Aqua.png")).getImage();
			break;
			
		case "Crusader":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Knight/Darkness.png")).getImage();
			break;
			
		case "Arch Wizard":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/Megumin.png")).getImage();
			break;
			
		case "Adventurer":
			ui.playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Thief/Kazuma.png")).getImage();
			break;
		}
	}
	
	// Monster Picture Selection
	public void changePicMstr(Monster character)
	{
		String type = character.getMstrType();

		switch(type)
		{
		case "Dragon":
			ui.enemyImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/monsters/Final Bosses/Veldora.png")).getImage();
			break;

		case "Demon Lord":
			ui.enemyImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/monsters/Final Bosses/Demon King.png")).getImage();
			break;

		case "Koopa Queen":
			ui.enemyImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/monsters/Final Bosses/Bowsette.png")).getImage();
			break;

		case "Former Gerudo King":
			ui.enemyImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/monsters/Final Bosses/Ganon.png")).getImage();
			break;

		case "Gremlin":
			ui.enemyImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/monsters/Goblin1.png")).getImage();
			break;

		case "Mini-Boss":
			ui.enemyImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/monsters/Wolf1.png")).getImage();
			break;

		case "Ogre":
			ui.enemyImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/monsters/Ogre1.png")).getImage();
			break;

		case "Skeleton":
			ui.enemyImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/monsters/Skeleton1.png")).getImage();
			break;
		}
	}
}
