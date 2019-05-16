package main;

import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import heroes.Hero;
import monsters.Monster;

public class VisibilityManager 
{
	UI ui;
	
	public VisibilityManager(UI ui2)
	{
		ui = ui2;
	}
	
	public void hideAll()
	{
		// Hide Title
		ui.titlePanel.setVisible(false);
		ui.lblMessage.setVisible(false);

		// Hide Single Battle
		ui.singleBattlePanel.setVisible(false);
		
		// Hide Battle
		ui.buttonBattlePanel.setVisible(false);
		
		// Hide Moves
		ui.movesPanel.setVisible(false);
		
		// Hide Attack Message
		ui.atkMsgPanel.setVisible(false);

		// Hide Results
		ui.resultsPanel.setVisible(false);
		
		// Hide Item Selection
		ui.itemPanel.setVisible(false);
		ui.lblYouHaveNone.setVisible(false);
		
		// Hide Stats
		ui.statsPanel.setVisible(false);
		
		// Hide New Or Old
		ui.newOrOldPanel.setVisible(false);

		// Hide Character Creation
		ui.ccPanel.setVisible(false);
		ui.errorPanel.setVisible(false);
		ui.infoPanel.setVisible(false);
		ui.defaultImgPanel.setVisible(false);
		ui.atkImgPanel.setVisible(false);
		ui.hurtImgPanel.setVisible(false);
		ui.slider.setVisible(false);

		// Hide Settings
		ui.settingsPanel.setVisible(false);

		// Hide Main Menu
		ui.mainMenuPanel.setVisible(false);

		// Hide Save Menu
		ui.savePanel.setVisible(false);

	}
	
	public void showTitleScreen()
	{
		hideAll();
		
		// Show Title
		ui.titlePanel.setVisible(true);
	}
	
	public void showBattleScreen(Hero player, Monster monster, int turnsLeft, int turnsOG)
	{
		hideAll();
		
		if(player != null)
		{
			ui.playerPic.setIcon(new ImageIcon(ui.playerImg));
			
			ui.playerHp.setText(player.getHp() + "/" + player.getTotalHp());
			ui.playerHealthBar.setMaximum(player.getTotalHp());
			ui.playerHealthBar.setValue(player.getHp());
			
			if(player.getGender().equalsIgnoreCase("female"))
			{
				ui.playerGenderImg = new ImageIcon(this.getClass().getResource("/resources/images/female.png")).getImage();
			}
			
			else
				ui.playerGenderImg = new ImageIcon(this.getClass().getResource("/resources/images/male.png")).getImage();
			
			ui.lblPlayerName.setText(player.getName());
		}
		
		if(monster != null)
		{
			ui.enemyPic.setIcon(new ImageIcon(ui.enemyImg));
			
			ui.enemyHP.setText(monster.getHp() + "/" + monster.getTotalHp());
			ui.enemyHealthBar.setMaximum(monster.getTotalHp());
			ui.enemyHealthBar.setValue(monster.getHp());
			
			if(monster.getGender().equalsIgnoreCase("female"))
			{
				ui.enemyGenderImg = new ImageIcon(this.getClass().getResource("/resources/images/female.png")).getImage();
			}
			
			else
				ui.enemyGenderImg = new ImageIcon(this.getClass().getResource("/resources/images/male.png")).getImage();
			
			ui.lblEnemyName.setText(monster.getName());
		}

		ui.lblNumberOfTurns.setText("Number of Turns Left: " + turnsLeft);
		
		// Show Battle
		ui.singleBattlePanel.setVisible(true);
		ui.buttonBattlePanel.setVisible(true);
	}
	
	public void showMoves(Hero player, Monster monster)
	{
		// Show Battle
		ui.singleBattlePanel.setVisible(true);
		ui.movesPanel.setVisible(true);
		
		ui.btnMoves1.setText(player.getMenu(1));
		ui.btnMoves1.setToolTipText(player.getMenuInfo(1)); // Tool Tip
		
		ui.btnMoves2.setText(player.getMenu(2));
		ui.btnMoves2.setToolTipText(player.getMenuInfo(2)); // Tool Tip
		
		ui.btnMoves3.setText("3");
		ui.btnMoves4.setText("Back");
	}
	
	public void showResults(int num)
	{
		hideAll();
		
		if(num == 0) // Defeat
		{
			ui.resultsImg = ui.defeatImg;
		}
		
		else if(num == 1) // Victory
		{
			ui.resultsImg = ui.victoryImg;
		}
		
		ui.resultsBG.setIcon(new ImageIcon(ui.resultsImg));
		
		// Show Results
		ui.singleBattlePanel.setVisible(true);
		ui.resultsPanel.setVisible(true);
	}
	
	public void showInfo(Hero player, Monster monster, int turnsLeft, int turnsOG)
	{
		hideAll();
		
		ui.singleBattlePanel.setVisible(true);
		ui.statsPanel.setVisible(true);
		
		ui.txtrPlayerStats.setText(player.getName() + ": " + player.getHp() + "/" + player.getTotalHp() + " hp \n     Gender: " + player.getGender() + "\n     Class: " + player.getHeroType() + "\n     Turns per round: " + turnsLeft);
		ui.txtrMonsterStats.setText(monster.getName() + ": " + monster.getHp() + "/" + monster.getTotalHp() + " hp" + "\n     Species: " + monster.getMstrType());
	}
	
	public void showItem(Hero player, Monster monster, int turnsLeft, int turnsOG)
	{
		hideAll();
		
		ui.singleBattlePanel.setVisible(true);
		ui.itemPanel.setVisible(true);
		ui.lblYouHaveNone.setVisible(false);
		
		// Strength Pots
		if(player.getStrPot() == 1)
		{
			ui.strPotNum = "1 Strength Potion";
		}
		
		else
		{
			String num = player.getStrPot() + "";
			ui.strPotNum = num + " Strength Potions";
		}
		
		// Accuracy Pots
		if(player.getCharm() == 1)
		{
			ui.glPotNum = "1 Accuracy Potion";
		}
		
		else
		{
			String num = player.getCharm() + "";
			ui.glPotNum = num + " Accuracy Potions";
		}
		
		// Health Pots
		if(player.getPotions() == 1)
		{
			ui.potNum = "1 Health Potion";
		}
		
		else
		{
			String num = player.getPotions() + "";
			ui.potNum = num + " Health Potions";
		}
		
		ui.strPot.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), ui.strPotNum, TitledBorder.CENTER, TitledBorder.BOTTOM, null, Color.BLACK));
		ui.glCharm.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), ui.glPotNum, TitledBorder.CENTER, TitledBorder.BOTTOM, null, Color.BLACK));
		ui.potionPic.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), ui.potNum, TitledBorder.CENTER, TitledBorder.BOTTOM, null, Color.BLACK));
	}
	
	public int showAtkMsg(Hero player, Monster monster, int turnsLeft, int turnsOG, String msg)
	{
		hideAll();
		
		if(turnsLeft > 0)
		{
			ui.singleBattlePanel.setVisible(true);
			ui.atkMsgPanel.setVisible(true);
			ui.atkMsg.setText(msg);
			
			turnsLeft--;
		}
		
		else if(turnsLeft <= 0)
		{
			String temp = monster.attack(player);
			
			ui.singleBattlePanel.setVisible(true);
			ui.atkMsgPanel.setVisible(true);
			ui.atkMsg.setText("Monster's Turn:\n" + temp);
			
			turnsLeft = turnsOG;
		}
		
		return turnsLeft;
	}
	
	public void newOrOldScreen()
	{
		hideAll();
		
		// Show New Or Old
		ui.newOrOldPanel.setVisible(true);
		
		// Set Buton to Quit
		ui.button.setText("Quit");
		ui.button.setActionCommand("quit");
	}
	
	public void heroSelect(int num)
	{
		hideAll();
		
		// Pictures
		switch(ui.heroType)
		{
		case "h1": // Warrior
			if(ui.heroGender.equalsIgnoreCase("Male"))
				ui.slider.setMaximum(5);
			
			else
				ui.slider.setMaximum(6);
			
			break;
			
		case "h2": // Sorceress
			if(ui.heroGender.equalsIgnoreCase("Male"))
				ui.slider.setMaximum(6);
			
			else
				ui.slider.setMaximum(3);
			
			break;
			
		case "h3": // Thief
			if(ui.heroGender.equalsIgnoreCase("Male"))
				ui.slider.setMaximum(4);
			
			else
				ui.slider.setMaximum(4);
			
			break;
			
		case "h4": // Knight
			if(ui.heroGender.equalsIgnoreCase("Male"))
				ui.slider.setMaximum(4);
			
			else
				ui.slider.setMaximum(4);
			
			break;
			
		case "h5": // Battle Mage
			if(ui.heroGender.equalsIgnoreCase("Male"))
				ui.slider.setMaximum(4);
			
			else
				ui.slider.setMaximum(5);
			
			break;
			
		case "h6": // Game Master
			ui.slider.setMaximum(3);
			break;
		}
		
		if(ui.heroType.equalsIgnoreCase("h4"))
		{
			if(ui.heroGender.equalsIgnoreCase("Male"))
				ui.slider.setMaximum(3);
			
			else
				ui.slider.setMaximum(3);
		}
		
		if(ui.heroType.equalsIgnoreCase("h3"))
		{
			if(ui.heroGender.equalsIgnoreCase("Male"))
				ui.slider.setMaximum(3);
			
			else
				ui.slider.setMaximum(3);
		}
		
		ui.ccPanel.setVisible(true);
		
		if(num == 0) // No Jokes
		{
			ui.btnGM.setVisible(false);
		}
		
		else if(num == 1) // Jokes
		{
			ui.btnGM.setVisible(true);
		}
		
		infoMode();
	}
	
	public void showSettings(int jokes, int hardcore)
	{	
		hideAll();
		
		ui.checkJoke(jokes);
		ui.checkHard(hardcore);
		
		// Show Settings
		ui.settingsPanel.setVisible(true);
	}
	
	public void showMainMenu()
	{
		hideAll();
		
		// Show Main Menu
		ui.mainMenuPanel.setVisible(true);
	}
	
	public void showSaveMenu(int mode, File saveGame) // 0 is no Override, 1 is Override
	{
		hideAll();
		
		if(mode == 0)
		{			
			// Show Main Menu
			ui.mainMenuPanel.setVisible(true);
			ui.lblMessage.setVisible(true);
		}
		
		else //if(mode == 1)
		{
			Hero savePlayer = Game.loadSave(saveGame);
			
			ui.txtrSave.setText("Would you like to overwrite your current save?"
									   + "\n\tCurrent Save: " + savePlayer.getName()
									   + "\n\tClass: " + savePlayer.getHeroType());
			
			ui.savePanel.setVisible(true);
		}
	}
	
	public void saveComplete()
	{
		hideAll();
		
		ui.lblMessage.setText("Your game has been saved!");
		
		ui.mainMenuPanel.setVisible(true);
		ui.lblMessage.setVisible(true);
	}
	
	public void saveError()
	{
		hideAll();
		
		ui.lblMessage.setText("Unable to save game, please check your files.");
		
		ui.mainMenuPanel.setVisible(true);
		ui.lblMessage.setVisible(true);
	}
	
	public void loadError(int jokes)
	{
		heroSelect(jokes);
		ui.errorPanel.setVisible(true);
	}
	
	public void removeError(int jokes)
	{
		hideAll();
		heroSelect(jokes);
	}
	
	public void newHero(int jokes)
	{
		hideAll();
		
		heroSelect(jokes);
		ui.button.setText("Back");
		ui.button.setActionCommand("back");
	}
	
	public void infoMode()
	{
		if(ui.rdbtnInformationMode.isSelected()) // Is Checked
		{
			ui.slider.setVisible(false);
			ui.defaultImgPanel.setVisible(false);
			ui.atkImgPanel.setVisible(false);
			ui.hurtImgPanel.setVisible(false);
			ui.infoPanel.setVisible(true);
			ui.btnWarrior.setActionCommand("info1");
			ui.btnSorceress.setActionCommand("info2");
			ui.btnThief.setActionCommand("info3");
			ui.btnKnight.setActionCommand("info4");
			ui.btnBattleMage.setActionCommand("info5");
			ui.btnGM.setActionCommand("info6");
			
		}
		
		else // Not Checked
		{
			ui.slider.setVisible(true);
			ui.defaultImgPanel.setVisible(true);
			ui.atkImgPanel.setVisible(true);
			ui.hurtImgPanel.setVisible(true);
			ui.infoPanel.setVisible(false);
			ui.txtrInfo.setText("");
			ui.btnWarrior.setActionCommand("h1");
			ui.btnSorceress.setActionCommand("h2");
			ui.btnThief.setActionCommand("h3");
			ui.btnKnight.setActionCommand("h4");
			ui.btnBattleMage.setActionCommand("h5");
			ui.btnGM.setActionCommand("h6");
		}
	}
}
