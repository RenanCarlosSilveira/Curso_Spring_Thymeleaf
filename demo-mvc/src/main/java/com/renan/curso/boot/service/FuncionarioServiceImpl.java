package com.renan.curso.boot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.renan.curso.boot.dao.FuncionarioDao;
import com.renan.curso.boot.domain.Funcionario;


public class FuncionarioServiceImpl implements FuncionarioService{
	@Autowired
	private FuncionarioDao dao;
	
	@Transactional( readOnly = false)
	@Override
	public void salvar(Funcionario funcionario) {
		dao.save(funcionario);
	}

	@Transactional( readOnly = false)
	@Override
	public void editar(Funcionario funcionario) {
		dao.update(funcionario);
	}

	@Transactional( readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}
	
	@Transactional( readOnly = true)
	@Override
	public Funcionario buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Transactional( readOnly = true)
	@Override
	public List<Funcionario> buscarTodos() {
		return dao.findAll();
	}
}
