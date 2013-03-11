package spaceShooter;

import org.newdawn.slick.GameContainer;

public class Camera extends Entity {
	public Camera(GameContainer container) {
		this.accelerations = null;
		this.height = container.getHeight();
		this.width = container.getWidth();
		this.image = null;
		this.rotation = 0f;
		this.scale = 0f; // the scale is the zoom factor
		this.velocity = new Velocity();
		this.xCoordinate = 0f;
		this.yCoordinate = 0f;
	}

}
