package spaceShooter;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.geom.Vector2f;

/**
 * @author Pavel
 * 
 */
public class Velocity {
	// private EngineVelocity engineVelocity;
	private Vector2f velocity;
	private float rotationSpeed;

	public Velocity(float engineSpeed, float direction, float rotationSpeed) {
		init(engineSpeed, rotationSpeed, direction);
	}

	public Velocity() {
		init(0f, 0f, 0f);
	}
	
	private Velocity(Vector2f vector, float rotationSpeed) {
		this.velocity = vector;
		this.rotationSpeed = rotationSpeed;
	}

	public void init(float engineSpeed, float direction, float rotationSpeed) {
		this.velocity = createVector(engineSpeed, direction);
		this.rotationSpeed = rotationSpeed;

	}

	public float getSpeed(int type) {
		if (type == 0) {
			return this.velocity.length();
		} else {
			return this.rotationSpeed;
		}

	}

	public float getDirection() {
		return (float)this.velocity.getTheta();
	}
	
	
	/*public void setSpeed(int type, float speed, int index) {
		if (type == 0) {
			this.engineVelocityList.get(index).getSpeed() = speed;
		} else {
			this.rotationSpeed = speed;
		}
	}*/

	/*public void setDirection(float direction) {
		this.direction = direction;
	}*/

	public void speedUp(int type, float speed, float direction) {
		if (type == 0) {
			this.velocity.add(createVector(speed, direction));
		} else {
			this.rotationSpeed = this.rotationSpeed + speed;
		}
	}
	
	public void stopEngine(int type) {
		if (type == 0) {
			this.velocity = new Vector2f();
		} else {
			this.rotationSpeed = 0f;
		}
	}
	
	
	public boolean isOppositeDirection(Velocity velocity) {
		if(this.getDirection() == Ship.normalizeAngle(velocity.getDirection() * 180)) {
			return true;
		} else {
			return false;
		}
	}
	
	public Velocity clone() {
		return new Velocity(this.velocity, this.rotationSpeed);
	}
	
	

	/**
	 * returns a new Vector with the specified length and angle
	 * 
	 * @param length
	 *            the length of the new Vector
	 * @param angle
	 *            the angle of the new Vector
	 * @return a new Vector with angle and length
	 */
	private Vector2f createVector(float length, float angle) {
		angle = -angle + 90; // this is because Vector2f uses normal mathematical angles (anticlockwise, east = 0°)
		return new Vector2f((float) Math.sin(Math.toRadians(angle)) * length, (float) Math.cos(Math.toRadians(angle)) * length);

	}
}
