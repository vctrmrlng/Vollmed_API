package br.com.sistema.api.model.consulta;

import br.com.sistema.api.model.medico.Medico;
import br.com.sistema.api.model.paciente.Paciente;

import java.time.LocalDateTime;
import jakarta.persistence.*;
import lombok.*;

@Entity 
@Table (name = "consultas")
@Getter
@Setter
@AllArgsConstructor 
@NoArgsConstructor
@EqualsAndHashCode (of = "id")

public class Consulta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private Medico medico;
    private Paciente paciente;
    private String observacao;
    private LocalDateTime data;
    private Status status; 

    //Terceiro construtor da classe Consulta, que recebe um a conversão de DadosAgendamentoConsulta
    // o this.medico = new Medico(dados.medicoId()) cria um objeto vazio. Quando você tenta inserir o id desse novo médico criado, 
    // o new Medico() ira receber o id, e o BD saberá que aquele id já existe e trará as informaçoes com o o id daquele médico


    public Consulta (DadosAgendamentoConsulta dados) {
        this.status = dados.status();
        this.observacao = dados.observacao();
        this.data = dados.data();
        this.medico = new Medico();
        this.medico.setId(dados.medicoId());
        this.paciente = new Paciente();
        this.paciente.setId(dados.pacienteId());
    }

}

// @ManyToOne => Muitas consultas podem ter um mesmo médico, ou seja, um médico pode ter várias consultas.