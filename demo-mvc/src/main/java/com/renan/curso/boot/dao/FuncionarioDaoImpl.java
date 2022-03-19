package com.renan.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.renan.curso.boot.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao{

}
