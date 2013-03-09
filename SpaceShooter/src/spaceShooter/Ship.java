package spaceShooter;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Ship extends Entity {

	public Sprite getImage() {
		return image;
	}

	public float getSpeed() {
		return this.velocity.getSpeed(0);
	}

	/*
	 * public int getyVelocity() { return yVelocity; }
	 */

	public float getxCoordinate() {
		return xCoordinate;
	}

	public float getyCoordinate() {
		return yCoordinate;
	}

	public Ship(GameContainer container, String imagePath, int x, int y, 
			float rotationAcceleration, float acceleration, float scale) {
		try {
			this.image = new Sprite(imagePath, container);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.accelerations = new float[2];
		this.accelerations[0] = acceleration;
		this.accelerations[1] = rotationAcceleration;

		this.rotation = 0;

		this.xCoordinate = x;
		this.yCoordinate = y;
		this.scale = scale;

		this.velocity = new Velocity();

	}

	public void updateRotationVelocity(int delta) {
		this.rotate(this.velocity.getSpeed(1) * delta);
	}

	private void rotate(float angle) {
		this.rotation += angle;
		this.rotation = normalizeAngle(this.rotation);
	}

	public void accelerate(int type, int delta) {// type == 0: Engines; type == 1: Rotation
		this.velocity.speedUp(type, delta * this.accelerations[type], this.rotation);
	}
	public void gravity() {// type == 0: Engines; type == 1: Rotation
		this.velocity.velocity.x-=0.00006f;
		//this.velocity.speedUp(type, delta * acceleration, rotation);
	}

	public void accelerate(int type, int delta, float rotation) {// type == 0: Engines; type == 1: Rotation
		this.velocity.speedUp(type, delta * this.accelerations[type], rotation);
	}

	public void stopEngine(int type, int delta) { // type == 0: Engines; type == 1: Rotation

		if (type == 0) {
			Velocity velocityBuffer = this.velocity.clone();
			this.accelerate(type, delta, Ship.normalizeAngle(this.velocity.getDirection() + 180f));

			// velocityNow = this.velocity.getSpeed(type);

			if (this.velocity.isOppositeDirection(velocityBuffer)) { // jetzige Geschw. entgegen der urspngl.
				this.velocity.stopEngine(type);
			} else { // jetzige Geschw. nicht entgegen der ursprngl
				// alles ok
			}
		} else {
			float velocityBuffer = this.velocity.getSpeed(1);

			float velocityNow;

			if (velocityBuffer > 0) { // ursprngl. Geschw. positiv
				this.accelerate(type, -delta);
				velocityNow = this.velocity.getSpeed(1);
				if (velocityNow >= 0) { // jetzige Geschw. positiv
					// alles ok
				} else { // jetzige Geschw. negativ
					this.velocity.stopEngine(1);
				}
			} else if (velocityBuffer < 0) { // ursprngl. Geschw. negativ
				this.accelerate(type, delta);
				velocityNow = this.velocity.getSpeed(1);
				if (velocityNow <= 0) { // jetzige Geschw. positiv
					// alles ok
				} else { // jetzige Geschw. negativ
					this.velocity.stopEngine(1);
				}
			} else { // velocityBuffer == 0
				this.velocity.stopEngine(1);
			}
		}
	}

	public void update(int delta) {
		this.updateRotationVelocity(delta);

		this.updatePosition(delta);

	}

	public void updatePosition(int delta) {
		float hip = velocity.getSpeed(0) * delta;

		float rotation = velocity.getDirection();

		xCoordinate += hip * Math.sin(Math.toRadians(rotation));
		yCoordinate -= hip * Math.cos(Math.toRadians(rotation));
	}

	public void draw() {
		image.draw(xCoordinate, yCoordinate, rotation, scale);
	}

	public void drawRelative(Ship referencePoint) { // draws the ship relative to a reference point
		image.draw(xCoordinate - referencePoint.getxCoordinate(),
				yCoordinate - referencePoint.getyCoordinate(), rotation, scale);
	}

	public void drawCentered() { // draws the ship with the Camera centered on it
		image.draw(0f, 0f, rotation, scale);
	}

	public static float normalizeAngle(float angle) {
		if (angle > 360) {
			return normalizeAngle(angle - 360);
		} else if (angle < 0) {
			return normalizeAngle(angle + 360);
		} else {
			return angle;
		}
	}
}
