package com.kochmann.demo_crud.controle;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kochmann.demo_crud.dao.DisciplinaDao;
import com.kochmann.demo_crud.modelo.Disciplina;

@Controller
public class Controle {
	
	@RequestMapping("/home")
	public String metodoMapeado() {
		return "exemplo";
	}
	
	@RequestMapping("/disciplinas")
	public String exibirTabela(Model modelo) {
		DisciplinaDao dao = new DisciplinaDao();
		List<Disciplina> lista = dao.todos();
		modelo.addAttribute("lista", lista);
		return "disciplinas";
	}
}
