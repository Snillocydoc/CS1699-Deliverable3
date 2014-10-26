



import java.awt.Toolkit;
import javax.swing.*;

import cucumber.api.java.en.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;


public class StepDefs
{

	Tetris tetris = new Tetris();
	TetrisMenuBar menu = new TetrisMenuBar(tetris);
	TetrisKeyAdapter keyAdapter = new TetrisKeyAdapter(tetris);
	TetrisWindowAdapter windowAdapter = new TetrisWindowAdapter(tetris);
	JFrame frame = new JFrame("Tetris");
	
	
	@Given("^a Tetris game is running")
	public void gameIsRunning()
	{
		setup();
		tetris.start();
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
	@When("the user selects the \"+(.*)\" button")
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
	@When("the user enters d+$")
	public void enterLevelNumber(String d)
	{
		System.out.println(d);
		int level = Integer.parseInt(d);
		menu.setLevel(level);
		
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
	
	
	public void setup()
	{
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
	}
	
}
