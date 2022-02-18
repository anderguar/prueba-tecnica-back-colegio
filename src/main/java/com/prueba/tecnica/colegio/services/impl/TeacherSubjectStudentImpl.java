package com.prueba.tecnica.colegio.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.tecnica.colegio.dto.TeacherHasSubjectHasStudentDTO;
import com.prueba.tecnica.colegio.repository.TeacherRepository;
import com.prueba.tecnica.colegio.service.ITeacherSubjectStudentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TeacherSubjectStudentImpl implements ITeacherSubjectStudentService{

	@Autowired
	TeacherRepository teacherRepository;
	
	@Transactional
	public List<TeacherHasSubjectHasStudentDTO> fetchTeacherSubjectStudent(Long idTeacher) {
		List<TeacherHasSubjectHasStudentDTO> teacherHasSubjectHasStudent = teacherRepository.fetchTeacherSubjectStudent(idTeacher);
		teacherHasSubjectHasStudent.forEach(l -> log.info("List TeacherSubjectStudent: " + l));
		return teacherHasSubjectHasStudent;
	}

}
