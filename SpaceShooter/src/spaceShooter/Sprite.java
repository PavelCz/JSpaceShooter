package spaceShooter;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Sprite extends Image {
	float xOffset;
	float yOffset;
	

	public Sprite(String imagePath, GameContainer container) throws SlickException {

		super(imagePath);
		this.xOffset = (container.getWidth() - super.getWidth())/ 2f;
		this.yOffset = (container.getHeight() - super.getHeight()) / 2f;

	}

	public void draw(float xCoordinate, float yCoordinate, float rotation, float scale) {
		super.setRotation(rotation);
		super.draw(xCoordinate + xOffset, yCoordinate + yOffset, scale);
	}

}
