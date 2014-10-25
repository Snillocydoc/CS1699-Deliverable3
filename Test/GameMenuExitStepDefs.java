import cucumber.api.java.en.*;
public class GameMenuExitStepDefs 
{
	Tetris tetris = new Tetris();
	@Given("^a Tetris game is running")
	public void gameIsRunning()
	{
		tetris.start();
	}
	@Given("^a Tetris game is paused")
	public void gameIsPaused()
	{
		tetris.pause();
	}
	
	@When("^the user selects the Game menu")
	public void selectsGameMenu()
	{
		
	}
	
}
