package spaceShooter;

/**
 * @author Pavel
 * 
 */
public class EngineVelocity {
	private float engineSpeed;
	//private float rotationSpeed;
	private float direction;

	public EngineVelocity(float engineSpeed, float direction) {
		init(engineSpeed,  direction);
	}

	public EngineVelocity() {
		init(0f,  0f);
	}

	public void init(float engineSpeed, float direction) {
		this.engineSpeed = engineSpeed;
		//this.rotationSpeed = rotationSpeed;
		this.direction = direction;
	}

	public float getSpeed() {
		
			return engineSpeed;
		

	}

	public float getDirection() {
		return direction;
	}

	public void setSpeed(float speed) {
		
			this.engineSpeed = speed;
		
	}

	public void setDirection(float direction) {
		this.direction = direction;
	}
	
	public void speedUp( float speed) {
		
			this.engineSpeed = this.engineSpeed + speed;
		
	}
	
	public void stopEngine(int type) {
		
	}
	

}
