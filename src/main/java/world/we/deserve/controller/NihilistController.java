/**
 * 
 */
package world.we.deserve.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import world.we.deserve.dto.Concept;
import world.we.deserve.dto.Nihilist;
import world.we.deserve.exception.NihilistNotFoundException;

/**
 * @author Miguel Ángel Dev (miguelangelprogramacion@gmail.com)
 *
 */
@RestController
@RequestMapping("/nihilist")
public class NihilistController {

	@RequestMapping(method = RequestMethod.GET)
	public Nihilist nihilistByIdT() {
		Nihilist nihilist = new Nihilist();
		return nihilist;
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Nihilist> saveNihilist(@RequestBody Nihilist nihilist, UriComponentsBuilder ucb) {
		Nihilist savedNihilist = Repository_saveNihilist(nihilist);

		URI locationUri = ucb.path("/nihilist/").path(String.valueOf(savedNihilist.getNihilistId())).build().toUri();

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(locationUri);

		ResponseEntity<Nihilist> responseEntity = new ResponseEntity<Nihilist>(savedNihilist, headers, HttpStatus.CREATED);

		return responseEntity;
	}

	/**
	 * @param nihilist
	 * @return
	 */
	private Nihilist Repository_saveNihilist(Nihilist nihilist) {
		// Repo invocation simulation
		Random r = new Random();
		int max = 10;
		int min = 0;
		nihilist.setNihilistId(r.nextInt((max - min) + 1) + min);
		return nihilist;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Nihilist nihilistById(@PathVariable int id) {
		Nihilist nihilist = findNihilistById(id);
		if (nihilist == null) {
			throw new NihilistNotFoundException(id);
		}
		return nihilist;
	}

	@ExceptionHandler(NihilistNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Error NihilistNotFound(NihilistNotFoundException e) {
		int nihilistId = e.getNihilistId();
		return new Error("Nihilist [" + nihilistId + "] not found");
	}

	/**
	 * @param id
	 * @return
	 */
	private Nihilist findNihilistById(int id) {
		// Somenthing stupid, to generate exceptions
		if (id % 2 == 0)
			return null;
		else
			return new Nihilist(id, 50, "Nihilist " + id, new ArrayList<Concept>(Arrays.asList(new Concept())));

	}

}
