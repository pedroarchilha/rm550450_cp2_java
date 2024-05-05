package br.com.fiap.eventmanager.dto.address;

import br.com.fiap.eventmanager.models.Address;

public record AddressDetailsDTO(
        Long id,
        String street,
        String city,
        String cep,
        Number number
) {
    public AddressDetailsDTO(Address address){
        this(
                address.getId(),
                address.getStreet(),
                address.getCity(),
                address.getCep(),
                address.getNumber()
        );
    }
}
