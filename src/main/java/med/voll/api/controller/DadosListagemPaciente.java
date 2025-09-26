package med.voll.api.controller;

import med.voll.api.pacientes.Paciente;

public record DadosListagemPaciente(Long id, String nome, String telefone, String email, boolean ativo) {
    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail(), paciente.isAtivo());
    }
}
