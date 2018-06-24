package simulator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RobotExistsException extends Exception {

	private static final long serialVersionUID = 4361582617258590796L;

	public RobotExistsException(String message) {
		super(message);
	}

}
