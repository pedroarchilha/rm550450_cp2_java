package br.com.fiap.eventmanager.dto.participant;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateParticipantDTO(
        @NotBlank(message = "Name não pode ser vazio")
        @Size(max = 100, message = "Name pode ter no máximo 100 caracteres")
        String name,

        @NotBlank(message = "Email não pode ser vazio")
        @Size(max = 100, message = "Email pode ter no máximo 100 caracteres")
        String email,

        @NotBlank(message = "Celular não pode ser vazio")
        @Size(max = 12, message = "Celular pode ter no máximo 100 caracteres")
        String cellPhone
) {
}
