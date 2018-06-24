package simulator.service.movement;

public class RightMovementCommand extends AbstractMovementCommand {

	@Override
	public void execute() {
		robot.setDirection(robot.getDirection().getRight());
	}

}
