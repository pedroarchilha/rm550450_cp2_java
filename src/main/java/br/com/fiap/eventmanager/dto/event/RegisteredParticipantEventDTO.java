package br.com.fiap.eventmanager.dto.event;

import br.com.fiap.eventmanager.dto.participant.ParticipantDetailsDTO;
import br.com.fiap.eventmanager.models.Event;

import java.util.List;

public record RegisteredParticipantEventDTO(
        EventDetailsDTO eventDetails,
        List<ParticipantDetailsDTO> participants
) {
    public RegisteredParticipantEventDTO(Event event){
        this(
          new EventDetailsDTO(event),
          event.getParticipants().stream().map(ParticipantDetailsDTO::new).toList()
        );
    }
}
