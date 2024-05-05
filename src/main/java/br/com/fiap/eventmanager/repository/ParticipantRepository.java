package br.com.fiap.eventmanager.repository;

import br.com.fiap.eventmanager.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
