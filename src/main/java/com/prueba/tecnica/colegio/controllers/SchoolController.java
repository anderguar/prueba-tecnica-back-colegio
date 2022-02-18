package com.prueba.tecnica.colegio.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.tecnica.colegio.dto.TeacherDTO;
import com.prueba.tecnica.colegio.dto.TeacherHasSubjectHasStudentDTO;
import com.prueba.tecnica.colegio.service.ITeacherService;
import com.prueba.tecnica.colegio.service.ITeacherSubjectStudentService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SchoolController {

	@Autowired
	private ITeacherService teacherService;
	
	@Autowired
	private ITeacherSubjectStudentService teacherSubjectStudentService;
	
	@GetMapping("/teachers")
	public ResponseEntity<List<TeacherDTO>> getAllTeacher() {
		return new ResponseEntity<List<TeacherDTO>>(teacherService.fetchAllTeacher(), HttpStatus.OK);
	}
	
	@GetMapping("/teachers/subjects/students/{idTeacher}")
	public ResponseEntity<List<TeacherHasSubjectHasStudentDTO>> getTeacherHasSubjectInnerJoin(@PathVariable("idTeacher") Long idTeacher) {
		return new ResponseEntity<List<TeacherHasSubjectHasStudentDTO>>(teacherSubjectStudentService.fetchTeacherSubjectStudent(idTeacher), HttpStatus.OK);
	}
	
	
}
