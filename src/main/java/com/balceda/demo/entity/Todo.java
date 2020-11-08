package com.balceda.demo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "todos")
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String task;
	private LocalDateTime dueDate;
	private LocalDateTime creationDate;
	private LocalDateTime completedDate;

	public Todo() {
	}

	public Todo(Long id, String task, LocalDateTime dueDate, LocalDateTime creationDate) {
		this.id = id;
		this.task = task;
		this.dueDate = dueDate;
		this.creationDate = creationDate;
	}

	public Todo(Long id, String task, LocalDateTime dueDate, LocalDateTime creationDate, LocalDateTime completedDate) {
		this.id = id;
		this.task = task;
		this.dueDate = dueDate;
		this.creationDate = creationDate;
		this.completedDate = completedDate;
	}

	@Id
	@GeneratedValue(generator = "todoGenerator")
	@GenericGenerator( name = "todoGenerator", strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
		parameters={@Parameter(name="sequence_name", value="hibernate_sequence"),
					@Parameter(name="force_table_use", value="true"),
					@Parameter(name="value_column", value="todos"),
					@Parameter(name="increment_size", value="1") })
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "task", nullable = false)
	public String getTask() {
		return this.task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	@JsonProperty("due_date")
	@Column(name = "due_date", nullable = false, length = 23)
	public LocalDateTime getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(LocalDateTime dueDate) {
		this.dueDate = dueDate;
	}

	@JsonProperty("creation_date")
	@Column(name = "creation_date", nullable = false, length = 23)
	@CreationTimestamp
	public LocalDateTime getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	@JsonProperty("completed_date")
	@Column(name = "completed_date", length = 23)
	public LocalDateTime getCompletedDate() {
		return this.completedDate;
	}

	public void setCompletedDate(LocalDateTime completedDate) {
		this.completedDate = completedDate;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof Todo))
			return false;
		Todo castOther = (Todo) other;

		return ((this.getId() == castOther.getId())
				|| (this.getId() != null && castOther.getId() != null && this.getId().equals(castOther.getId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());

		return result;
	}

}
