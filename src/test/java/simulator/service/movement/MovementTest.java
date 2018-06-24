package simulator.service.movement;

import simulator.exception.InvalidCommandException;
import simulator.model.Direction;
import simulator.model.Robot;

public abstract class MovementTest {
	
	protected Robot getRobotFacingDirectionAndTurn(Direction direction) throws InvalidCommandException {
		Robot robot = new Robot(0, 0, direction);
		MovementCommandFactory.instance().getCommand(getCommandKey(), robot).execute();
		return robot;
	}
	
	protected abstract char getCommandKey();

}
