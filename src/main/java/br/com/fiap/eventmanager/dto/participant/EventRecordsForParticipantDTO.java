package br.com.fiap.eventmanager.dto.participant;

import br.com.fiap.eventmanager.dto.event.EventDetailsDTO;
import br.com.fiap.eventmanager.models.Participant;

import java.util.List;

public record EventRecordsForParticipantDTO(
        ParticipantDetailsDTO participantDetails,
        List<EventDetailsDTO> events
) {
    public EventRecordsForParticipantDTO(Participant participant){
        this(
            new ParticipantDetailsDTO(participant),
            participant.getEvents().stream().map(EventDetailsDTO::new).toList()
        );
    }
}
