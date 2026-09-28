package br.com.sistema.api.model.consulta;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta (
    Integer medicoId,
    Integer pacienteId,
    LocalDateTime data,
    String observacao,
    Status status
) {
}
