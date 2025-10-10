package med.voll.api.controller;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import med.voll.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(

        Long idMedico,

        @NotNull
        Long idPaciente,

        @NotNull
        @Future //essa anotação determina que as datas podem ser apenas no futuro
        LocalDateTime data,

        Especialidade especialidade
        ) {
}
