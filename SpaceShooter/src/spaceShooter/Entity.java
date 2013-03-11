package spaceShooter;

public abstract class Entity {
	protected float rotation;
	protected Sprite image = null;

	protected Velocity velocity;

	protected float[] accelerations;
	protected float xCoordinate;
	protected float yCoordinate;
	protected float height = 0;
	protected float width = 0;

	protected float scale;

	public float getRotation() {
		return rotation;
	}

	public boolean collidesWithLine(float y) {
		float currentHeight = this.height / (float)Math.cos(this.rotation);
		return this.yCoordinate + currentHeight / 2 >= y;
	}
	
	public float getXCoordinate() {
		return this.xCoordinate;
	}
	
	public float getYCoordinate() {
		return this.yCoordinate;
	}
}
