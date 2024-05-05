package br.com.fiap.eventmanager.services;

import br.com.fiap.eventmanager.dto.event.EventDetailsDTO;
import br.com.fiap.eventmanager.dto.event.RegisteredParticipantEventDTO;
import br.com.fiap.eventmanager.dto.event.UpdateEventDTO;
import br.com.fiap.eventmanager.dto.eventdetails.EventInfosDetailsDTO;
import br.com.fiap.eventmanager.models.Event;
import br.com.fiap.eventmanager.repository.EventDetailsRepository;
import br.com.fiap.eventmanager.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;
    @Autowired
    EventDetailsRepository eventDetailsRepository;

    @Transactional
    public EventDetailsDTO create(Event event){
        eventRepository.save(event);
        return  new EventDetailsDTO(event);
    }

    public List<EventDetailsDTO> getAll(Pageable pageable) {
        return eventRepository.findAll(pageable).stream()
                .map(EventDetailsDTO::new).toList();
    }

    public EventDetailsDTO getOne(Long eventId) {
        var event = eventRepository.getReferenceById(eventId);
        return new EventDetailsDTO(event);
    }

    public RegisteredParticipantEventDTO getEventParticipants(Long eventId) {
        var event = eventRepository.getReferenceById(eventId);
        return new RegisteredParticipantEventDTO(event);
    }

    @Transactional
    public EventDetailsDTO update(Long eventId, UpdateEventDTO eventDTO){
        var event = eventRepository.getReferenceById(eventId);

        event.setTitle(eventDTO.title());
        event.setDescription(eventDTO.description());
        event.setInitialDate(eventDTO.initialDate());
        event.setFinalDate(eventDTO.finalDate());
        event.setMaxParticipantsCapacity(eventDTO.maxParticipantsCapacity());
        event.setRegistrationValue(eventDTO.registrationValue());
        event.getEventDetails().setOrganizationName(eventDTO.organizationName());
        event.getEventDetails().setOrganizationEmail(eventDTO.organizationEmail());
        event.getEventDetails().setEventType(eventDTO.eventType());

        eventRepository.save(event);

        return new EventDetailsDTO(event);
    }

    @Transactional
    public void delete(Long eventId){
        eventRepository.deleteById(eventId);
    }

}
