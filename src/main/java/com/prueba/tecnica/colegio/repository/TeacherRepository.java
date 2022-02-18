package com.prueba.tecnica.colegio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prueba.tecnica.colegio.dto.TeacherHasSubjectHasStudentDTO;
import com.prueba.tecnica.colegio.dto.TeacherDTO;
import com.prueba.tecnica.colegio.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Long> {
	
	@Query("SELECT new com.prueba.tecnica.colegio.dto.TeacherDTO(t.idTeacher, t.nameTeacher) FROM Teacher t")
	public List<TeacherDTO> fetchAllTeacher();

	@Query("SELECT new com.prueba.tecnica.colegio.dto.TeacherHasSubjectHasStudentDTO(t.idTeacher, t.nameTeacher, s.nameSubject, e.nameStudent) "
			+ "FROM Teacher t INNER JOIN t.subject s INNER JOIN s.student e WHERE t.idTeacher = ?1")
	public List<TeacherHasSubjectHasStudentDTO> fetchTeacherSubjectStudent(Long idTeacher);
	
}
