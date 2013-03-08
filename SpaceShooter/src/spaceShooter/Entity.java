package spaceShooter;

public abstract class Entity {
	protected float rotation;
	protected Sprite image = null;

	protected Velocity velocity;

	protected float[] accelerations;
	protected float xCoordinate;
	protected float yCoordinate;

	protected float scale;

	public float getRotation() {
		return rotation;
	}
}
