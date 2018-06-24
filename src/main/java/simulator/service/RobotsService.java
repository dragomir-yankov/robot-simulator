package simulator.service;

import java.util.Collection;

import simulator.exception.InvalidCommandException;
import simulator.exception.RobotExistsException;
import simulator.exception.RobotNotFoundException;
import simulator.model.Robot;

public interface RobotsService {

	Collection<Robot> listRobots();

	Robot moveRobot(Integer robotId, String commandString) throws RobotNotFoundException, InvalidCommandException;

	Robot newRobot();

	Robot newRobot(Robot robot) throws RobotExistsException;
	
}
