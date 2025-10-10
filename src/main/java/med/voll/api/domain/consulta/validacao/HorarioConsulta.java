package med.voll.api.domain.consulta.validacao;

import med.voll.api.controller.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.ValidacaoException;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;

public class HorarioConsulta {
    public void validar(DadosAgendamentoConsulta dados){
        var data = dados.data();
        var agora = LocalDateTime.now();
        var difencaMinutos = Duration.between(agora, data).toMinutes();
        if (difencaMinutos < 30){
            throw new ValidacaoException("A data de agendamento é de no minimo 30 minutos");
        }
    }
}
