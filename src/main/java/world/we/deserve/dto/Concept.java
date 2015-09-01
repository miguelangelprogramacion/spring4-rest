package world.we.deserve.dto;

import java.io.Serializable;


/**
 * The persistent class for the concept database table.
 * 
 */

public class Concept implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer concept_Id;

	private String abstract_;

	private byte[] good;

	private String resume;
	
	public Concept() {
	}

	public Integer getConcept_Id() {
		return this.concept_Id;
	}

	public void setConcept_Id(Integer concept_Id) {
		this.concept_Id = concept_Id;
	}

	public String getAbstract_() {
		return this.abstract_;
	}

	public void setAbstract_(String abstract_) {
		this.abstract_ = abstract_;
	}

	public byte[] getGood() {
		return this.good;
	}

	public void setGood(byte[] good) {
		this.good = good;
	}

	public String getResume() {
		return this.resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}
}