package com.renan.curso.boot.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.renan.curso.boot.domain.Cargo;
import com.renan.curso.boot.domain.Departamento;
import com.renan.curso.boot.domain.Funcionario;
import com.renan.curso.boot.domain.UF;
import com.renan.curso.boot.service.CargoService;
import com.renan.curso.boot.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CargoService cargoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("funcionarios", funcionarioService.buscarTodos());
		return "/funcionario/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.salvar(funcionario);
		attr.addFlashAttribute("sucess", "Funcionário salvo!");
		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") long id, ModelMap model) {
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "/funcionario/cadastro";
	}

	@PostMapping("/editar")
	public String editar(Funcionario funcionario, RedirectAttributes attr) {
		funcionarioService.editar(funcionario);
		attr.addFlashAttribute("sucess", "Departamento atualizado!");
		return "redirect:/funcionarios/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		funcionarioService.excluir(id);
		model.addAttribute("sucess", "Departamento removido!");
		return listar(model); // Aponta para o metodo que redireciona "/departamento/lista";
	}

	@ModelAttribute("cargos")
	public List<Cargo> listaCargos() {
		return cargoService.buscarTodos();
	}

	@ModelAttribute("ufs")
	public UF[] getUfs() {
		return UF.values();
	}

}
