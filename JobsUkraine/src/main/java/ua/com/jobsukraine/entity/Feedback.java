package ua.com.jobsukraine.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Integer mark;
	private String comment;

	public Feedback() {
	}

	public Feedback(Integer mark, String comment) {
		super();
		this.mark = mark;
		this.comment = comment;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + id + ", mark=" + mark + ", comment=" + comment + "]\n";
	}

}
