package br.com.fiap.eventmanager.dto.event;

import br.com.fiap.eventmanager.models.EventTypeEnum;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record UpdateEventDTO (
        @NotBlank(message = "Título não pode ser vazio")
        @Size(max = 100, message = "Título pode ter no máximo 100 caracteres")
        String title,

        @NotBlank(message = "Description não pode ser vazio")
        @Size(max = 300, message = "Descrição pode ter no máximo 300 caracteres")
        String description,

        @NotNull(message = "Data de início não pode ser vazia")
        @Future(message = "Data de início não pode ser uma data passada")
        LocalDateTime initialDate,

        @NotNull(message = "Data final não pode ser vazia")
        @Future(message = "Data final não pode ser uma data passada")
        LocalDateTime finalDate,

        @NotNull(message = "Capacidade máxima de participantes não pode ser vazia")
        Number maxParticipantsCapacity,

        @NotNull(message = "Valor de registro não pode ser vazio")
        BigDecimal registrationValue,

        @NotBlank(message = "Organization name não pode ser vazio")
        @Size(max = 100, message = "Título pode ter no máximo 100 caracteres")
        String organizationName,

        @NotBlank(message = "Organization email não pode ser vazio")
        @Size(max = 100, message = "Título pode ter no máximo 100 caracteres")
        String organizationEmail,

        @NotNull(message = "Tipo de evento não pode ser vazio")
        EventTypeEnum eventType
){
}
