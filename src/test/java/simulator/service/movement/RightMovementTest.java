package simulator.service.movement;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import simulator.exception.InvalidCommandException;
import simulator.model.Direction;
import simulator.model.Movement;
import simulator.model.Robot;

public class RightMovementTest extends MovementTest {
	
	@Test
	public void testIfRightOfNorthIsEast() throws InvalidCommandException {
		Robot robot = getRobotFacingDirectionAndTurn(Direction.NORTH);
		assertEquals(Direction.EAST, robot.getDirection());
	}
	
	@Test
	public void testIfRightOfEastIsSouth() throws InvalidCommandException {
		Robot robot = getRobotFacingDirectionAndTurn(Direction.EAST);
		assertEquals(Direction.SOUTH, robot.getDirection());
	}
	
	@Test
	public void testIfRightOfSouthIsWest() throws InvalidCommandException {
		Robot robot = getRobotFacingDirectionAndTurn(Direction.SOUTH);
		assertEquals(Direction.WEST, robot.getDirection());
	}
	
	@Test
	public void testIfRightOfWestIsNorth() throws InvalidCommandException {
		Robot robot = getRobotFacingDirectionAndTurn(Direction.WEST);
		assertEquals(Direction.NORTH, robot.getDirection());
	}
	
	@Override
	protected char getCommandKey() {
		return Movement.RIGHT.getCommandKey();
	}

}
