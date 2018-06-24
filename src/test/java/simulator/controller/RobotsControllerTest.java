package simulator.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import simulator.model.Direction;
import simulator.model.Robot;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class RobotsControllerTest {
	
	@Autowired
	private ObjectMapper objectMapper;
	
	private static final String NEW_ROBOT_ENDPOINT = "/rest/robots/new";

	private static final String LIST_ALL_ENDPOINT = "/rest/robots";

	private static final String MOVEMENT_ENDPOINT = "/rest/robots/move/";
	
	private static final int EXISTING_ID = 2;
	
	private static final int INVALID_ID = -1;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testRobotMovement() throws Exception {
		this.mockMvc
				.perform(
						post(MOVEMENT_ENDPOINT + EXISTING_ID)
							.content("RAALAL")
							.contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.x").value("9"))
				.andExpect(jsonPath("$.y").value("4"))
				.andExpect(jsonPath("$.direction").value(Direction.WEST.toString()))
				.andReturn();
	}
	
	@Test
	public void testRobotMovementWithInvalidCommand() throws Exception {
		this.mockMvc
				.perform(
						post(MOVEMENT_ENDPOINT + EXISTING_ID)
							.content("Z")
							.contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isUnprocessableEntity())
				.andReturn();
	}
	
	@Test
	public void testRobotMovementWithInvalidId() throws Exception {
		this.mockMvc
				.perform(
						post(MOVEMENT_ENDPOINT + INVALID_ID)
							.content("A")
							.contentType(MediaType.APPLICATION_JSON)
							.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isGone())
				.andReturn();
	}
	
	@Test
	public void testListAllRobots() throws Exception {
		List<Integer> expectedIds = Stream.of(1, 2).collect(Collectors.toList());
		this.mockMvc
			.perform(
					get(LIST_ALL_ENDPOINT))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.*.id").value(expectedIds))
			.andReturn();
	}
	
	@Test
	public void testAddNewRobot() throws Exception {
		this.mockMvc
			.perform(
					get(NEW_ROBOT_ENDPOINT))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.x").value("0"))
			.andExpect(jsonPath("$.y").value("0"))
			.andExpect(jsonPath("$.direction").value(Direction.NORTH.toString()))
			.andReturn();
	}
	
	@Test
	public void testAddNewRobotWithCoordinates() throws Exception {
		Robot robot = new Robot(1, 1, Direction.WEST);
		this.mockMvc
			.perform(
					post(NEW_ROBOT_ENDPOINT)
						.content(objectMapper.writeValueAsString(robot))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.x").value("1"))
			.andExpect(jsonPath("$.y").value("1"))
			.andExpect(jsonPath("$.direction").value(Direction.WEST.toString()))
			.andReturn();
	}
	
	@Test
	public void testAddNewRobotWithCoordinatesAndExistingId() throws Exception {
		Robot robot = new Robot(1, 1, Direction.WEST);
		robot.setId(1);
		this.mockMvc
			.perform(
					post(NEW_ROBOT_ENDPOINT)
						.content(objectMapper.writeValueAsString(robot))
						.contentType(MediaType.APPLICATION_JSON)
						.accept(MediaType.APPLICATION_JSON))
			.andExpect(status().isConflict())
			.andReturn();
	}

}
