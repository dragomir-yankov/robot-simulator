package simulator.model;

import java.util.function.IntUnaryOperator;

public enum Direction {
	
	NORTH(IntUnaryOperator.identity(), i -> i + 1), 
	EAST(i -> i + 1, IntUnaryOperator.identity()), 
	SOUTH(IntUnaryOperator.identity(), i -> i - 1), 
	WEST(i -> i - 1, IntUnaryOperator.identity());
	
	private final IntUnaryOperator xForwardModifier;
	
	private final IntUnaryOperator yForwardModifier;
	
	private Direction(IntUnaryOperator xForwardModifier, IntUnaryOperator yForwardModifier) {
		this.xForwardModifier = xForwardModifier;
		this.yForwardModifier = yForwardModifier;
	}

	public Direction getLeft() {
		if (ordinal() == 0) {
			return values()[values().length - 1];
		}
		return values()[ordinal() - 1];
	}
	
	public Direction getRight() {
		if (ordinal() == values().length - 1) {
			return values()[0];
		}
		return values()[ordinal() + 1];
	}

	public IntUnaryOperator getxForwardModifier() {
		return xForwardModifier;
	}

	public IntUnaryOperator getyForwardModifier() {
		return yForwardModifier;
	}

}
