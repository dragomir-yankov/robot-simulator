package simulator.service.movement;

import simulator.model.Robot;

public interface MovementCommand {
	
	public void execute();
	
	public void setRobot(Robot robot);
	
}
