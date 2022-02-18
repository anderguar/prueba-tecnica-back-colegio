package com.prueba.tecnica.colegio.service;

import java.util.List;

import com.prueba.tecnica.colegio.dto.TeacherHasSubjectHasStudentDTO;

public interface ITeacherSubjectStudentService {

	public List<TeacherHasSubjectHasStudentDTO> fetchTeacherSubjectStudent(Long idTeacher);
}
