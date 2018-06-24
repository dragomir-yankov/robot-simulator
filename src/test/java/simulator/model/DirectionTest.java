package simulator.model;

import static org.junit.Assert.*;
import org.junit.Test;

import simulator.model.Direction;

public class DirectionTest {
	
	@Test
	public void testIfLeftOfNorthIsWest() {
		assertEquals(Direction.WEST, Direction.NORTH.getLeft());
	}
	
	@Test
	public void testIfRightOfNorthIsEast() {
		assertEquals(Direction.EAST, Direction.NORTH.getRight());
	}
	
	@Test
	public void testIfLeftOfEastIsNorth() {
		assertEquals(Direction.NORTH, Direction.EAST.getLeft());
	}
	
	@Test
	public void testIfRightOfEastIsSouth() {
		assertEquals(Direction.SOUTH, Direction.EAST.getRight());
	}
	
	@Test
	public void testIfLeftOfSouthIsEast() {
		assertEquals(Direction.EAST, Direction.SOUTH.getLeft());
	}
	
	@Test
	public void testIfRightOfSouthIsWest() {
		assertEquals(Direction.WEST, Direction.SOUTH.getRight());
	}
	
	@Test
	public void testIfLeftOfWestIsSouth() {
		assertEquals(Direction.SOUTH, Direction.WEST.getLeft());
	}
	
	@Test
	public void testIfRightOfWestIsNorth() {
		assertEquals(Direction.NORTH, Direction.WEST.getRight());
	}

}
