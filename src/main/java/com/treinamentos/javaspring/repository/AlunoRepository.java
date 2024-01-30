package com.treinamentos.javaspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.treinamentos.javaspring.model.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, Long> {}
