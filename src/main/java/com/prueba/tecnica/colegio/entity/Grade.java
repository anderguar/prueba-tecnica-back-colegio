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
@Table(name = "GRADE")
public class Grade {
	
	@Id
	@Column(name="GRADE_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGrade;
	
	@Column(name="NAME_GRADE")
	private String nameGrade;
	
	@OneToMany(mappedBy="grade", cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	private List<Course> course = new ArrayList<>();
}
