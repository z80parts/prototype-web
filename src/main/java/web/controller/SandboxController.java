package web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import web.exception.CustomRuntimeException;

@RestController
@RequestMapping(value = "/sandbox")
public class SandboxController {

	@RequestMapping(value = "/switch", method = RequestMethod.GET)
	public String switchById(
			@RequestParam(name = "id", required = false) String id) {

		if ("0".equals(id))
			throw new CustomRuntimeException();
		return id;
	}

}
