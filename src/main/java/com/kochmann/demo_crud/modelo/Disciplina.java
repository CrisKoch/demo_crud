package com.kochmann.demo_crud.modelo;

public class Disciplina {
	public Integer id, periodo;
	public String nome, professor, codigo_sala_classroom;
	
	
	public Disciplina() {
		super();
	}


	public Disciplina(Integer periodo, String nome, String professor, String codigo_sala_classroom) {
		super();
		this.periodo = periodo;
		this.nome = nome;
		this.professor = professor;
		this.codigo_sala_classroom = codigo_sala_classroom;
	}


	public Disciplina(Integer id, Integer periodo, String nome, String professor, String codigo_sala_classroom) {
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
