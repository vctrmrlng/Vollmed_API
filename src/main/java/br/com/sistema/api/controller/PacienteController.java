package br.com.sistema.api.controller;

import br.com.sistema.api.model.paciente.PacienteRepository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.paciente.DadosCadastroPaciente;
import br.com.sistema.api.model.paciente.Paciente;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("paciente")
public class PacienteController {
    
    private final PacienteRepository pacienteRepository;


    PacienteController(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }


    @PostMapping("/cadastro")
    @Transactional 
    public void cadastrarPaciente(@RequestBody DadosCadastroPaciente dados) {
        //TODO: process POST request
        pacienteRepository.save(new Paciente(dados));
    }
    
    
    // GET
   
    // POST
    // PUT
    // DELETE
    
    // CRUD
    
}

