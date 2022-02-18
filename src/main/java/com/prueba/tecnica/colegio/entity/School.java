package com.prueba.tecnica.colegio.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@Entity
@Table(name = "SCHOOL")
public class School {

	@Id
	@Column(name="SCHOOL_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSchool;
	
	@Column(name="NAME_SCHOOL")
	private String nameSchool;
	
	@OneToMany(mappedBy="school", cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	private List<Course> course = new ArrayList<>();
}
