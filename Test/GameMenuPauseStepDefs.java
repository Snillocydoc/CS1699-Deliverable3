


import cucumber.api.java.en.*;

public class GameMenuPauseStepDefs
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
		
	}
	@Given("^a Tetris game is not running or paused")
	public void gameIsNotRunningOrPaused()
	{
		
	}
	
	@When("^the user selects the Game menu")
	public void selectsGameMenu()
	{
		
	}
	
	@Then("^the running Tetris game should pause")
	public void gamePauses()
	{
		
	}
	@Then("^the paused Tetris game should continue")
	public void gameContinues()
	{
		
	}
	@Then("^nothing should occur")
	public void nothingOccurs()
	{
		
	}
	
}
