package med.voll.api.pacientes;

import med.voll.api.endereco.Endereco;

public record DadosDetalhamentoPaciente(
        String nome,

        String telefone,

        String cpf,

        String email,

        Endereco endereco) {

    public DadosDetalhamentoPaciente(Paciente paciente){
        this(paciente.getNome(), paciente.getTelefone(), paciente.getCpf(), paciente.getEmail(), paciente.getEndereco());
    }

}
