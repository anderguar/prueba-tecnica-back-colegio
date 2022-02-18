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
@Table(name = "TEACHER")
public class Teacher {
	
	@Id
	@Column(name="TEACHER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTeacher;
	
	@Column(name="NAME_TEACHER")
	private String nameTeacher;
	
	@ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
	@JoinTable(name = "TEACHER_HAS_SUBJECT",
		    joinColumns = @JoinColumn(name = "TEACHERS_id"),
		    inverseJoinColumns = @JoinColumn(name = "SUBJECTS_id")
	)
	private List<Subject> subject = new ArrayList<>();
	
}
