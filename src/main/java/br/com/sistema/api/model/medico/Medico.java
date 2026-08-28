package br.com.sistema.api.model.medico;

import br.com.sistema.api.model.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "medicos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode (of = "id")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    
    @Embedded
    private Endereco endereco;
}


// nome
// email 
// telefone
// crm
// especialidade (cardio, gineco, dermato, orto)
// endereço completo