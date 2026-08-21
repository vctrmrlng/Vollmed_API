package br.com.sistema.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController //Registra a classe como um controller do Spring, permitindo que ela manipule requisições HTTP
@RequestMapping("ola") //Define o caminho (ou url) base para todos os metodos da classe

public class OlaController {
    
    @GetMapping("/olamundo")
    
    public String olaMundo () {
        return "Olá Mundo!!!";
    }
}

//