package br.com.fiap.eventmanager.repository;

import br.com.fiap.eventmanager.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
