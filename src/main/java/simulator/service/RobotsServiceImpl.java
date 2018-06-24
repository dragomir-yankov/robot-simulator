package simulator.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import simulator.exception.InvalidCommandException;
import simulator.exception.RobotExistsException;
import simulator.exception.RobotNotFoundException;
import simulator.model.Direction;
import simulator.model.Robot;
import simulator.repository.RobotsRepository;
import simulator.service.movement.MovementCommand;
import simulator.service.movement.MovementCommandFactory;

public class RobotsServiceImpl implements RobotsService {
	
	@Autowired
	private RobotsRepository repository;
	
	@Override
	public Collection<Robot> listRobots() {
		return repository.findAll();
	}
	
	@Override
	public Robot moveRobot(Integer robotId, String commandString) throws RobotNotFoundException, InvalidCommandException {
		Optional<Robot> queryResult = repository.findById(robotId);
		if (queryResult.isPresent()) {
			Robot robot = queryResult.get();
			moveRobot(robot, commandString);
			return repository.save(robot);
		} else {
			throw new RobotNotFoundException("A robot with id " + robotId + " does not exist.");
		}
	}

	public void moveRobot(Robot robot, String commandString) throws InvalidCommandException {
		MovementCommandFactory factory = MovementCommandFactory.instance();
		for (char commandKey: commandString.toCharArray()) {
			MovementCommand command = factory.getCommand(commandKey, robot);
			command.execute();
		}
	}
	
	@Override
	public Robot newRobot() {
		Robot robot = new Robot();
		robot.setX(0);
		robot.setY(0);
		robot.setDirection(Direction.NORTH);
		return repository.save(robot);
	}
	
	@Override
	public Robot newRobot(Robot robot) throws RobotExistsException {
		if (robot.getId() != null && repository.existsById(robot.getId())) {
			throw new RobotExistsException("A robot with id " + robot.getId() + " already exists.");
		}
		return repository.save(robot);
	}

}
