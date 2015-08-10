package ua.com.jobsukraine.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Feedback extends AbstractPersistable<Integer> {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Category category;

	private String comment;

	private String mark;
 
	public Feedback() {
	}

	public Feedback(String mark, String comment) {
		this.mark = mark;
		this.comment = comment;
	}

	public Category getCategory() {
		return category;
	}

	public String getComment() {
		return comment;
	}

	public String getMark() {
		return mark;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + this.getId() + ", mark=" + mark + ", comment=" + comment + "]\n";
	}

}
