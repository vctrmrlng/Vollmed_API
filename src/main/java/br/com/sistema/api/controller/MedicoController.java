package br.com.sistema.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.sistema.api.model.medico.DadosAtualizacaoMedico;
import br.com.sistema.api.model.medico.DadosCadastroMedico;
import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.medico.MedicoRepository;
import jakarta.transaction.Transactional;


@RestController
@RequestMapping("medico") 
public class MedicoController {
    // GET Request -> Response -> Ex: Tela home

    @Autowired
    private MedicoRepository medicoRepository;
    
    @PostMapping("/cadastro")
    @Transactional 
    public void cadastrarMedico(@RequestBody DadosCadastroMedico dados) {
        medicoRepository.save(new Medico(dados));
    }
    
    @GetMapping("/listartodos") // Aponta para localhost:8080/medico
    public List<Medico> listarMedicos() {
        return medicoRepository.findAll();
    }

    //DEL - Exclusão 
    @DeleteMapping("/deletar/{id}")
    @Transactional
    public void excluir(@PathVariable Integer id) {
        medicoRepository.deleteById(id);
    }

    // DEL - Exclusão Logica
    @DeleteMapping("/alterarstatus/{id}")
    @Transactional 
    public void alterarStatus(@PathVariable Integer id) {
        var medico = medicoRepository.getReferenceById(id); //o var está sendo utilizado para que assim que o id for chamado e acessado eu pegue todas os atributos
        medico.excluirLogico();
    }

    @PutMapping ("/atualizar")
    @Transactional
    public void atualizar(@RequestBody DadosAtualizacaoMedico dados) {
        var medico = medicoRepository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }



    // GET/POST Request -> Response -> Ex: Cadastrar Médico. GET Exibe tela de cadastro e o POST é chamado quando o botão enviar é clicado.
   
    // GET/PUT Request -> Response -> Ex: Alterar telefone. Get exibe a tela de alteração e o PUT é chamado quando o botão alterar é clicado.

    // DELETE

    // CRUD 
}
