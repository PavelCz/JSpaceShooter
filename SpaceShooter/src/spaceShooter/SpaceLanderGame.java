package spaceShooter;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SpaceLanderGame extends BasicGame {
	private PlayerShip playerShip;
	private Background background;
	
	private Sprite pauseScreen;

	private boolean paused;

	// private Ship [] aliveShips;

	public SpaceLanderGame() {
		super("SpaceShooter");
	}

	@Override
	public void init(GameContainer game) {
		playerShip = new PlayerShip(game, 0, 0, 0.0001f, 0.00015f, 1f);
		try {
			pauseScreen = new Sprite("/data/MenuScreen1.png", game);
		} catch (SlickException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.paused = false;
		try {
			background = new Background(game);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void update(GameContainer container, int delta) {
		Input input = container.getInput();
		if (input.isKeyPressed(Input.KEY_ESCAPE)) {
			this.paused = !this.paused;
		} 
		if(!this.paused) {
			updateGame(container, delta);
		} 
		
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {

		background.draw(0f, 0f, 0f, 1f);
		playerShip.draw();
		if(this.paused) {
			pauseScreen.draw(0f,0f, 0f, 1f);
		}

	}

	private void updateGame(GameContainer container, int delta) {
		Input input = container.getInput();

		playerShip.update(delta);
		if (input.isKeyDown(Input.KEY_A)) {
			playerShip.accelerate(1, -delta);
		}

		if (input.isKeyDown(Input.KEY_D)) {
			playerShip.accelerate(1, delta);
		}

		if (input.isKeyDown(Input.KEY_W)) {
			playerShip.accelerate(0, delta);
		}

		

		if (input.isKeyDown(Input.KEY_LCONTROL)) {
			// playerShip.stopRotation();
			// if (playerShip.engineIsStoppable()) {
			playerShip.stopEngine(0, delta);
			
			// }

		}
		if (input.isKeyDown(Input.KEY_LSHIFT)) {
			// playerShip.stopRotation();
			// if (playerShip.engineIsStoppable()) {
			
			playerShip.stopEngine(1, delta);
			// }

		}
		
		playerShip.accelerate(0, delta, 0.00006f, 180);
	}

}
