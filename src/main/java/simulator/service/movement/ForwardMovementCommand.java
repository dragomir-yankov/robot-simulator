package simulator.service.movement;

public class ForwardMovementCommand extends AbstractMovementCommand {

	@Override
	public void execute() {
		robot.setX(robot.getDirection().getxForwardModifier().applyAsInt(robot.getX()));
		robot.setY(robot.getDirection().getyForwardModifier().applyAsInt(robot.getY()));
	}

}
