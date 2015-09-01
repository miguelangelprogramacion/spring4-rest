package world.we.deserve.dto;

import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the nihilist database table.
 * 
 */
public class Nihilist implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer nihilistId;

	private Integer rage;

	private String username;

	private List<Concept> concepts;

	public Nihilist() {
	}

	/**
	 * @param nihilistId
	 * @param rage
	 * @param username
	 * @param concepts
	 */
	public Nihilist(Integer nihilistId, Integer rage, String username, List<Concept> concepts) {
		super();
		this.nihilistId = nihilistId;
		this.rage = rage;
		this.username = username;
		this.concepts = concepts;
	}

	public Integer getNihilistId() {
		return this.nihilistId;
	}

	public void setNihilistId(Integer nihilistId) {
		this.nihilistId = nihilistId;
	}

	public Integer getRage() {
		return this.rage;
	}

	public void setRage(Integer rage) {
		this.rage = rage;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Concept> getConcepts() {
		return this.concepts;
	}

	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}
}