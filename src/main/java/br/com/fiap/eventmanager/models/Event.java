package br.com.fiap.eventmanager.models;

import br.com.fiap.eventmanager.dto.event.CreateEventDTO;
import br.com.fiap.eventmanager.dto.event.EventDetailsDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor

@Entity
@Table(name = "JV_CP2_EVENT")
public class Event {

    @Id
    @GeneratedValue
    @Column(name = "event_id")
    private Long id;

    @Column(name = "title", nullable = false, length = 100)
    private String title;

    @Column(name = "description", nullable = false, length = 300)
    private String description;

    @Column(name = "initial_date", nullable = false)
    private LocalDateTime initialDate;

    @Column(name = "final_date", nullable = false)
    private LocalDateTime finalDate;

    @Column(name = "max_participants_capacity", nullable = false, precision = 10, scale = 2)
    private Number maxParticipantsCapacity;

    @Column(name = "registration_value", nullable = false)
    private BigDecimal registrationValue;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_details_id", nullable = false)
    private EventDetails eventDetails;

    @OneToMany(mappedBy = "event", cascade = CascadeType.REMOVE)
    private List<Address> addresses;

    @ManyToMany(mappedBy = "events", fetch = FetchType.LAZY)
    private List<Participant> participants;

    public Event(CreateEventDTO eventDTO) {
        title = eventDTO.title();
        description = eventDTO.description();
        initialDate = eventDTO.initialDate();
        finalDate = eventDTO.finalDate();
        maxParticipantsCapacity = eventDTO.maxParticipantsCapacity();
        registrationValue = eventDTO.registrationValue();
        eventDetails = new EventDetails(eventDTO);
        eventDetails.setEvent(this);
    }
}
