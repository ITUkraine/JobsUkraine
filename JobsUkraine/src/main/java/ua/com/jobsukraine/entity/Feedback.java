package ua.com.jobsukraine.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.jpa.domain.AbstractPersistable;

@Entity
public class Feedback extends AbstractPersistable<Integer>implements Comparable<Feedback> {

	private static final long serialVersionUID = 1L;

	@ManyToOne
	private Category category;

	private String comment;

	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	private String mark;

	private Date date = new Date();

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

	public Employer getEmployer() {
		return employer;
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

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Feedback [id=" + this.getId() + ", mark=" + mark + ", comment=" + comment + "]\n";
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int compareTo(Feedback feedback) {
		long t1 = feedback.getDate().getTime();
		long t2 = this.getDate().getTime();
		if (t2 > t1) {
			return -1;
		} else if (t1 > t2) {
			return 1;
		} else {
			return 0;
		}
	}

}
