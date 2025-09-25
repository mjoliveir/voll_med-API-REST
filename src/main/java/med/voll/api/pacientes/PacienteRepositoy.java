package med.voll.api.pacientes;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepositoy extends JpaRepository<Paciente, Long> {
}
