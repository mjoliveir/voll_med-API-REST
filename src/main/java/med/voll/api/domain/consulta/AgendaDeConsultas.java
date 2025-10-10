package med.voll.api.domain.consulta;

import med.voll.api.controller.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.Especialidade;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {


    @Autowired
    private ConsultaRepository repository;
    @Autowired
    private MedicoRepository Mrepository;
    @Autowired
    private PacienteRepository Prepository;


    public void agendar(DadosAgendamentoConsulta dados){
        if (!Prepository.existsById(dados.idPaciente())){
            throw new ValidacaoException("O id do paciente informado não existe, por favor confira o id informado.");
        }

        if (!Mrepository.existsById(dados.idMedico()) && dados.idMedico() != null){
            throw new ValidacaoException("O id do medico informado não existe, por favor confira o id informado.");
        }



        var especialidade = dados.especialidade();
        var medico = escolherMedico(dados);
        var paciente = Prepository.findById(dados.idPaciente()).get();
        var consulta = new Consulta(null, medico, paciente, dados.data());
        repository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
    if (dados.idMedico() != null){
        return Mrepository.findById(dados.idMedico()).get();
    }

    if (dados.especialidade() == null){
        throw new ValidacaoException("A especialidade do médico deve ser informada");
    }
    return Mrepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

    public void cancelarConsulta(DadosCancelamentoConsulta dados){
        var consultaId = repository.getReferenceById(dados.id());
        repository.delete(consultaId);
    }
}
