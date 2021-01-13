package com.kochmann.demo_crud.controle;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kochmann.demo_crud.dao.DisciplinaDao;
import com.kochmann.demo_crud.modelo.LugarNaFila;

@Controller
public class Controle {

	DisciplinaDao dao;
	public Controle() {
		super();
		this.dao = new DisciplinaDao();
	}
	
	
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/disciplinas")
	public String exibirTabela(Model modelo) {
		List<LugarNaFila> lista = dao.todos();
		modelo.addAttribute("lista", lista);
		return "disciplinas";
	}

	@GetMapping("/cadastra-disciplina")
	public String exibeForm(Model modelo) {
		modelo.addAttribute("disciplina", new LugarNaFila());
		return "form-disciplina";
	}

	@PostMapping("/cadastra-disciplina")
	public String processaForm(LugarNaFila disciplina) {
		dao.inserir(disciplina);
		return "redirect:/disciplinas";
	}
	@GetMapping("/excluir-disciplina")
	public String excluirDisciplina(@RequestParam(name = "id", required = false) int id) {
		dao.excluir(id);
		return "redirect:/disciplinas";
	}
	
	@GetMapping("/editar-disciplina")
	public String editarDisciplina(Model modelo, @RequestParam(name = "id", required = false) int id) {
		LugarNaFila disciplina = dao.buscaPorId(id);
		modelo.addAttribute("disciplina",disciplina);
		System.out.println(disciplina.getId());
		return "form-disciplina";
	}
	@PostMapping("/editar-disciplina")
	public String editarDisciplina(LugarNaFila disciplina) {
		dao.atualizar(disciplina);
		return "redirect:/disciplinas";
	}
}
