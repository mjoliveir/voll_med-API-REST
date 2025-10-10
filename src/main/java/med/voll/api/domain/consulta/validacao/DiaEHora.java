package med.voll.api.domain.consulta.validacao;

import med.voll.api.controller.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.ValidacaoException;

import java.time.DayOfWeek;

public class DiaEHora {
    public void validar(DadosAgendamentoConsulta dados){
        var dia = dados.data();
        var domingo = dia.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAberturaDaClinica = dia.getHour() < 7;
        var DepoisDoEncerramentoDaClinica = dia.getHour() > 18;

        if (domingo || antesDaAberturaDaClinica || DepoisDoEncerramentoDaClinica){
            throw new ValidacaoException("Fora do funcionamento da clinica");
        }

    }
}
