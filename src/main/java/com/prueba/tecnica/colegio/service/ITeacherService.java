package com.prueba.tecnica.colegio.service;

import java.util.List;

import com.prueba.tecnica.colegio.dto.TeacherDTO;

public interface ITeacherService {
	
	public List<TeacherDTO> fetchAllTeacher();

}
