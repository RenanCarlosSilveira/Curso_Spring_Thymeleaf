package com.renan.curso.boot.dao;

import org.springframework.stereotype.Repository;

import com.renan.curso.boot.domain.Cargo;

@Repository
public class CardoDaoImpl extends AbstractDao<Cargo, Long> implements CargoDao{

}
