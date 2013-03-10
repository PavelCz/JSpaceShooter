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

	public boolean collidesWithLine(int y) {
		float currentHeight = (float)Math.cos((float) this.rotation) / this.height;
		return this.yCoordinate + currentHeight / 2 >= y;
	}
}
