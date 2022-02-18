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
@Table(name = "CLASSROOM")
public class ClassRoom {
	
	@Id
	@Column(name="CLASSROOM_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClassRoom;
	
	@Column(name="NAME_CLASSROOM")
	private String nameClassRoom;
	
	@OneToMany(mappedBy="classroom", cascade=CascadeType.MERGE, fetch=FetchType.LAZY)
	private List<Course> course = new ArrayList<>();
}
