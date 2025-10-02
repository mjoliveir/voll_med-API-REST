package med.voll.api.pacientes;

public record DadosListagemPaciente(Long id, String nome, String telefone, String email, boolean ativo) {
    public DadosListagemPaciente(Paciente paciente){
        this(paciente.getId(), paciente.getNome(), paciente.getTelefone(), paciente.getEmail(), paciente.isAtivo());
    }
}
