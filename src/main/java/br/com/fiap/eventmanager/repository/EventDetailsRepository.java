package br.com.fiap.eventmanager.repository;

import br.com.fiap.eventmanager.models.EventDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventDetailsRepository extends JpaRepository<EventDetails, Long> {
}
