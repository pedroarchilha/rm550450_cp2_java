package br.com.fiap.eventmanager.controller;

import br.com.fiap.eventmanager.dto.event.CreateEventDTO;
import br.com.fiap.eventmanager.dto.event.EventDetailsDTO;
import br.com.fiap.eventmanager.dto.event.RegisteredParticipantEventDTO;
import br.com.fiap.eventmanager.dto.event.UpdateEventDTO;
import br.com.fiap.eventmanager.dto.participant.EventRecordsForParticipantDTO;
import br.com.fiap.eventmanager.models.Event;
import br.com.fiap.eventmanager.services.EventService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    EventService eventService;

    @PostMapping
    public ResponseEntity<EventDetailsDTO> create(@RequestBody @Valid CreateEventDTO eventDTO,
                                                  UriComponentsBuilder uri){
        Event event = new Event(eventDTO);
        var newEvent = eventService.create(event);
        var url = uri.path("/events/{event_id}").buildAndExpand(event.getId()).toUri();

        return ResponseEntity.created(url).body(newEvent);
    }

    @GetMapping
    public ResponseEntity<List<EventDetailsDTO>> findAll(Pageable pageable){
        var eventList = eventService.getAll(pageable);
        return ResponseEntity.ok(eventList);
    }

    @GetMapping("{event_id}")
    public ResponseEntity<EventDetailsDTO> findOne(@PathVariable("event_id") Long eventId){
        var event = eventService.getOne(eventId);
        return ResponseEntity.ok(event);
    }

    @GetMapping("/participants/{event_id}")
    public ResponseEntity<RegisteredParticipantEventDTO> getEventParticipants(@PathVariable("event_id") Long eventId){
        var event = eventService.getEventParticipants(eventId);
        return ResponseEntity.ok(event);
    }

    @PutMapping("{event_id}")
    public ResponseEntity<EventDetailsDTO> findOne(@PathVariable("event_id") Long eventId,
                                                   @RequestBody @Valid UpdateEventDTO eventDTO){
        var event = eventService.update(eventId, eventDTO);
        return ResponseEntity.ok(event);
    }

    @DeleteMapping("{event_id}")
    public ResponseEntity<Void> delete(@PathVariable("event_id") Long eventId){
        eventService.delete(eventId);
        return ResponseEntity.noContent().build();
    }

}
