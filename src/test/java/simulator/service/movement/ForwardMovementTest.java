package simulator.service.movement;

import static org.junit.Assert.*;

import org.junit.Test;

import simulator.exception.InvalidCommandException;
import simulator.model.Direction;
import simulator.model.Movement;
import simulator.model.Robot;

public class ForwardMovementTest extends MovementTest {

	@Test
	public void testForNorthwardFacing() throws InvalidCommandException {
		Robot robot = moveRobot(0, 0, Direction.NORTH);
		assertEquals(Integer.valueOf(0), robot.getX());
		assertEquals(Integer.valueOf(1), robot.getY());
	}
	
	@Test
	public void testForSouthwardFacing() throws InvalidCommandException {
		Robot robot = moveRobot(0, 1, Direction.SOUTH);
		assertEquals(Integer.valueOf(0), robot.getX());
		assertEquals(Integer.valueOf(0), robot.getY());
	}
	
	@Test
	public void testForWestwardFacing() throws InvalidCommandException {
		Robot robot = moveRobot(1, 0, Direction.WEST);
		assertEquals(Integer.valueOf(0), robot.getX());
		assertEquals(Integer.valueOf(0), robot.getY());
	}
	
	@Test
	public void testForEastwardFacing() throws InvalidCommandException {
		Robot robot = moveRobot(0, 0, Direction.EAST);
		assertEquals(Integer.valueOf(1), robot.getX());
		assertEquals(Integer.valueOf(0), robot.getY());
	}
	
	private Robot moveRobot(int sourceX, int sourceY, Direction sourceDirection) throws InvalidCommandException {
		Robot robot = new Robot(sourceX, sourceY, sourceDirection);
		MovementCommandFactory.instance().getCommand(getCommandKey(), robot).execute();
		return robot;
	}
	
	@Override
	protected char getCommandKey() {
		return Movement.FORWARD.getCommandKey();
	}

}
