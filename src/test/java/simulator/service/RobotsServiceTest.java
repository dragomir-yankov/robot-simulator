package simulator.service;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import simulator.configuration.RobotsConfiguration;
import simulator.exception.InvalidCommandException;
import simulator.exception.RobotNotFoundException;
import simulator.model.Direction;
import simulator.model.Robot;
import simulator.repository.RobotsRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { RobotsConfiguration.class })
public class RobotsServiceTest {

	@Autowired
	private RobotsService service;

	@MockBean
	private RobotsRepository repository;

	@Before
	public void setUp() {
		Robot robot = new Robot(7, 3, Direction.NORTH);
		robot.setId(0);
		
		Mockito.when(repository.findById(robot.getId())).thenReturn(Optional.of(robot));
		Mockito.when(repository.save(robot)).thenReturn(robot);
		Mockito.when(repository.existsById(0)).thenReturn(true);
		Mockito.when(repository.existsById(1)).thenReturn(false);
	}

	@Test
	public void testMovement() throws RobotNotFoundException, InvalidCommandException {
		Robot moved = service.moveRobot(0, "RAALAL");
		assertEquals(Integer.valueOf(0), moved.getId());
		assertEquals(Integer.valueOf(9), moved.getX());
		assertEquals(Integer.valueOf(4), moved.getY());
		assertEquals(Direction.WEST, moved.getDirection());
	}
	
	@Test(expected=RobotNotFoundException.class)
	public void testMovementWithInvalidRobotId() throws RobotNotFoundException, InvalidCommandException {
		service.moveRobot(1, "RAALAL");
	}
	
	@Test(expected=InvalidCommandException.class)
	public void testMovementWithInvalidCommand() throws RobotNotFoundException, InvalidCommandException {
		service.moveRobot(0, "Z");
	}
	
}
