package com.treinamentos.javaspring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.treinamentos.javaspring.model.Aluno;
import com.treinamentos.javaspring.repository.AlunoRepository;

@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;

    @CrossOrigin("*")
    @PostMapping("/") // 1 Cadastrar
    public String index(){
        return "index";
    }

    @CrossOrigin("*")
    @PostMapping("/cadastrar") // 1 Cadastrar
    public Aluno cadastrar(@RequestBody Aluno obj){
        return alunoRepository.save(obj);
    }

    @CrossOrigin("*") 
    @GetMapping("/listar") // 2 Listar Todos
    public Iterable<Aluno> listar(){
        return alunoRepository.findAll();
    }

    @CrossOrigin("*") 
    @GetMapping("/listar/{id}") // 3 Listar um
    public Optional<Aluno> listarUm(@PathVariable Long id){
        return alunoRepository.findById(id);
    }

    @CrossOrigin("*") 
    @DeleteMapping("/{id}") // 4 Deletar
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id){
        alunoRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin("*") 
    @PutMapping // 5 Atualizar
    public Aluno atualizarAluno(@RequestBody Aluno obj){
        if(obj.getId() > 0){
            return alunoRepository.save(obj);
        } return obj;
    }
   
}
