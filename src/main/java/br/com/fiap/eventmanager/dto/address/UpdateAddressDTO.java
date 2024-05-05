package br.com.fiap.eventmanager.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record UpdateAddressDTO(
        @NotBlank(message = "Nome da rua não pode ser vazio")
        @Size(max = 100, message = "Nome da rua pode ter no máximo 100 caracteres")
        String street,

        @NotBlank(message = "Nome da Cidade não pode ser vazio")
        @Size(max = 100, message = "Nome da Cidade pode ter no máximo 100 caracteres")
        String city,

        @NotBlank(message = "Cep não pode ser vazio")
        @Size(max = 8, message = "Cep pode ter no máximo 8 caracteres")
        String cep,

        @NotNull(message = "Número do endereço não pode ser vazio")
        @Positive(message = "Número do endereco deve ser positivo")
        Number number
) {
}
