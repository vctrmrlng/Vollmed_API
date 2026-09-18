package br.com.sistema.api.model.paciente;

import br.com.sistema.api.model.endereco.DadosCadastroEndereco;

// DTO do cadastro das informações do paciente

public record DadosCadastroPaciente(
    String nome,
    String email,
    String telefone,
    DadosCadastroEndereco endereco
) {

}
