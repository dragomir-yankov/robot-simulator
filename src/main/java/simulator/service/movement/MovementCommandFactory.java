package simulator.service.movement;

import java.util.HashMap;
import java.util.Map;

import simulator.exception.InvalidCommandException;
import simulator.model.Movement;
import simulator.model.Robot;

public class MovementCommandFactory {
	
	private Map<Character, MovementCommand> commands;
	
	private static MovementCommandFactory instance;
	
	private MovementCommandFactory() {
		commands = new HashMap<>();
		commands.put(Movement.FORWARD.getCommandKey(), new ForwardMovementCommand());
		commands.put(Movement.LEFT.getCommandKey(), new LeftMovementCommand());
		commands.put(Movement.RIGHT.getCommandKey(), new RightMovementCommand());
	}
	
	public static MovementCommandFactory instance() {
		if (instance == null) {
			instance = new MovementCommandFactory();
		}
		return instance;
	}
	
	public MovementCommand getCommand(char commandKey, Robot robot) throws InvalidCommandException {
		if (!commands.containsKey(commandKey)) {
			throw new InvalidCommandException("Invalid command key!");
		}
		MovementCommand cmd = commands.get(commandKey);
		cmd.setRobot(robot);
		return cmd;
	}

}
