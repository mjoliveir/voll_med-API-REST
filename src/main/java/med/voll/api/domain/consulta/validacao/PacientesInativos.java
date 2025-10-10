package med.voll.api.domain.consulta.validacao;

import med.voll.api.controller.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.ValidacaoException;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PacientesInativos {

@Autowired
    PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados){
        var pacienteConsulta = pacienteRepository.getReferenceById(dados.idPaciente());
        if (!pacienteConsulta.getAtivo()){
            throw new ValidacaoException("o paciente deve estar ativo para realizar consulta");
        }
    }
}
