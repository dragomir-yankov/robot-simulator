package simulator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class InvalidCommandException extends Exception {

	private static final long serialVersionUID = 4157600783406681618L;

	public InvalidCommandException(String message) {
		super(message);
	}
	
}
