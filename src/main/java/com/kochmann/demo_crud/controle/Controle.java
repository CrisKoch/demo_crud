package com.kochmann.demo_crud.controle;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kochmann.demo_crud.dao.DisciplinaDao;
import com.kochmann.demo_crud.modelo.Disciplina;

@Controller
public class Controle {

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@RequestMapping("/disciplinas")
	public String exibirTabela(Model modelo) {
		DisciplinaDao dao = new DisciplinaDao();
		List<Disciplina> lista = dao.todos();
		modelo.addAttribute("lista", lista);
		return "disciplinas";
	}

	@GetMapping("/cadastra-disciplina")
	public String exibeForm(Model modelo) {
		modelo.addAttribute("disciplina", new Disciplina());
		return "form-disciplina";
	}

	@PostMapping("/cadastra-disciplina")
	public String processaForm(Disciplina disciplina) {
		DisciplinaDao dao = new DisciplinaDao();
		dao.inserir(disciplina);
		return "redirect:/disciplinas";
	}
}
