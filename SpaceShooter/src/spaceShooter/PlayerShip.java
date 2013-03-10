package spaceShooter;

import org.newdawn.slick.GameContainer;

public class PlayerShip extends Ship {

	public PlayerShip(GameContainer container, int x, int y, float rotationAcceleration,
			float acceleration, float scale) {
		super(container, "/data/PlayerShip1.png", x, y, rotationAcceleration, acceleration, scale);
		// this.rotationSpeed = 0;
	}
	
	public PlayerShip(GameContainer container, int x, int y) {
		this(container,  x, y, 0.0002f, 0.0001f, 1.0f);
	}

}
