package br.com.fiap.eventmanager.models;

import br.com.fiap.eventmanager.dto.address.CreateAddressDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name = "JV_CP2_ADDRESS")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "address_id")
    private Long id;

    @Column(name = "street", nullable = false, length = 100)
    private String street;

    @Column(name = "city", nullable = false, length = 100)
    private String city;

    @Column(name = "postal_code", nullable = false, length = 8)
    private String cep;

    @Column(name = "address_number", nullable = false)
    private Number number;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    public Address(CreateAddressDTO addressDTO, Event event) {
        street = addressDTO.street();
        city = addressDTO.city();
        cep = addressDTO.cep();
        number = addressDTO.number();
        this.event = event;
    }

    public Address(CreateAddressDTO addressDTO, Participant participant) {
        street = addressDTO.street();
        city = addressDTO.city();
        cep = addressDTO.cep();
        number = addressDTO.number();
        this.participant = participant;
    }
}
