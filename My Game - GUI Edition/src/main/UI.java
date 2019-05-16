package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import heroes.Aqua;
import heroes.BattleMage;
import heroes.Darkness;
import heroes.GameMaster;
import heroes.Hero;
import heroes.Kazuma;
import heroes.Knight;
import heroes.Megumin;
import heroes.Sorceress;
import heroes.Thief;
import heroes.Warrior;
import main.Game.ChoiceHandler;

public class UI 
{
	String heroType = "Default";
	String heroName = "Steven Bills";
	String heroGender = "Helicopter";
	
	JFrame window;
	
	// Title Screen
	JPanel titlePanel = new JPanel();
	JLabel lblMyGame = new JLabel("My Game");
	JPanel startPanel = new JPanel();
	JButton btnStart = new JButton("Start");
	
	// Main Menu
	JPanel mainMenuPanel = new JPanel();
	JLabel mainBG = new JLabel("");
	JLabel lblMyGame2 = new JLabel("My Game");
	JPanel mainButtonPanel = new JPanel();
	JButton btnSingleBattle = new JButton("Single Battle");
	JButton btnCampaignMode = new JButton("Campaign Mode");
	JButton btnMakeANew = new JButton("Make A New Character");
	JButton btnSaveGame = new JButton("Save Game");
	JButton btnSettings = new JButton("Settings");
	JButton btnQuit = new JButton("Quit");
	JLabel lblMessage = new JLabel("Message");
	
	// New or Old Save
	JPanel newOrOldPanel = new JPanel();
	JLabel lblWhichWouldYou = new JLabel("Which would you like to do:");
	JPanel loadPanel = new JPanel();
	JButton btnNewSave = new JButton("New Save");
	JButton btnLoadSave = new JButton("Load Save");
	JButton btnQuit2 = new JButton("Quit");
	
	// Single Battle
		// Attack Msg
	JPanel atkMsgPanel = new JPanel();
	JButton btnContinue = new JButton("Continue");
	JTextArea atkMsg = new JTextArea("   Message");
		
		// Main
	JPanel singleBattlePanel = new JPanel();
	JLabel bg = new JLabel("");
	
		// Results
	JPanel resultsPanel = new JPanel();
	JLabel resultsBG = new JLabel("");
	Image victoryImg = new ImageIcon(this.getClass().getResource("/resources/images/victory.jpg")).getImage();
	Image defeatImg = new ImageIcon(this.getClass().getResource("/resources/images/defeat.jpg")).getImage();
	Image resultsImg = victoryImg;
	JButton btnReturnMain = new JButton("Continue");
	
		// Stats
	JPanel statsPanel = new JPanel();
	JLabel statsBg = new JLabel("");
	JButton btnOk2 = new JButton("Ok");
	JTextArea txtrMonsterStats = new JTextArea();
	JTextArea txtrPlayerStats = new JTextArea();
	JLabel lblMonsterStats = new JLabel("Monster Stats");
	JLabel lblPlayerStats = new JLabel("Player Stats");

		// Item Select
	JPanel itemPanel = new JPanel();
	JButton btnStr = new JButton("");
	JButton btnGL = new JButton("");
	JButton btnPotion = new JButton("");
	JLabel lblYouHaveNone = new JLabel("You have none of that item");
	JLabel lblItemChoose = new JLabel("Which would you like to use?");
	JButton btnBack3 = new JButton("Back");
	String strPotNum = "2 Strength Potions";
	JLabel strPot = new JLabel("");
	String glPotNum = "3 Luck Potions";
	JLabel glCharm = new JLabel("");
	String potNum = "1 Health Potion";
	JLabel potionPic = new JLabel("");
	JLabel itemBG = new JLabel("");
	
		// Moves
	JPanel movesPanel = new JPanel();
	JButton btnMoves1 = new JButton("Move 1");
	JButton btnMoves2 = new JButton("Move 2");
	JButton btnMoves3 = new JButton("Move 3");
	JButton btnMoves4 = new JButton("Move 4");
	
		// Battle Screen
	JLabel enemyPic = new JLabel("");
	Image enemyImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
	JLabel playerPic = new JLabel("");
	Image playerImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
	JLabel playerHp = new JLabel("100/100");
	JLabel enemyHP = new JLabel("100/100");
	JProgressBar enemyHealthBar = new JProgressBar();
	JProgressBar playerHealthBar = new JProgressBar();
	JLabel enemyGender = new JLabel("");
	JLabel playerGender = new JLabel("");
	Image enemyGenderImg = new ImageIcon(this.getClass().getResource("/resources/images/male.png")).getImage();
	Image playerGenderImg = new ImageIcon(this.getClass().getResource("/resources/images/female.png")).getImage();
	JLabel lblPlayerName = new JLabel("Player Name");
	JLabel lblEnemyName = new JLabel("Enemy Name");
	JLabel lblNumberOfTurns = new JLabel("Number of Turns Left: 3");
	JLabel lblWhatWouldYou = new JLabel("What would you like to do?");
	JPanel buttonBattlePanel = new JPanel();
	JButton btnMoves = new JButton("Fight");
	JButton btnItems = new JButton("Items");
	JButton btnStats = new JButton("Stats");
	JButton btnDefeat = new JButton("Defeat");
	
	// Settings
	JPanel settingsPanel = new JPanel();
	JLabel lblSettingsMenu = new JLabel("Settings Menu");
	JPanel checkBoxPanel = new JPanel();
	JCheckBox chckbxJokesMode = new JCheckBox("Jokes Mode");
	JCheckBox chckbxHardcoreMode = new JCheckBox("Hardcore Mode");
	JButton btnBack = new JButton("Back");
	
	// Character Creation
	JPanel ccPanel = new JPanel();
	JLabel ccBg = new JLabel("");
	
		// Error Msg
	JPanel errorPanel = new JPanel();
	JLabel lblError = new JLabel("Save Error");
	JTextArea errorMsg = new JTextArea("\n\tSave Game unable to be found. \n       Please check if your \"Save.txt\" is in the \n\t                current folder.\n\n                 You have been redirected to \n                         the creation menu.");
	JButton btnOk = new JButton("OK");
	
		// Buttons
	JPanel buttonPanel = new JPanel();
	JButton button = new JButton("Quit");
	JButton btnConfirm = new JButton("Confirm");
	
		// Info Panel
	JRadioButton rdbtnInformationMode = new JRadioButton("Information Mode");
	JPanel infoPanel = new JPanel();
	JTextArea txtrInfo = new JTextArea();
	
		// Picture Tabs
			// Tab 1
	JPanel defaultImgPanel = new JPanel();
	JLabel heroPic = new JLabel();
	Image heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
			//Tab 2
	JPanel atkImgPanel = new JPanel();
	JLabel heroAtkPic = new JLabel();
	Image heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
			// Tab 3
	JPanel hurtImgPanel = new JPanel();
	JLabel heroHurtPic = new JLabel();
	Image heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
	
	JPanel picTypePanel = new JPanel();
	JRadioButton rdbtnDefault = new JRadioButton("Default");
	JRadioButton rdbtnAttack = new JRadioButton("Attack");
	JRadioButton rdbtnInjured = new JRadioButton("Injured");
	int num = 1;

		// Class Selection
	JPanel classPanel = new JPanel();
	JButton btnWarrior = new JButton("Warrior");
	JButton btnSorceress = new JButton("Sorcer(er/ess)");
	JButton btnThief = new JButton("Thief");
	JButton btnBattleMage = new JButton("Battle Mage");
	JButton btnKnight = new JButton("Knight");
	JButton btnGM = new JButton("Game Master");
	
		// Other Stats
	JPanel genderPanel = new JPanel();
	JCheckBox chckbxMale = new JCheckBox("Male");
	JCheckBox chckbxFemale = new JCheckBox("Female");
	JLabel lblGender = new JLabel("Gender:");
	JTextArea txtrTypeHere = new JTextArea();
	JLabel lblName = new JLabel("Name:");
	JLabel lblClassSelected = new JLabel("Class Selected: ");
	JSlider slider = new JSlider();

	// Override
	JPanel savePanel = new JPanel();
	JTextArea txtrSave = new JTextArea();
	JPanel answerPanel = new JPanel();
	JButton btnYes = new JButton("Yes");
	JButton btnNo = new JButton("No");

	public void createUI(ChoiceHandler choiceHandler)
	{
	// Creating Window
		window = new JFrame("Kamiroth - The Adventure Game"); // Create Frame
		window.setBounds(100, 100, 800, 600);
		window.getContentPane().setBackground(Color.BLACK);
		window.getContentPane().setLayout(null);
		window.setLocationRelativeTo(null); // Open in the center of the Screen
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	// Title Screen
		titlePanel.setBackground(Color.BLACK);
		titlePanel.setToolTipText("");
		titlePanel.setOpaque(false);
		titlePanel.setBounds(40, 11, 704, 539);
		window.getContentPane().add(titlePanel);
		
		titlePanel.setLayout(null);
		
		lblMyGame.setBounds(120, 135, 463, 153);
		lblMyGame.setFont(new Font("Times New Roman", Font.PLAIN, 90));
		lblMyGame.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyGame.setForeground(Color.WHITE);
		titlePanel.add(lblMyGame);
		
		startPanel.setBorder(null);
		startPanel.setBackground(Color.BLACK);
		startPanel.setOpaque(false);
		startPanel.setBounds(266, 367, 171, 114);
		titlePanel.add(startPanel);
		startPanel.setLayout(null);
		
		btnStart.setBorder(new LineBorder(new Color(255, 255, 255), 3));
		btnStart.setContentAreaFilled(false);
		btnStart.setToolTipText("Click Me!!");
		btnStart.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		btnStart.setFocusPainted(false);
		btnStart.setBackground(Color.black);
		btnStart.setForeground(Color.white);
		btnStart.setBounds(-63, 26, 297, 63);
		btnStart.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
				btnStart.setBackground(Color.white);
				btnStart.setForeground(Color.black);
				btnStart.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
				btnStart.setBackground(Color.black);
				btnStart.setForeground(Color.white);
				btnStart.setOpaque(true);
		    }
		}
		);
		btnStart.addActionListener(choiceHandler);
		btnStart.setActionCommand("start");
		startPanel.add(btnStart);
		
	// Main Menu
		mainMenuPanel.setOpaque(false);
		mainMenuPanel.setBounds(0, 0, 784, 561);
		window.getContentPane().add(mainMenuPanel);
		mainMenuPanel.setLayout(null);
		
		lblMessage.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 3), new LineBorder(new Color(255, 255, 255), 4)));
		lblMessage.setBackground(Color.BLACK);
		lblMessage.setOpaque(true);
		lblMessage.setBounds(181, 300, 422, 38);
		lblMessage.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(Color.WHITE);
		lblMessage.setVisible(false);
		mainMenuPanel.add(lblMessage);
		
		mainButtonPanel.setOpaque(false);
		mainButtonPanel.setBounds(280, 338, 224, 205);
		mainMenuPanel.add(mainButtonPanel);
		mainButtonPanel.setLayout(new GridLayout(0, 1, 0, 5));
		
		btnSingleBattle.setBounds(185, 317, 91, 48);
		btnSingleBattle.setContentAreaFilled(false);
		btnSingleBattle.setOpaque(true);
		btnSingleBattle.setForeground(Color.BLACK);
		btnSingleBattle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSingleBattle.setFocusPainted(false);
		btnSingleBattle.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSingleBattle.setBackground(Color.WHITE);
		btnSingleBattle.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnSingleBattle.setBackground(Color.BLACK);
		    	btnSingleBattle.setForeground(Color.WHITE);
		    	btnSingleBattle.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnSingleBattle.setBackground(Color.WHITE);
		    	btnSingleBattle.setForeground(Color.BLACK);
		    	btnSingleBattle.setOpaque(true);
		    }
		}
		);
		btnSingleBattle.addActionListener(choiceHandler);
		btnSingleBattle.setActionCommand("single");
		mainButtonPanel.add(btnSingleBattle);
		
		btnCampaignMode.setContentAreaFilled(false);
		btnCampaignMode.setOpaque(true);
		btnCampaignMode.setForeground(Color.BLACK);
		btnCampaignMode.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnCampaignMode.setFocusPainted(false);
		btnCampaignMode.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnCampaignMode.setBackground(Color.WHITE);
		btnCampaignMode.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnCampaignMode.setBackground(Color.BLACK);
		    	btnCampaignMode.setForeground(Color.WHITE);
		    	btnCampaignMode.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnCampaignMode.setBackground(Color.WHITE);
		    	btnCampaignMode.setForeground(Color.BLACK);
		    	btnCampaignMode.setOpaque(true);
		    }
		}
		);
		btnCampaignMode.addActionListener(choiceHandler);
		btnCampaignMode.setActionCommand("story");
		mainButtonPanel.add(btnCampaignMode);
		
		btnMakeANew.setContentAreaFilled(false);
		btnMakeANew.setOpaque(true);
		btnMakeANew.setForeground(Color.BLACK);
		btnMakeANew.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnMakeANew.setFocusPainted(false);
		btnMakeANew.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnMakeANew.setBackground(Color.WHITE);
		btnMakeANew.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnMakeANew.setBackground(Color.BLACK);
		    	btnMakeANew.setForeground(Color.WHITE);
		    	btnMakeANew.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnMakeANew.setBackground(Color.WHITE);
		    	btnMakeANew.setForeground(Color.BLACK);
		    	btnMakeANew.setOpaque(true);
		    }
		}
		);
		btnMakeANew.addActionListener(choiceHandler);
		btnMakeANew.setActionCommand("newHero");
		mainButtonPanel.add(btnMakeANew);
		
		btnSaveGame.setContentAreaFilled(false);
		btnSaveGame.setOpaque(true);
		btnSaveGame.setForeground(Color.BLACK);
		btnSaveGame.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSaveGame.setFocusPainted(false);
		btnSaveGame.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSaveGame.setBackground(Color.WHITE);
		btnSaveGame.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnSaveGame.setBackground(Color.BLACK);
		    	btnSaveGame.setForeground(Color.WHITE);
		    	btnSaveGame.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnSaveGame.setBackground(Color.WHITE);
		    	btnSaveGame.setForeground(Color.BLACK);
		    	btnSaveGame.setOpaque(true);
		    }
		}
		);
		btnSaveGame.addActionListener(choiceHandler);
		btnSaveGame.setActionCommand("save");
		mainButtonPanel.add(btnSaveGame);
		
		btnSettings.setContentAreaFilled(false);
		btnSettings.setOpaque(true);
		btnSettings.setForeground(Color.BLACK);
		btnSettings.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSettings.setFocusPainted(false);
		btnSettings.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnSettings.setBackground(Color.WHITE);
		btnSettings.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnSettings.setBackground(Color.BLACK);
		    	btnSettings.setForeground(Color.WHITE);
		    	btnSettings.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnSettings.setBackground(Color.WHITE);
		    	btnSettings.setForeground(Color.BLACK);
		    	btnSettings.setOpaque(true);
		    }
		}
		);
		btnSettings.addActionListener(choiceHandler);
		btnSettings.setActionCommand("settings");
		mainButtonPanel.add(btnSettings);
		
		btnQuit.setContentAreaFilled(false);
		btnQuit.setOpaque(true);
		btnQuit.setForeground(Color.BLACK);
		btnQuit.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnQuit.setFocusPainted(false);
		btnQuit.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		btnQuit.setBackground(Color.WHITE);
		btnQuit.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnQuit.setBackground(Color.BLACK);
		    	btnQuit.setForeground(Color.WHITE);
		    	btnQuit.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnQuit.setBackground(Color.WHITE);
		    	btnQuit.setForeground(Color.BLACK);
		    	btnQuit.setOpaque(true);
		    }
		}
		);
		btnQuit.addActionListener(choiceHandler);
		btnQuit.setActionCommand("quit");
		mainButtonPanel.add(btnQuit);
		
		mainBG.setBounds(0, 0, 784, 561);
		Image mainBgImg = new ImageIcon(this.getClass().getResource("/resources/images/MainBG.png")).getImage();
		mainBG.setIcon(new ImageIcon(mainBgImg));
		mainMenuPanel.add(mainBG);
		
	// New or Old
		newOrOldPanel.setBackground(Color.BLACK);
		newOrOldPanel.setToolTipText("");
		newOrOldPanel.setOpaque(false);
		newOrOldPanel.setBounds(40, 11, 704, 539);
		window.getContentPane().add(newOrOldPanel);
		newOrOldPanel.setLayout(null);
		
		lblWhichWouldYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhichWouldYou.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblWhichWouldYou.setForeground(Color.WHITE);
		lblWhichWouldYou.setBounds(102, 137, 499, 73);
		newOrOldPanel.add(lblWhichWouldYou);
		
		loadPanel.setOpaque(false);
		loadPanel.setBounds(234, 286, 236, 189);
		newOrOldPanel.add(loadPanel);
		loadPanel.setLayout(new GridLayout(3, 0, 0, 3));
		
		btnNewSave.setBorder(new LineBorder(Color.WHITE, 2));
		btnNewSave.setForeground(Color.WHITE);
		btnNewSave.setContentAreaFilled(false);
		btnNewSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewSave.setFocusPainted(false);
		btnNewSave.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnNewSave.setBackground(Color.white);
		    	btnNewSave.setForeground(Color.black);
		    	btnNewSave.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnNewSave.setBackground(Color.black);
		    	btnNewSave.setForeground(Color.white);
		    	btnNewSave.setOpaque(true);
		    }
		}
		);
		btnNewSave.addActionListener(choiceHandler);
		btnNewSave.setActionCommand("nL1");
		loadPanel.add(btnNewSave);
		
		btnLoadSave.setForeground(Color.WHITE);
		btnLoadSave.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLoadSave.setContentAreaFilled(false);
		btnLoadSave.setBorder(new LineBorder(Color.WHITE, 2));
		btnLoadSave.setFocusPainted(false);
		btnLoadSave.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnLoadSave.setBackground(Color.white);
		    	btnLoadSave.setForeground(Color.black);
		    	btnLoadSave.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnLoadSave.setBackground(Color.black);
		    	btnLoadSave.setForeground(Color.white);
		    	btnLoadSave.setOpaque(true);
		    }
		}
		);
		btnLoadSave.addActionListener(choiceHandler);
		btnLoadSave.setActionCommand("nL2");
		loadPanel.add(btnLoadSave);
		
		btnQuit2.setForeground(Color.WHITE);
		btnQuit2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnQuit2.setContentAreaFilled(false);
		btnQuit2.setBorder(new LineBorder(Color.WHITE, 2));
		btnQuit2.setFocusPainted(false);
		btnQuit2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnQuit2.setBackground(Color.white);
		    	btnQuit2.setForeground(Color.black);
		    	btnQuit2.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnQuit2.setBackground(Color.black);
		    	btnQuit2.setForeground(Color.white);
		    	btnQuit2.setOpaque(true);
		    }
		}
		);
		btnQuit2.addActionListener(choiceHandler);
		btnQuit2.setActionCommand("quit");
		loadPanel.add(btnQuit2);
		
	// Attack Message
		atkMsgPanel.setBounds(37, 424, 713, 117);
		window.getContentPane().add(atkMsgPanel);
		atkMsgPanel.setBackground(new Color(108, 164, 158));
		atkMsgPanel.setLayout(null);
		
		btnContinue.setFocusPainted(false);
		btnContinue.setFont(new Font("Gill Sans MT", Font.PLAIN, 15));
		btnContinue.setBackground(Color.WHITE);
		btnContinue.setForeground(Color.BLACK);
		btnContinue.setBounds(611, 70, 102, 43);
		btnContinue.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnContinue.setBackground(Color.black);
		    	btnContinue.setForeground(Color.white);
		    	btnContinue.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnContinue.setBackground(Color.white);
		    	btnContinue.setForeground(Color.black);
		    	btnContinue.setOpaque(true);
		    }
		}
		);
		btnContinue.addActionListener(choiceHandler);
		btnContinue.setActionCommand("atkMsg");
		atkMsgPanel.add(btnContinue);
		
		atkMsg.setLineWrap(true);
		atkMsg.setForeground(Color.BLACK);
		atkMsg.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		atkMsg.setEditable(false);
		atkMsg.setBorder(null);
		atkMsg.setBackground(new Color(108, 164, 158));
		atkMsg.setBounds(0, 7, 713, 106);
		atkMsgPanel.add(atkMsg);
		
// Single Battle
		singleBattlePanel.setBackground(Color.BLACK);
		singleBattlePanel.setToolTipText("");
		singleBattlePanel.setOpaque(false);
		singleBattlePanel.setBounds(0, 0, 784, 561);
		window.getContentPane().add(singleBattlePanel);
		singleBattlePanel.setLayout(null);
		
		bg.setBounds(0, 0, 784, 561);
		Image bgImg = new ImageIcon(this.getClass().getResource("/resources/images/BattleScreen_Default.jpg")).getImage();
		bg.setIcon(new ImageIcon(bgImg));
		
	// Results Screen
		resultsPanel.setOpaque(false);
		resultsPanel.setBounds(10, 11, 764, 539);
		singleBattlePanel.add(resultsPanel);
		resultsPanel.setLayout(null);
		
		resultsBG.setBounds(0, 0, 764, 539);
		resultsBG.setIcon(new ImageIcon(resultsImg));
		
		btnReturnMain.setToolTipText("Click the Button");
		btnReturnMain.setFont(new Font("Segoe UI", Font.PLAIN, 40));
		btnReturnMain.setFocusPainted(false);
		btnReturnMain.setBounds(263, 413, 237, 93);
		resultsPanel.add(btnReturnMain);
		btnReturnMain.addActionListener(choiceHandler);
		btnReturnMain.setActionCommand("back");
		
		resultsPanel.add(resultsBG);
		
	// Show Stats
		statsPanel.setOpaque(false);
		statsPanel.setBounds(10, 11, 764, 539);
		singleBattlePanel.add(statsPanel);
		
		statsBg.setBounds(0, 0, 764, 539);
		statsBg.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		Image statsBgImg = new ImageIcon(this.getClass().getResource("/resources/images/statsBG.jpg")).getImage();
		statsPanel.setLayout(null);
		
		btnOk2.setFont(new Font("Sitka Small", Font.PLAIN, 25));
		btnOk2.setFocusPainted(false);
		btnOk2.setBounds(321, 481, 122, 47);
		btnOk2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnOk2.setBackground(Color.black);
		    	btnOk2.setForeground(Color.white);
		    	btnOk2.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnOk2.setBackground(Color.white);
		    	btnOk2.setForeground(Color.black);
		    	btnOk2.setOpaque(true);
		    }
		}
		);
		btnOk2.addActionListener(choiceHandler);
		btnOk2.setActionCommand("infoDone");
		statsPanel.add(btnOk2);
		
		txtrMonsterStats.setText("     Default Text");
		txtrMonsterStats.setTabSize(5);
		txtrMonsterStats.setLineWrap(true);
		txtrMonsterStats.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtrMonsterStats.setEditable(false);
		txtrMonsterStats.setForeground(Color.WHITE);
		txtrMonsterStats.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtrMonsterStats.setBounds(86, 296, 591, 179);
		statsPanel.add(txtrMonsterStats);
		
		txtrPlayerStats.setTabSize(5);
		txtrPlayerStats.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		txtrPlayerStats.setLineWrap(true);
		txtrPlayerStats.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		txtrPlayerStats.setEditable(false);
		txtrPlayerStats.setText("     Default Text");
		txtrPlayerStats.setForeground(Color.WHITE);
		txtrPlayerStats.setBounds(86, 68, 591, 179);
		statsPanel.add(txtrPlayerStats);
		
		lblMonsterStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblMonsterStats.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
		lblMonsterStats.setBounds(259, 234, 245, 74);
		lblMonsterStats.setForeground(Color.WHITE);
		statsPanel.add(lblMonsterStats);
		
		lblPlayerStats.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 30));
		lblPlayerStats.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlayerStats.setBounds(259, 0, 245, 74);
		lblPlayerStats.setForeground(Color.WHITE);
		statsPanel.add(lblPlayerStats);
		statsBg.setIcon(new ImageIcon(statsBgImg));
		statsPanel.add(statsBg);
		
	// Item Select
		itemPanel.setOpaque(false);
		itemPanel.setBounds(10, 11, 764, 539);
		singleBattlePanel.add(itemPanel);
		itemPanel.setLayout(null);
		
		btnBack3.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		btnBack3.setFocusPainted(false);
		btnBack3.setBounds(332, 490, 99, 38);
		btnBack3.addActionListener(choiceHandler);
		btnBack3.setActionCommand("itemBack");
		itemPanel.add(btnBack3);
		
		btnStr.setOpaque(false);
		btnStr.setFocusPainted(false);
		btnStr.setContentAreaFilled(false);
		btnStr.setBounds(507, 209, 167, 167);
		btnStr.addActionListener(choiceHandler);
		btnStr.setActionCommand("strength");
		itemPanel.add(btnStr);
		
		btnGL.setOpaque(false);
		btnGL.setFocusPainted(false);
		btnGL.setContentAreaFilled(false);
		btnGL.setBounds(292, 209, 179, 167);
		btnGL.addActionListener(choiceHandler);
		btnGL.setActionCommand("charm");
		itemPanel.add(btnGL);
		
		btnPotion.setOpaque(false);
		btnPotion.setFocusPainted(false);
		btnPotion.setContentAreaFilled(false);
		btnPotion.setBounds(87, 209, 167, 167);
		btnPotion.addActionListener(choiceHandler);
		btnPotion.setActionCommand("potion");
		itemPanel.add(btnPotion);
		
		lblYouHaveNone.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		lblYouHaveNone.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveNone.setBounds(159, 418, 445, 70);
		lblYouHaveNone.setForeground(Color.WHITE);
		itemPanel.add(lblYouHaveNone);
		
		lblItemChoose.setFont(new Font("Javanese Text", Font.PLAIN, 40));
		lblItemChoose.setHorizontalAlignment(SwingConstants.CENTER);
		lblItemChoose.setBounds(111, 134, 542, 76);
		lblItemChoose.setForeground(Color.WHITE);
		itemPanel.add(lblItemChoose);
		
		strPot.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), strPotNum, TitledBorder.CENTER, TitledBorder.BOTTOM, null, Color.BLACK));
		strPot.setBounds(507, 209, 167, 167);
		itemPanel.add(strPot);
		Image strImg = new ImageIcon(this.getClass().getResource("/resources/images/StrPot.png")).getImage();
		strPot.setIcon(new ImageIcon(strImg));
		
		glCharm.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), glPotNum, TitledBorder.CENTER, TitledBorder.BOTTOM, null, Color.BLACK));
		glCharm.setBounds(292, 209, 179, 167);
		itemPanel.add(glCharm);
		Image glImg = new ImageIcon(this.getClass().getResource("/resources/images/LuckPot.png")).getImage();
		glCharm.setIcon(new ImageIcon(glImg));
		
		potionPic.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), potNum, TitledBorder.CENTER, TitledBorder.BOTTOM, null, Color.BLACK));
		potionPic.setBounds(87, 209, 167, 167);
		itemPanel.add(potionPic);
		Image potImg = new ImageIcon(this.getClass().getResource("/resources/images/HpPot.png")).getImage();
		potionPic.setIcon(new ImageIcon(potImg));
		
		itemBG.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		itemBG.setBounds(0, 0, 764, 539);
		itemPanel.add(itemBG);
		Image itemBgImg = new ImageIcon(this.getClass().getResource("/resources/images/ItemBG.jpg")).getImage();
		itemBG.setIcon(new ImageIcon(itemBgImg));
		
	// Show Moves
		movesPanel.setOpaque(false);
		movesPanel.setBounds(358, 428, 389, 112);
		singleBattlePanel.add(movesPanel);
		movesPanel.setLayout(new GridLayout(2, 2, 2, 2));

		btnMoves1.setContentAreaFilled(false);
		btnMoves1.setOpaque(true);
		btnMoves1.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnMoves1.setFocusPainted(false);
		btnMoves1.setBackground(Color.RED);
		btnMoves1.setForeground(Color.WHITE);
		btnMoves1.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnMoves1.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				btnMoves1.setBackground(Color.PINK);
				btnMoves1.setForeground(Color.WHITE);
				btnMoves1.setOpaque(true);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				btnMoves1.setBackground(Color.RED);
				btnMoves1.setForeground(Color.WHITE);
				btnMoves1.setOpaque(true);
			}
		}
				);
		btnMoves1.addActionListener(choiceHandler);
		btnMoves1.setActionCommand("m1");
		movesPanel.add(btnMoves1);

		btnMoves2.setContentAreaFilled(false);
		btnMoves2.setOpaque(true);
		btnMoves2.setForeground(Color.WHITE);
		btnMoves2.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnMoves2.setFocusPainted(false);
		btnMoves2.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnMoves2.setBackground(Color.RED);
		btnMoves2.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				btnMoves2.setBackground(Color.PINK);
				btnMoves2.setForeground(Color.WHITE);
				btnMoves2.setOpaque(true);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				btnMoves2.setBackground(Color.RED);
				btnMoves2.setForeground(Color.WHITE);
				btnMoves2.setOpaque(true);
			}
		}
				);
		btnMoves2.addActionListener(choiceHandler);
		btnMoves2.setActionCommand("m2");
		movesPanel.add(btnMoves2);

		btnMoves3.setContentAreaFilled(false);
		btnMoves3.setOpaque(true);
		btnMoves3.setForeground(Color.WHITE);
		btnMoves3.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnMoves3.setFocusPainted(false);
		btnMoves3.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnMoves3.setBackground(Color.RED);
		btnMoves3.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				btnMoves3.setBackground(Color.PINK);
				btnMoves3.setForeground(Color.WHITE);
				btnMoves3.setOpaque(true);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				btnMoves3.setBackground(Color.RED);
				btnMoves3.setForeground(Color.WHITE);
				btnMoves3.setOpaque(true);
			}
		}
				);
		btnMoves3.addActionListener(choiceHandler);
		btnMoves3.setActionCommand("m3");
		movesPanel.add(btnMoves3);

		btnMoves4.setContentAreaFilled(false);
		btnMoves4.setOpaque(true);
		btnMoves4.setForeground(Color.WHITE);
		btnMoves4.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnMoves4.setFocusPainted(false);
		btnMoves4.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnMoves4.setBackground(Color.RED);
		btnMoves4.addMouseListener(new java.awt.event.MouseAdapter() 
		{
			public void mouseEntered(java.awt.event.MouseEvent evt) 
			{
				btnMoves4.setBackground(Color.PINK);
				btnMoves4.setForeground(Color.WHITE);
				btnMoves4.setOpaque(true);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) 
			{
				btnMoves4.setBackground(Color.RED);
				btnMoves4.setForeground(Color.WHITE);
				btnMoves4.setOpaque(true);
			}
		}
				);
		btnMoves4.addActionListener(choiceHandler);
		btnMoves4.setActionCommand("m4");
		movesPanel.add(btnMoves4);
		
	// Battle Screen		
		enemyPic.setHorizontalAlignment(SwingConstants.CENTER);
		enemyPic.setBounds(439, 11, 292, 208);
		enemyPic.setIcon(new ImageIcon(enemyImg));
		singleBattlePanel.add(enemyPic);
		
		playerPic.setHorizontalAlignment(SwingConstants.CENTER);
		playerPic.setBounds(58, 198, 292, 208);
		playerPic.setIcon(new ImageIcon(playerImg));
		singleBattlePanel.add(playerPic);
		
		playerHp.setHorizontalAlignment(SwingConstants.RIGHT);
		playerHp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		playerHp.setBounds(645, 360, 86, 16);
		singleBattlePanel.add(playerHp);
		
		enemyHP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		enemyHP.setHorizontalAlignment(SwingConstants.RIGHT);
		enemyHP.setBounds(230, 121, 86, 16);
		singleBattlePanel.add(enemyHP);
		
		enemyHealthBar.setForeground(new Color(0, 128, 0));
		enemyHealthBar.setValue(80);
		enemyHealthBar.setBounds(156, 103, 161, 15);
		singleBattlePanel.add(enemyHealthBar);
		
		playerHealthBar.setForeground(new Color(0, 128, 0));
		playerHealthBar.setValue(80);
		playerHealthBar.setBounds(571, 343, 161, 15);
		singleBattlePanel.add(playerHealthBar);
		
		enemyGender.setBounds(299, 72, 24, 24);
		enemyGender.setIcon(new ImageIcon(enemyGenderImg));
		singleBattlePanel.add(enemyGender);
		
		playerGender.setBounds(716, 311, 24, 24);
		playerGender.setIcon(new ImageIcon(playerGenderImg));
		singleBattlePanel.add(playerGender);
		
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPlayerName.setBounds(473, 311, 168, 24);
		singleBattlePanel.add(lblPlayerName);
		
		lblEnemyName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnemyName.setBounds(58, 72, 168, 24);
		singleBattlePanel.add(lblEnemyName);
		
		lblNumberOfTurns.setOpaque(false);
		lblNumberOfTurns.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfTurns.setForeground(Color.BLACK);
		lblNumberOfTurns.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblNumberOfTurns.setBorder(null);
		lblNumberOfTurns.setBackground(new Color(220, 220, 220));
		lblNumberOfTurns.setBounds(37, 474, 297, 49);
		singleBattlePanel.add(lblNumberOfTurns);
		
		lblWhatWouldYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblWhatWouldYou.setBackground(new Color(220, 220, 220));
		lblWhatWouldYou.setOpaque(false);
		lblWhatWouldYou.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		lblWhatWouldYou.setBorder(null);
		lblWhatWouldYou.setForeground(Color.BLACK);
		lblWhatWouldYou.setBounds(37, 440, 297, 49);
		singleBattlePanel.add(lblWhatWouldYou);
		
		buttonBattlePanel.setOpaque(false);
		buttonBattlePanel.setBounds(358, 428, 389, 112);
		singleBattlePanel.add(buttonBattlePanel);
		buttonBattlePanel.setLayout(new GridLayout(2, 2, 2, 2));
		
		btnMoves.setContentAreaFilled(false);
    	btnMoves.setOpaque(true);
		btnMoves.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnMoves.setFocusPainted(false);
		btnMoves.setBackground(Color.RED);
		btnMoves.setForeground(Color.WHITE);
		btnMoves.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnMoves.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
				btnMoves.setBackground(Color.PINK);
				btnMoves.setForeground(Color.WHITE);
		    	btnMoves.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
				btnMoves.setBackground(Color.RED);
				btnMoves.setForeground(Color.WHITE);
		    	btnMoves.setOpaque(true);
		    }
		}
		);
		btnMoves.addActionListener(choiceHandler);
		btnMoves.setActionCommand("movesMenu");
		buttonBattlePanel.add(btnMoves);
		
		btnItems.setContentAreaFilled(false);
		btnItems.setOpaque(true);
		btnItems.setForeground(Color.WHITE);
		btnItems.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnItems.setFocusPainted(false);
		btnItems.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnItems.setBackground(Color.ORANGE);
		btnItems.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnItems.setBackground(Color.YELLOW);
		    	btnItems.setForeground(Color.WHITE);
		    	btnItems.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnItems.setBackground(Color.ORANGE);
		    	btnItems.setForeground(Color.WHITE);
		    	btnItems.setOpaque(true);
		    }
		}
		);
		btnItems.addActionListener(choiceHandler);
		btnItems.setActionCommand("items");
		buttonBattlePanel.add(btnItems);
		
		btnStats.setContentAreaFilled(false);
		btnStats.setOpaque(true);
		btnStats.setForeground(Color.WHITE);
		btnStats.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnStats.setFocusPainted(false);
		btnStats.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnStats.setBackground(new Color(0, 128, 0));
		btnStats.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnStats.setBackground(Color.GREEN);
		    	btnStats.setForeground(Color.WHITE);
		    	btnStats.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnStats.setBackground(new Color(0, 128, 0));
		    	btnStats.setForeground(Color.WHITE);
		    	btnStats.setOpaque(true);
		    }
		}
		);
		btnStats.addActionListener(choiceHandler);
		btnStats.setActionCommand("stats");
		buttonBattlePanel.add(btnStats);
		
		btnDefeat.setContentAreaFilled(false);
		btnDefeat.setOpaque(true);
		btnDefeat.setForeground(Color.WHITE);
		btnDefeat.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnDefeat.setFocusPainted(false);
		btnDefeat.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnDefeat.setBackground(Color.BLUE);
		btnDefeat.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnDefeat.setBackground(Color.CYAN);
		    	btnDefeat.setForeground(Color.WHITE);
		    	btnDefeat.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnDefeat.setBackground(Color.BLUE);
		    	btnDefeat.setForeground(Color.WHITE);
		    	btnDefeat.setOpaque(true);
		    }
		}
		);
		btnDefeat.addActionListener(choiceHandler);
		btnDefeat.setActionCommand("admitDefeat");
		buttonBattlePanel.add(btnDefeat);
		
		singleBattlePanel.add(bg);		

	// Settings
		settingsPanel.setBackground(Color.BLACK);
		settingsPanel.setToolTipText("");
		settingsPanel.setOpaque(false);
		settingsPanel.setBounds(40, 11, 704, 539);
		window.getContentPane().add(settingsPanel);
		settingsPanel.setLayout(null);
		
		lblSettingsMenu.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettingsMenu.setForeground(Color.WHITE);
		lblSettingsMenu.setFont(new Font("Times New Roman", Font.PLAIN, 60));
		lblSettingsMenu.setBounds(154, 42, 396, 101);
		settingsPanel.add(lblSettingsMenu);
		
		checkBoxPanel.setBounds(224, 177, 256, 225);
		settingsPanel.add(checkBoxPanel);
		checkBoxPanel.setLayout(new GridLayout(2, 0, 0, 5));
		
		chckbxJokesMode.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		chckbxJokesMode.setBackground(Color.BLACK);
		chckbxJokesMode.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		chckbxJokesMode.setForeground(Color.WHITE);
		chckbxJokesMode.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxJokesMode.setToolTipText("Jokes Mode contains various easter eggs and references.");
		chckbxJokesMode.setFocusPainted(false);
		chckbxJokesMode.addActionListener(choiceHandler);
		chckbxJokesMode.setActionCommand("joke");
		checkBoxPanel.add(chckbxJokesMode);
		
		chckbxHardcoreMode.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxHardcoreMode.setForeground(Color.WHITE);
		chckbxHardcoreMode.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		chckbxHardcoreMode.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		chckbxHardcoreMode.setBackground(Color.BLACK);
		chckbxHardcoreMode.setToolTipText("Hardcore Mode means that deaths and item loss carries over between battles in Campaign Mode.");
		chckbxHardcoreMode.setFocusPainted(false);
		chckbxHardcoreMode.addActionListener(choiceHandler);
		chckbxHardcoreMode.setActionCommand("hard");
		checkBoxPanel.add(chckbxHardcoreMode);
		
		btnBack.setBorder(new LineBorder(Color.WHITE, 2));
		btnBack.setForeground(Color.WHITE);
		btnBack.setContentAreaFilled(false);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setBounds(307, 456, 89, 39);
		btnBack.setFocusPainted(false);
		btnBack.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnBack.setBackground(Color.white);
		    	btnBack.setForeground(Color.black);
		    	btnBack.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnBack.setBackground(Color.black);
		    	btnBack.setForeground(Color.white);
		    	btnBack.setOpaque(true);
		    }
		}
		);
		btnBack.addActionListener(choiceHandler);
		btnBack.setActionCommand("back");
		settingsPanel.add(btnBack);
		
	// Character Creation
		ccPanel.setBackground(Color.BLACK);
		ccPanel.setToolTipText("");
		ccPanel.setOpaque(false);
		ccPanel.setBounds(0, 0, 784, 561);
		window.getContentPane().add(ccPanel);
		ccPanel.setLayout(null);
				
		ccBg.setBounds(0, 0, 784, 561);
		Image img = new ImageIcon(this.getClass().getResource("/resources/images/CharacterCreation.png")).getImage();
		ccBg.setIcon(new ImageIcon(img));
		
		UIManager.put("TabbedPane.contentOpaque", false);
		UIManager.put("TabbedPane.borderHightlightColor", java.awt.Color.BLACK);
		UIManager.put("TabbedPane.foreground", java.awt.Color.BLACK);
		
		// Error Message
		errorPanel.setBorder(new LineBorder(new Color(0, 0, 0), 5));
		errorPanel.setBounds(161, 94, 461, 373);
		ccPanel.add(errorPanel);
		errorPanel.setLayout(null);
		
		lblError.setForeground(Color.BLACK);
		lblError.setFont(new Font("SimSun", Font.PLAIN, 60));
		lblError.setHorizontalAlignment(SwingConstants.CENTER);
		lblError.setBounds(51, 21, 359, 69);
		errorPanel.add(lblError);
		
		errorMsg.setBorder(new LineBorder(Color.GRAY));
		errorMsg.setForeground(Color.BLACK);
		errorMsg.setLineWrap(true);
		errorMsg.setTabSize(4);
		errorMsg.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 20));
		errorMsg.setOpaque(false);
		errorMsg.setEditable(false);
		errorMsg.setBounds(28, 99, 404, 207);
		errorPanel.add(errorMsg);
		
		btnOk.setBounds(185, 317, 91, 48);
		btnOk.setContentAreaFilled(false);
		btnOk.setOpaque(true);
		btnOk.setForeground(Color.BLACK);
		btnOk.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnOk.setFocusPainted(false);
		btnOk.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnOk.setBackground(Color.WHITE);
		btnOk.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnOk.setBackground(Color.BLACK);
		    	btnOk.setForeground(Color.WHITE);
		    	btnOk.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnOk.setBackground(Color.WHITE);
		    	btnOk.setForeground(Color.BLACK);
		    	btnOk.setOpaque(true);
		    }
		}
		);
		btnOk.addActionListener(choiceHandler);
		btnOk.setActionCommand("removeError");
		errorPanel.add(btnOk);
		
		// Information
		rdbtnInformationMode.setHorizontalAlignment(SwingConstants.RIGHT);
		rdbtnInformationMode.setFocusPainted(false);
		rdbtnInformationMode.setContentAreaFilled(false);
		rdbtnInformationMode.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		rdbtnInformationMode.setToolTipText("Will Display Information about a Class");
		rdbtnInformationMode.setForeground(Color.BLACK);
		rdbtnInformationMode.setOpaque(false);
		rdbtnInformationMode.setBorder(new LineBorder(Color.WHITE, 2));
		rdbtnInformationMode.setBounds(527, 80, 200, 23);
		rdbtnInformationMode.addActionListener(choiceHandler);
		rdbtnInformationMode.setActionCommand("info");
		ccPanel.add(rdbtnInformationMode);
		
		infoPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		infoPanel.setBounds(349, 122, 425, 334);
		ccPanel.add(infoPanel);
		infoPanel.setLayout(null);
		
		txtrInfo.setOpaque(false);
		txtrInfo.setForeground(Color.BLACK);
		txtrInfo.setLineWrap(true);
		txtrInfo.setEditable(false);
		txtrInfo.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtrInfo.setText("Info");
		txtrInfo.setBounds(10, 11, 405, 312);
		infoPanel.add(txtrInfo);
		
		// Confirm or Quit
		buttonPanel.setOpaque(false);
		buttonPanel.setBounds(566, 500, 208, 40);
		ccPanel.add(buttonPanel);
		buttonPanel.setLayout(new GridLayout(0, 2, 5, 2));
		
		btnConfirm.setContentAreaFilled(false);
		btnConfirm.setOpaque(true);
		btnConfirm.setForeground(Color.BLACK);
		btnConfirm.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		btnConfirm.setFocusPainted(false);
		btnConfirm.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnConfirm.setBackground(Color.WHITE);
		btnConfirm.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnConfirm.setBackground(Color.BLACK);
		    	btnConfirm.setForeground(Color.WHITE);
		    	btnConfirm.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnConfirm.setBackground(Color.WHITE);
		    	btnConfirm.setForeground(Color.BLACK);
		    	btnConfirm.setOpaque(true);
		    }
		}
		);
		btnConfirm.addActionListener(choiceHandler);
		btnConfirm.setActionCommand("heroConfirm");
		buttonPanel.add(btnConfirm);
		
		// Source: https://stackoverflow.com/questions/16390503/java-swing-getting-input-from-a-jtextfield
		btnConfirm.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				heroName = txtrTypeHere.getText();
				txtrTypeHere.setText("");             
			}
		}
		);
		
		button.setContentAreaFilled(false);
		button.setOpaque(true);
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		button.setFocusPainted(false);
		button.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		button.setBackground(Color.WHITE);
		button.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	button.setBackground(Color.BLACK);
		    	button.setForeground(Color.WHITE);
		    	button.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	button.setBackground(Color.WHITE);
		    	button.setForeground(Color.BLACK);
		    	button.setOpaque(true);
		    }
		}
		);
		button.addActionListener(choiceHandler);
		button.setActionCommand("quit");
		buttonPanel.add(button);
		
		// Pictures
		defaultImgPanel.setBounds(434, 196, 292, 208);
		defaultImgPanel.setOpaque(false);
		defaultImgPanel.setToolTipText("");
		ccPanel.add(defaultImgPanel);
		defaultImgPanel.setLayout(null);
		
		heroPic.setHorizontalAlignment(SwingConstants.CENTER);
		heroPic.setBounds(0, 0, 292, 208);
		heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
		heroPic.setIcon(new ImageIcon(heroImg));
		defaultImgPanel.add(heroPic);
		
		atkImgPanel.setBounds(434, 196, 292, 208);
		atkImgPanel.setOpaque(false);
		ccPanel.add(atkImgPanel);
		atkImgPanel.setLayout(null);
		
		heroAtkPic.setHorizontalAlignment(SwingConstants.CENTER);
		heroAtkPic.setBounds(0, 0, 292, 208);
		heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
		
		atkImgPanel.add(heroAtkPic);
		
		hurtImgPanel.setBounds(434, 196, 292, 208);
		hurtImgPanel.setOpaque(false);
		ccPanel.add(hurtImgPanel);
		hurtImgPanel.setLayout(null);
		
		heroHurtPic.setHorizontalAlignment(SwingConstants.CENTER);
		heroHurtPic.setBounds(0, 0, 292, 208);
		heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
		
		hurtImgPanel.add(heroHurtPic);
		
		picTypePanel.setOpaque(false);
		picTypePanel.setBounds(434, 163, 292, 22);
		ccPanel.add(picTypePanel);
		picTypePanel.setLayout(new GridLayout(0, 3, 3, 0));
		
		rdbtnDefault.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnDefault.setOpaque(false);
		rdbtnDefault.addActionListener(choiceHandler);
		rdbtnDefault.setActionCommand("defPic");
		picTypePanel.add(rdbtnDefault);
		
		rdbtnAttack.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnAttack.setOpaque(false);
		rdbtnAttack.addActionListener(choiceHandler);
		rdbtnAttack.setActionCommand("atkPic");
		picTypePanel.add(rdbtnAttack);
		
		rdbtnInjured.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnInjured.setOpaque(false);
		rdbtnInjured.addActionListener(choiceHandler);
		rdbtnInjured.setActionCommand("hurtPic");
		picTypePanel.add(rdbtnInjured);
		
		// Class Selection
		classPanel.setOpaque(false);
		classPanel.setBounds(67, 122, 256, 334);
		ccPanel.add(classPanel);
		classPanel.setLayout(new GridLayout(6, 0, 0, 2));
		
		btnWarrior.setContentAreaFilled(false);
		btnWarrior.setOpaque(true);
		btnWarrior.setForeground(Color.BLACK);
		btnWarrior.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnWarrior.setFocusPainted(false);
		btnWarrior.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnWarrior.setBackground(Color.WHITE);
		btnWarrior.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnWarrior.setBackground(Color.BLACK);
		    	btnWarrior.setForeground(Color.WHITE);
		    	btnWarrior.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnWarrior.setBackground(Color.WHITE);
		    	btnWarrior.setForeground(Color.BLACK);
		    	btnWarrior.setOpaque(true);
		    }
		}
		);
		btnWarrior.addActionListener(choiceHandler);
		btnWarrior.setActionCommand("h1");
		classPanel.add(btnWarrior);
		
		btnSorceress.setContentAreaFilled(false);
		btnSorceress.setOpaque(true);
		btnSorceress.setForeground(Color.BLACK);
		btnSorceress.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnSorceress.setFocusPainted(false);
		btnSorceress.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnSorceress.setBackground(Color.WHITE);
		btnSorceress.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnSorceress.setBackground(Color.BLACK);
		    	btnSorceress.setForeground(Color.WHITE);
		    	btnSorceress.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnSorceress.setBackground(Color.WHITE);
		    	btnSorceress.setForeground(Color.BLACK);
		    	btnSorceress.setOpaque(true);
		    }
		}
		);
		btnSorceress.addActionListener(choiceHandler);
		btnSorceress.setActionCommand("h2");
		classPanel.add(btnSorceress);
		
		btnThief.setContentAreaFilled(false);
		btnThief.setOpaque(true);
		btnThief.setForeground(Color.BLACK);
		btnThief.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnThief.setFocusPainted(false);
		btnThief.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnThief.setBackground(Color.WHITE);
		btnThief.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnThief.setBackground(Color.BLACK);
		    	btnThief.setForeground(Color.WHITE);
		    	btnThief.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnThief.setBackground(Color.WHITE);
		    	btnThief.setForeground(Color.BLACK);
		    	btnThief.setOpaque(true);
		    }
		}
		);
		btnThief.addActionListener(choiceHandler);
		btnThief.setActionCommand("h3");
		classPanel.add(btnThief);
		
		btnKnight.setContentAreaFilled(false);
		btnKnight.setOpaque(true);
		btnKnight.setForeground(Color.BLACK);
		btnKnight.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnKnight.setFocusPainted(false);
		btnKnight.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnKnight.setBackground(Color.WHITE);
		btnKnight.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnKnight.setBackground(Color.BLACK);
		    	btnKnight.setForeground(Color.WHITE);
		    	btnKnight.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnKnight.setBackground(Color.WHITE);
		    	btnKnight.setForeground(Color.BLACK);
		    	btnKnight.setOpaque(true);
		    }
		}
		);
		btnKnight.addActionListener(choiceHandler);
		btnKnight.setActionCommand("h4");
		classPanel.add(btnKnight);
		
		btnBattleMage.setContentAreaFilled(false);
		btnBattleMage.setOpaque(true);
		btnBattleMage.setForeground(Color.BLACK);
		btnBattleMage.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnBattleMage.setFocusPainted(false);
		btnBattleMage.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnBattleMage.setBackground(Color.WHITE);
		btnBattleMage.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnBattleMage.setBackground(Color.BLACK);
		    	btnBattleMage.setForeground(Color.WHITE);
		    	btnBattleMage.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnBattleMage.setBackground(Color.WHITE);
		    	btnBattleMage.setForeground(Color.BLACK);
		    	btnBattleMage.setOpaque(true);
		    }
		}
		);
		btnBattleMage.addActionListener(choiceHandler);
		btnBattleMage.setActionCommand("h5");
		classPanel.add(btnBattleMage);
		
		btnGM.setContentAreaFilled(false);
		btnGM.setOpaque(true);
		btnGM.setForeground(Color.BLACK);
		btnGM.setFont(new Font("Sitka Small", Font.PLAIN, 30));
		btnGM.setFocusPainted(false);
		btnGM.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new LineBorder(new Color(255, 255, 255), 2)));
		btnGM.setBackground(Color.WHITE);
		btnGM.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnGM.setBackground(Color.BLACK);
		    	btnGM.setForeground(Color.WHITE);
		    	btnGM.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnGM.setBackground(Color.WHITE);
		    	btnGM.setForeground(Color.BLACK);
		    	btnGM.setOpaque(true);
		    }
		}
		);
		btnGM.addActionListener(choiceHandler);
		btnGM.setActionCommand("h6");
		classPanel.add(btnGM);
		
		// Gender
		genderPanel.setOpaque(false);
		genderPanel.setBounds(140, 510, 316, 23);
		ccPanel.add(genderPanel);
		genderPanel.setLayout(new GridLayout(1, 0, 0, 0));
		
		chckbxMale.setHorizontalAlignment(SwingConstants.CENTER);
		genderPanel.add(chckbxMale);
		chckbxMale.setForeground(Color.BLACK);
		chckbxMale.setContentAreaFilled(false);
		chckbxMale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxMale.setFocusPainted(false);
		chckbxMale.addActionListener(choiceHandler);
		chckbxMale.setActionCommand("male");
		
		chckbxFemale.setHorizontalAlignment(SwingConstants.CENTER);
		genderPanel.add(chckbxFemale);
		chckbxFemale.setForeground(Color.BLACK);
		chckbxFemale.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chckbxFemale.setContentAreaFilled(false);
		chckbxFemale.setFocusPainted(false);
		chckbxFemale.addActionListener(choiceHandler);
		chckbxFemale.setActionCommand("female");
		
		lblGender.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		lblGender.setForeground(Color.BLACK);
		lblGender.setBackground(Color.BLACK);
		lblGender.setBounds(67, 495, 192, 55);
		ccPanel.add(lblGender);
		
		// Name
		txtrTypeHere.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtrTypeHere.setTabSize(3);
		txtrTypeHere.setForeground(Color.BLACK);
		txtrTypeHere.setToolTipText("Type Here!!");
		txtrTypeHere.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtrTypeHere.setText("Type Here!!");
		txtrTypeHere.setBounds(139, 467, 250, 31);
		ccPanel.add(txtrTypeHere);
		
		txtrTypeHere.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			    int max = 25;
			    if(txtrTypeHere.getText().length() > max+1) {
			        e.consume();
			        String shortened = txtrTypeHere.getText().substring(0, max);
			        txtrTypeHere.setText(shortened);
			    }else if(txtrTypeHere.getText().length() > max) {
			        e.consume();
			    }
			}

			@Override
			public void keyPressed(KeyEvent arg0) 
			{
			}

			@Override
			public void keyReleased(KeyEvent arg0) 
			{
			}
		}
		);
		
		lblName.setFont(new Font("Sitka Small", Font.PLAIN, 20));
		lblName.setBounds(67, 462, 133, 45);
		lblName.setForeground(Color.BLACK);
		ccPanel.add(lblName);
		
		// Class Selected
		lblClassSelected.setForeground(Color.BLACK);
		lblClassSelected.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblClassSelected.setBackground(Color.BLACK);
		lblClassSelected.setBounds(67, 80, 256, 45);
		ccPanel.add(lblClassSelected);
		
		// Picture Slider
		slider.setValue(1);
		slider.setOpaque(false);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(1);
		slider.setMaximum(5);
		slider.setPaintLabels(true);
		slider.setMinorTickSpacing(1);
		slider.setSnapToTicks(true);
		slider.setBounds(434, 444, 289, 31);
		slider.addChangeListener(new ChangeListener() 
		{
			
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				num = slider.getValue();
				picUpdate(num);				
			}
		}
		);
		ccPanel.add(slider);
		
		ccPanel.add(ccBg);

	// Save Override
		savePanel.setBackground(Color.BLACK);
		savePanel.setToolTipText("");
		savePanel.setOpaque(false);
		savePanel.setBounds(40, 11, 704, 539);
		window.getContentPane().add(savePanel);
		savePanel.setLayout(null);
		
		txtrSave.setLineWrap(true);
		txtrSave.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtrSave.setOpaque(false);
		txtrSave.setEditable(false);
		txtrSave.setForeground(Color.WHITE);
		txtrSave.setText("Would you like to overwrite your current save?"
					   + "\n          Current Save: ");
		txtrSave.setBounds(37, 90, 630, 275);
		savePanel.add(txtrSave);
		
		answerPanel.setBackground(Color.BLACK);
		answerPanel.setOpaque(false);
		answerPanel.setBounds(283, 376, 138, 152);
		savePanel.add(answerPanel);
		answerPanel.setLayout(new GridLayout(2, 0, 0, 4));
		
		btnYes.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnYes.setForeground(Color.WHITE);
		btnYes.setBorder(new LineBorder(Color.WHITE, 3));
		btnYes.setFocusPainted(false);
		btnYes.setContentAreaFilled(false);
		btnYes.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnYes.setBackground(Color.white);
		    	btnYes.setForeground(Color.black);
		    	btnYes.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnYes.setBackground(Color.black);
		    	btnYes.setForeground(Color.white);
		    	btnYes.setOpaque(true);
		    }
		}
		);
		btnYes.addActionListener(choiceHandler);
		btnYes.setActionCommand("override");
		answerPanel.add(btnYes);
		
		btnNo.setForeground(Color.WHITE);
		btnNo.setFont(new Font("Times New Roman", Font.PLAIN, 35));
		btnNo.setContentAreaFilled(false);
		btnNo.setBorder(new LineBorder(Color.WHITE, 3));
		btnNo.setFocusPainted(false);
		btnNo.addMouseListener(new java.awt.event.MouseAdapter() 
		{
		    public void mouseEntered(java.awt.event.MouseEvent evt) 
		    {
		    	btnNo.setBackground(Color.white);
		    	btnNo.setForeground(Color.black);
		    	btnNo.setOpaque(true);
		    }

		    public void mouseExited(java.awt.event.MouseEvent evt) 
		    {
		    	btnNo.setBackground(Color.black);
		    	btnNo.setForeground(Color.white);
		    	btnNo.setOpaque(true);
		    }
		}
		);
		btnNo.addActionListener(choiceHandler);
		btnNo.setActionCommand("back");
		answerPanel.add(btnNo);

		// Character Creation Defaults
		rdbtnDefault.setSelected(true);
		heroGender = "Male";
		heroType = "h1"; // Warrior by Default
		lblClassSelected.setText("Class Selected: Warrior");
		chooseHero(heroType);
		
		rdbtnDefault.setVisible(false);
		rdbtnAttack.setVisible(false);
		rdbtnInjured.setVisible(false);
		
		// Tab 1
		defaultImgPanel.setVisible(true);
		heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/M1.png")).getImage();
		heroPic.setIcon(new ImageIcon(heroImg));
		
		//Tab 2
		
		heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
		
		heroAtkPic.setVisible(false);
		
		// Tab 3
		
		heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
		
		heroHurtPic.setVisible(false);
		
		chckbxMale.setSelected(true); // Male by Default
		chckbxFemale.setSelected(false);
		txtrTypeHere.setText("Type Here!!");
		
		window.setVisible(true); // Have the window pop-up on the screen (Keep at the bottom)
	}
	
	public void quit()
	{
		window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
	}
	
	public void picUpdate(int num)
	{
		switch(heroType)
		{
		case "h1": // Warrior
			if(heroGender.equalsIgnoreCase("Male"))
			{
				switch(num)
				{
				case 1:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/M1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					break;
					
				case 2:
					rdbtnDefault.setVisible(true);
					rdbtnAttack.setVisible(true);
					rdbtnInjured.setVisible(true);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/M2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/M2-Attack.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/M2-Injured.png")).getImage();
					break;
					
				case 3:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/M3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					break;
					
				case 4:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/M4.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					break;
					
				case 5:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/M5.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					break;
				}
			}
			
			else // Female
			{
				switch(num)
				{
				case 1:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 2:
					rdbtnDefault.setVisible(true);
					rdbtnAttack.setVisible(true);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					atkImgPanel.setVisible(true);
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F2-Attack.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 3:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 4:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F4.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 5:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F5.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 6:
					// Tab 1
					rdbtnDefault.setVisible(true);
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F6.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					rdbtnAttack.setVisible(true);
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F6-Attack.png")).getImage();
					
					// Tab 3
					rdbtnInjured.setVisible(true);
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Warrior/F6-Injured.png")).getImage();
					
					break;
				}
			}
			break;
			
		case "h2": // Sorceress
			if(heroGender.equalsIgnoreCase("Male"))
			{
				switch(num)
				{
				case 1:
					// Tab 1
					rdbtnDefault.setVisible(false);
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/M1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					rdbtnAttack.setVisible(false);
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					rdbtnInjured.setVisible(false);
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 2:
					// Tab 1
					rdbtnDefault.setVisible(false);
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/M2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					rdbtnAttack.setVisible(false);
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					rdbtnInjured.setVisible(false);
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 3:
					// Tab 1
					rdbtnDefault.setVisible(false);
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/M3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					rdbtnAttack.setVisible(false);
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					rdbtnInjured.setVisible(false);
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 4:
					// Tab 1
					rdbtnDefault.setVisible(false);
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/M4.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					rdbtnAttack.setVisible(false);
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					rdbtnInjured.setVisible(false);
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 5:
					// Tab 1
					rdbtnDefault.setVisible(false);
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/M5.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					rdbtnAttack.setVisible(false);
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					rdbtnInjured.setVisible(false);
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 6:
					// Tab 1
					rdbtnDefault.setVisible(false);
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/M6.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					rdbtnAttack.setVisible(false);
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					rdbtnInjured.setVisible(false);
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
				}
			}
			
			else // Female
			{
				switch(num)
				{
				case 1:
					rdbtnDefault.setVisible(true);
					rdbtnAttack.setVisible(true);
					rdbtnInjured.setVisible(true);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/F1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					atkImgPanel.setVisible(true);
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/F1-Attack.png")).getImage();
					
					// Tab 3
					hurtImgPanel.setVisible(true);
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/F1-Injured.png")).getImage();
					
					break;
					
				case 2:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/F2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 3:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Sorceress/F3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
				}
			}
			break;
			
		case "h3": // Thief
			if(heroGender.equalsIgnoreCase("Male"))
			{
				switch(num)
				{
				case 1:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Thief/M1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 2:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Thief/M2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 3:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Thief/M3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
				}
			}
			
			else // Female
			{
				switch(num)
				{
				case 1:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Thief/F1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 2:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Thief/F2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 3:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Thief/F3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
				}
			}
			break;
			
		case "h4": // Knight
			if(heroGender.equalsIgnoreCase("Male"))
			{
				switch(num)
				{
				case 1:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Knight/M1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 2:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Knight/M2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 3:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Knight/M3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
				}
			}
			
			else // Female
			{
				switch(num)
				{
				case 1:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Knight/F1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 2:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Knight/F2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 3:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Knight/F3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
				}
			}
			break;
			
		case "h5": // Battle Mage
			if(heroGender.equalsIgnoreCase("Male"))
			{
				switch(num)
				{
				case 1:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/M1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 2:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/M2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 3:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/M3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 4:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/M4.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
				}
			}
			
			else // Female
			{
				switch(num)
				{
				case 1:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/F1.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 2:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/F2.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 3:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/F3.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 4:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/F4.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
					
				case 5:
					rdbtnDefault.setVisible(false);
					rdbtnAttack.setVisible(false);
					rdbtnInjured.setVisible(false);
					
					// Tab 1
					defaultImgPanel.setVisible(true);
					heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/Battle Mage/F5.png")).getImage();
					heroPic.setIcon(new ImageIcon(heroImg));
					
					//Tab 2
					heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					// Tab 3
					heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
					
					break;
				}
			}
			break;
			
		case "h6": // Game Master
			switch(num)
			{
			case 1:
				rdbtnDefault.setVisible(false);
				rdbtnAttack.setVisible(false);
				rdbtnInjured.setVisible(false);
				
				// Tab 1
				defaultImgPanel.setVisible(true);
				heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/GM/CHand.png")).getImage();
				heroPic.setIcon(new ImageIcon(heroImg));
				
				//Tab 2
				heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
				
				// Tab 3
				heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
				
				break;
				
			case 2:
				rdbtnDefault.setVisible(false);
				rdbtnAttack.setVisible(false);
				rdbtnInjured.setVisible(false);
				
				// Tab 1
				defaultImgPanel.setVisible(true);
				heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/GM/MHand.png")).getImage();
				heroPic.setIcon(new ImageIcon(heroImg));
				
				//Tab 2
				heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
				
				// Tab 3
				heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
				
				break;
				
			case 3:
				rdbtnDefault.setVisible(false);
				rdbtnAttack.setVisible(false);
				rdbtnInjured.setVisible(false);
				
				// Tab 1
				defaultImgPanel.setVisible(true);
				heroImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/heroes/GM/Hands.png")).getImage();
				heroPic.setIcon(new ImageIcon(heroImg));
				
				//Tab 2
				heroAtkImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
				
				// Tab 3
				heroHurtImg = new ImageIcon(this.getClass().getResource("/resources/images/characters/Missingno.png")).getImage();
				
				break;
			}
			break;
		}
	}
	
	public void checkJoke(int jokes)
	{
		if(jokes == 1)
			chckbxJokesMode.setSelected(true);
		
		else
			chckbxJokesMode.setSelected(false);
	}
	
	public void checkHard(int hardcore)
	{
		if(hardcore == 1)
			chckbxHardcoreMode.setSelected(true);
		
		else
			chckbxHardcoreMode.setSelected(false);
	}
	
	public void chooseHero(String type)
	{
		heroType = type;
	}
	
	public Hero makeHero(int jokes)
	{
		Hero player = null;
		
		// Make Gender
		if(chckbxMale.isSelected())
		{
			heroGender = "Male";
		}
		
		else if(chckbxFemale.isSelected())
		{
			heroGender = "Female";
		}
		
		else //if(chckbxOther.isSelected())
		{
			heroGender = "Other";
		}
		
		// Make Hero
		switch(heroType)
		{
		case "h1": // Warrior
			player = new Warrior(heroName, heroGender);
			break;
			
		case "h2": // Sorceress
			player = new Sorceress(heroName, heroGender);
			
			// Aqua
			if(player.getName().equalsIgnoreCase("Aqua") && player.getGender().equalsIgnoreCase("Female") && jokes == 1)
			{
				player = new Aqua("");
			}
			break;
			
		case "h3": // Thief
			player = new Thief(heroName, heroGender);
			
			// Kazuma
			if(player.getName().equalsIgnoreCase("Kazuma") && player.getGender().equalsIgnoreCase("Male") && jokes == 1)
			{
				player = new Kazuma("");
			}
			break;
			
		case "h4": // Knight
			player = new Knight(heroName, heroGender);
			
			// Darkness
			if(player.getName().equalsIgnoreCase("Darkness") && player.getGender().equalsIgnoreCase("Female") && jokes == 1)
			{
				player = new Darkness("");
			}
			break;
			
		case "h5": // Battle Mage
			player = new BattleMage(heroName, heroGender);

			// Megumin
			if(player.getName().equalsIgnoreCase("Megumin") && player.getGender().equalsIgnoreCase("Female") && jokes == 1)
			{
				player = new Megumin("");
			}
			break;
			
		case "h6": // GM
			player = new GameMaster(heroName, heroGender);
			break;	
		}
		
		return player;
	}
}
