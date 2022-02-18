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
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity
@Table(name = "SUBJECT")
public class Subject {

	@Id
	@Column(name="SUBJECT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSubject;
	
	@Column(name="NAME_SUBJECT")
	private String nameSubject;
	
	@ManyToMany(mappedBy = "subject")
    public List<Teacher> teacher = new ArrayList<>();
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
	@JoinTable(name = "SUBJECT_HAS_STUDENT",
		    joinColumns = @JoinColumn(name = "SUBJECTS_id"),
		    inverseJoinColumns = @JoinColumn(name = "STUDENTS_id")
	)
	private List<Student> student = new ArrayList<>();
	
	@ManyToMany(mappedBy = "subject")
    public List<Course> course = new ArrayList<>();
	
	
}
