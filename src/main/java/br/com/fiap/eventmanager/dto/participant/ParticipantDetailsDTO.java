package br.com.fiap.eventmanager.dto.participant;

import br.com.fiap.eventmanager.models.Participant;

import java.time.LocalDateTime;

public record ParticipantDetailsDTO(
        Long id,
        String name,
        String email,
        String cellPhone,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public ParticipantDetailsDTO(Participant participant){
        this(
                participant.getId(),
                participant.getName(),
                participant.getEmail(),
                participant.getCellPhone(),
                participant.getCreatedAt(),
                participant.getUpdatedAt()
        );
    }
}
