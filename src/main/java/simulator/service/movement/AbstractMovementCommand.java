package simulator.service.movement;

import simulator.model.Robot;

public abstract class AbstractMovementCommand implements MovementCommand {
	
	protected Robot robot;

	public void setRobot(Robot robot) {
		this.robot = robot;
	}

}
