package simulator.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import simulator.exception.InvalidCommandException;
import simulator.exception.RobotExistsException;
import simulator.exception.RobotNotFoundException;
import simulator.model.Robot;
import simulator.service.RobotsService;

@Controller
@RequestMapping("/rest/robots")
public class RobotsController {
	
	@Autowired
	private RobotsService robotsService;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Collection<Robot> listRobots() {
		return robotsService.listRobots();
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	@ResponseBody
	public Robot newRobot() {
		return robotsService.newRobot();
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.POST)
	@ResponseBody
	public Robot newRobot(@RequestBody Robot robot) throws RobotExistsException {
		return robotsService.newRobot(robot);
	}
	
	@RequestMapping(value = "/move/{robotId}", method = RequestMethod.POST)
	@ResponseBody
	public Robot moveRobot(@PathVariable Integer robotId, @RequestBody String commandString)
			throws RobotNotFoundException, InvalidCommandException {
		return robotsService.moveRobot(robotId, commandString);
	}

}
