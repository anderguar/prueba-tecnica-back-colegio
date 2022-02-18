package com.prueba.tecnica.colegio.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class TeacherHasSubjectHasStudentDTO {

	private Long idTeacher;
	private String nameTeacher;
	private String nameSubject;
	private String nameStudent;
}
