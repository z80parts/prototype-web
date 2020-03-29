package web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

	@ExceptionHandler(value = CustomRuntimeException.class)
	public ResponseEntity<Object> exception(CustomRuntimeException exception) {

		return new ResponseEntity<>("RuntimeError occured!",
				HttpStatus.EXPECTATION_FAILED);
	}

}
