package br.com.sistema.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {
    // GET
    @GetMapping("/")
    public String exibirHome(){
        return "a";
    }

    // POST
    // PUT
    // DELETE
    
    // CRUD
    
}

