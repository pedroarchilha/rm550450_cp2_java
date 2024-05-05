package br.com.fiap.eventmanager.dto.event;

import br.com.fiap.eventmanager.dto.eventdetails.EventInfosDetailsDTO;
import br.com.fiap.eventmanager.models.Event;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventDetailsDTO (

        Long eventId,

        String title,

        String description,

        LocalDateTime initialDate,

        LocalDateTime finalDate,

        Number maxParticipantsCapacity,

        BigDecimal registrationValue,

        EventInfosDetailsDTO eventInfosDetailsDTO

) {

    public EventDetailsDTO(Event event){
        this(
                event.getId(),
                event.getTitle(),
                event.getDescription(),
                event.getInitialDate(),
                event.getFinalDate(),
                event.getMaxParticipantsCapacity(),
                event.getRegistrationValue(),
                new EventInfosDetailsDTO(event.getEventDetails())
        );
    }

}
