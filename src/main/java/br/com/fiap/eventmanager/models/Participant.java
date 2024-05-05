package br.com.fiap.eventmanager.models;

import br.com.fiap.eventmanager.dto.participant.CreateParticipantDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "JV_CP2_PARTICIPANT")
@EntityListeners(AuditingEntityListener.class)
public class Participant {

    @Id
    @GeneratedValue
    @Column(name = "participant_id")
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "cell_phone", nullable = false, length = 12)
    private String cellPhone;

    @Column(name = "created_at", nullable = false)
    @CreatedDate
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "participant", cascade = CascadeType.REMOVE)
    private List<Address> addresses;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "Registration",
            joinColumns = @JoinColumn(name = "participant_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events;

    public Participant(CreateParticipantDTO participantDTO) {
        name = participantDTO.name();
        email = participantDTO.email();
        cellPhone = participantDTO.cellPhone();
    }
}
