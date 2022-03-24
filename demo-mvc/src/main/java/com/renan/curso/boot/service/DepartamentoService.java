package com.renan.curso.boot.service;

import java.util.List;

import com.renan.curso.boot.domain.Departamento;

public interface DepartamentoService {
	void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos(); 
	
	boolean departamentoTemCargos(Long id);
}
