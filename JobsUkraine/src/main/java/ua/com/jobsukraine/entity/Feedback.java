package ua.com.jobsukraine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Feedback {

	@ManyToOne
	private Category category;

	private String comment;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer mark;

	public Feedback() {
	}

	public Feedback(Integer mark, String comment) {
		super();
		this.mark = mark;
		this.comment = comment;
	}

	public String getComment() {
		return comment;
	}

	public Integer getId() {
		return id;
	}

	public Integer getMark() {
		return mark;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}
	
	@Override
	public String toString() {
		return "Feedback [id=" + id + ", mark=" + mark + ", comment=" + comment + "]\n";
	}

}
