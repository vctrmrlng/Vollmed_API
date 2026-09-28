package br.com.sistema.api.controller;

import br.com.sistema.api.model.paciente.DadosAtualizacaoPaciente;
import br.com.sistema.api.model.paciente.Paciente;
import br.com.sistema.api.model.paciente.DadosCadastroPaciente;
import br.com.sistema.api.model.paciente.PacienteRepository;
import jakarta.transaction.Transactional;
import java.util.List;

import org.springframework.web.bind.annotation.*;


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

    @GetMapping("/listartodos") // Aponta para localhost:8080/paciente
    public List<Paciente> listarPacientes() {
        return pacienteRepository.findAll();
    }
    
    //DEL - Exclusão 
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public void excluir(@PathVariable Integer id) {
        pacienteRepository.deleteById(id);
    }

    // DEL - Exclusão Logica
    @DeleteMapping("/alterarstatus/{id}")
    @Transactional 
    public void alterarStatus(@PathVariable Integer id) {
        var paciente = pacienteRepository.getReferenceById(id); //o var está sendo utilizado para que assim que o id for chamado e acessado eu pegue todas os atributos
        paciente.excluirLogico();
    }
    
    @PutMapping ("/atualizar")
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoPaciente dados) {
        var medico = pacienteRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);

    // GET   
    // POST
    // PUT
    // DELETE    
    // CRUD
    
}

}