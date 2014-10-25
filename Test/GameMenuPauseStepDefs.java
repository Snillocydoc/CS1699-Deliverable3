



import java.awt.Toolkit;
import javax.swing.*;

import cucumber.api.java.en.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class GameMenuPauseStepDefs
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
	
	@Then("^the running Tetris game should pause")
	public void gamePauses()
	{
		assertTrue(tetris.isPaused());
	}
	@Then("^the paused Tetris game should continue")
	public void gameContinues()
	{
		assertFalse(tetris.isPaused());
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
	}
	
}
