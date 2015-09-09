/**
 * 
 */
package world.we.deserve.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@RestController
@RequestMapping(value = "/secure")
public class SecureController {	
	@RequestMapping(method = RequestMethod.GET)
	public String nihilistByIdT() {
		String msg = "Your are in a private zone";
		return msg;
	}

}
