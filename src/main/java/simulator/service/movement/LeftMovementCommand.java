package simulator.service.movement;

public class LeftMovementCommand extends AbstractMovementCommand {

	@Override
	public void execute() {
		robot.setDirection(robot.getDirection().getLeft());
	}

}
