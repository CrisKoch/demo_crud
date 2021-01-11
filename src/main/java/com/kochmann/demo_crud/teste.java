package com.kochmann.demo_crud;

import java.util.List;

import com.kochmann.demo_crud.dao.DisciplinaDao;
import com.kochmann.demo_crud.modelo.Disciplina;

public class teste {

	public static void main(String[] args) {
		
		//Disciplina dis = new Disciplina(2, "Matematica", "João Roberto", "mat02");
		DisciplinaDao dao = new DisciplinaDao();
		//dao.inserir(dis);
		List<Disciplina> lista = dao.todos();
		for (Disciplina disciplina : lista) {
			System.out.println("Nome da disciplina: " + disciplina.getNome());
		}
	}

}
