package simulator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.GONE)
public class RobotNotFoundException extends Exception {

	private static final long serialVersionUID = -9070731647774658178L;

	public RobotNotFoundException(String message) {
		super(message);
	}
	
}
