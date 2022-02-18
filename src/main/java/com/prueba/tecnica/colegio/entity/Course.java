package com.prueba.tecnica.colegio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity
@Table(name = "COURSE")
public class Course {

	@Id
	@Column(name="COURSE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSchool;
	
	@ManyToOne
	@JoinColumn(name="GRADE_ID")
	@JsonIgnore
	private Grade grade;
	
	@ManyToOne
	@JoinColumn(name="CLASSROOM_ID")
	@JsonIgnore
	private ClassRoom classroom;
	
	@ManyToOne
	@JoinColumn(name="SCHOOL_ID")
	@JsonIgnore
	private School school;
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
	@JoinTable(name = "COURSE_HAS_SUBJECT",
		    joinColumns = @JoinColumn(name = "COURSES_id"),
		    inverseJoinColumns = @JoinColumn(name = "SUBJECTS_id")
	)
	private List<Subject> subject = new ArrayList<>();
	
	
	
}
