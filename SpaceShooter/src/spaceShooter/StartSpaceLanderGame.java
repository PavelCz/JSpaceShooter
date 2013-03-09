package spaceShooter;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class StartSpaceLanderGame {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpaceLanderGame game = new SpaceLanderGame();
		AppGameContainer appGameContainer;
		try {
			appGameContainer = new AppGameContainer(game, 800, 600, false);
			appGameContainer.start();

		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
