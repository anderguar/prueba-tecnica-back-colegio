package com.prueba.tecnica.colegio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity
@Table(name = "STUDENT")
public class Student {

	@Id
	@Column(name="STUDENT_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStudent;
	
	@Column(name="NAME_STUDENT")
	private String nameStudent;
	
	@ManyToMany(mappedBy = "student")
    public List<Subject> subject = new ArrayList<>();
}
