import java.awt.AWTEvent;
import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.*;

import cucumber.api.java.en.*;
import cucumber.api.java.it.Date;
import cucumber.api.junit.Cucumber;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class StepDefs
{

	Tetris tetris;
	TetrisMenuBar menu;
	TetrisKeyAdapter keyAdapter;
	TetrisWindowAdapter windowAdapter;
	JFrame frame;
	String gameName;
	int currentSavedIndex;
	
	@Given("a Tetris game is running with initial default statistics$")
	public void gameIsRunning()
	{
		setup();
		tetris.start();
	}
	@Given("a Tetris game is running with changed statistics")
	public void gameWithChangedStats()
	{
		setup();
		tetris.start();
		//change the level
		tetris.setLevel(3);
		//change the points
		tetris.down();
		tetris.down();
		
	}
	@Given("^a Tetris game is paused")
	public void gameIsPaused()
	{
		setup();
		tetris.start();
		tetris.pause();
	}
	
	@When("^the user selects the Game menu")
	public void selectsGameMenu()
	{
		menu.getMenu(0).doClick();
		
	}
	@When("the user selects the \"+(.*)\" button$")
	public void selectButton(String name)
	{
		System.out.println(name);
		int count = menu.getMenu(0).getMenuComponentCount();
	
		for(int x=0;x<count;x++)
		{
			System.out.println(menu.getMenu(0).getMenuComponent(x));
			if(menu.getMenu(0).getMenuComponent(x).getAccessibleContext().getAccessibleName()!=null&&menu.getMenu(0).getMenuComponent(x).getAccessibleContext().getAccessibleName().equals(name))
			{
				menu.getMenu(0).getItem(x).doClick();
				
				
			}
		}
	}
	@When("^the user selects the Level Jump button and enters (.*)")
	public void enterLevelNumber(String lvl)
	{
	
		int level = Integer.parseInt(lvl);
		menu.setLevel(level);
		int count = menu.getMenu(0).getMenuComponentCount();
		
		for(int x=0;x<count;x++)
		{
			System.out.println(menu.getMenu(0).getMenuComponent(x));
			if(menu.getMenu(0).getMenuComponent(x).getAccessibleContext().getAccessibleName()!=null&&menu.getMenu(0).getMenuComponent(x).getAccessibleContext().getAccessibleName().equals("Level Jump"))
			{
				menu.getMenu(0).getItem(x).doClick();
				
				
			}
		}
		
	}
	@When("the user selects the Save Game button and enters \"(.*)\"")
	public void userEnters(String nam)
	{
		menu.setNam(nam);
		gameName=nam;
		int count = menu.getMenu(0).getMenuComponentCount();
		System.out.println(nam);
		for(int x=0;x<count;x++)
		{
			
			if(menu.getMenu(0).getMenuComponent(x).getAccessibleContext().getAccessibleName()!=null&&menu.getMenu(0).getMenuComponent(x).getAccessibleContext().getAccessibleName().equals("Save Game"))
			{
				menu.getMenu(0).getItem(x).doClick();
				
			}
		}
	}
	
	@Then("the level should be (.*)")
	public void levelShouldBe(String lvl)
	{
		int level = Integer.parseInt(lvl);
		assertEquals(level,tetris.getLevel());
	}
	@Then("the Enter Level window should reappear")
	public void enterLevel()
	{
		assertEquals(tetris.getLevel(),5);
	}
	@Then("^a new game with the initial default statistics should begin")
	public void beginNewGame()
	{
		assertTrue(tetris.isInGame());
		assertTrue(tetris.getLevel()==1);
	}
	@Then("the running Tetris game should pause")
	public void gamePauses()
	{
		assertTrue(tetris.isPaused());
	}
	@Then("the paused Tetris game should continue")
	public void gameContinues()
	{
		assertFalse(tetris.isPaused());
	}
	@Then("the application should return to the main menu page")
	public void returnMainMenu()
	{
		assertTrue(tetris.isMenu());
	}
	@Then("the data file should be updated with the \"(.*)\" statistics$")
	public void correctStatistics(String state)
	{
		
		if(state.equals("initial"))
		{
			currentSavedIndex=menu.getCurrentSavedIndex();
			SavedGame[] games = tetris.getSavedGames();
			for(int x=0;x<games.length;x++)
				System.out.println(games[x].getName());
			System.out.println(currentSavedIndex);
			assertTrue(games[currentSavedIndex].getPoints()==0
					&&games[currentSavedIndex].getLevel()==1
					&&gameName.startsWith(games[currentSavedIndex].getName()));
			
			
			
		}
		else if(state.equals("changed"))
		{
			currentSavedIndex=menu.getCurrentSavedIndex();
			SavedGame[] games = tetris.getSavedGames();
			for(int x=0;x<games.length;x++)
				System.out.println(games[x].getName());
			System.out.println(currentSavedIndex);
			assertTrue(games[currentSavedIndex].getPoints()>0
					&&games[currentSavedIndex].getLevel()>1
					&&gameName.startsWith(games[currentSavedIndex].getName()));
		
				
		
		}
	}
	@Then("the name should be \"(.*)\"$")
	public void nameShouldBe(String name)
	{
		currentSavedIndex=menu.getCurrentSavedIndex();
		SavedGame[] games = tetris.getSavedGames();
		assertEquals(name,games[currentSavedIndex].getName());
	}
	
	
	
	public void setup()
	{
		// Reset
		tetris = new Tetris();
		menu = new TetrisMenuBar(tetris);
		keyAdapter = new TetrisKeyAdapter(tetris);
		windowAdapter = new TetrisWindowAdapter(tetris);
		frame = new JFrame("Tetris");
		gameName=new String();
		currentSavedIndex=1;
		
		frame.add(tetris);
		//Set the properties of the frame
		frame.addWindowListener(windowAdapter);
		frame.setJMenuBar(menu);
		frame.addKeyListener(keyAdapter);
		frame.setSize(485,728);
		frame.setResizable(false);
		//Centers the frame on the screen
		frame.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-tetris.getWidth()/2,2);
		//Shows the frame
		frame.setVisible(true);
		menu.setTest(true);
		
		// Wait 100ms to make sure the frame/menu has the time it needs to initialize
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
