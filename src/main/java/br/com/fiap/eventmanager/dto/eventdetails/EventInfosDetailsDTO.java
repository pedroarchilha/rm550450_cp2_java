package br.com.fiap.eventmanager.dto.eventdetails;

import br.com.fiap.eventmanager.models.EventDetails;
import br.com.fiap.eventmanager.models.EventTypeEnum;

public record EventInfosDetailsDTO(

        Long id,

        String organizationName,

        String organizationEmail,

        EventTypeEnum eventType

) {

    public EventInfosDetailsDTO(EventDetails eventDetails) {
        this(
                eventDetails.getId(),
                eventDetails.getOrganizationName(),
                eventDetails.getOrganizationEmail(),
                eventDetails.getEventType()
        );
    }

}
