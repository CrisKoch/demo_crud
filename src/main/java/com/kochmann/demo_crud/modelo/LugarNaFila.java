package com.kochmann.demo_crud.modelo;

import java.sql.Timestamp;
import java.time.Instant;

public class LugarNaFila {
	private Integer id, periodo;
	private String nome, professor, codigo_sala_classroom;
	private Timestamp timeStamp;
	
	public LugarNaFila(Integer id, Integer periodo, String nome, String professor, String codigo_sala_classroom,
			Timestamp timeStamp) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.nome = nome;
		this.professor = professor;
		this.codigo_sala_classroom = codigo_sala_classroom;
		this.timeStamp = timeStamp;
	}


	public Timestamp getTimeStamp() {
		
		return timeStamp;
	}


	public void setTimeStamp(Timestamp timeStamp) {
		this.timeStamp = timeStamp;
	}


	public LugarNaFila() {
		super();
	}


	public LugarNaFila(Integer periodo, String nome, String professor, String codigo_sala_classroom) {
		super();
		this.periodo = periodo;
		this.nome = nome;
		this.professor = professor;
		this.codigo_sala_classroom = codigo_sala_classroom;
	}


	public LugarNaFila(Integer id, Integer periodo, String nome, String professor, String codigo_sala_classroom) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.nome = nome;
		this.professor = professor;
		this.codigo_sala_classroom = codigo_sala_classroom;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getPeriodo() {
		return periodo;
	}


	public void setPeriodo(Integer periodo) {
		this.periodo = periodo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getProfessor() {
		return professor;
	}


	public void setProfessor(String professor) {
		this.professor = professor;
	}


	public String getCodigo_sala_classroom() {
		return codigo_sala_classroom;
	}


	public void setCodigo_sala_classroom(String codigo_sala_classroom) {
		this.codigo_sala_classroom = codigo_sala_classroom;
	}
	
	
	
	
}
