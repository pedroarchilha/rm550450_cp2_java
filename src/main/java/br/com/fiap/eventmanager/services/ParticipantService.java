package br.com.fiap.eventmanager.services;

import br.com.fiap.eventmanager.dto.participant.CreateParticipantDTO;
import br.com.fiap.eventmanager.dto.participant.EventRecordsForParticipantDTO;
import br.com.fiap.eventmanager.dto.participant.ParticipantDetailsDTO;
import br.com.fiap.eventmanager.dto.participant.UpdateParticipantDTO;
import br.com.fiap.eventmanager.models.Event;
import br.com.fiap.eventmanager.models.Participant;
import br.com.fiap.eventmanager.repository.EventRepository;
import br.com.fiap.eventmanager.repository.ParticipantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    ParticipantRepository participantRepository;
    @Autowired
    EventRepository eventRepository;

    @Transactional
    public Participant create(CreateParticipantDTO participantDTO){
        Participant participant = new Participant(participantDTO);
        return participantRepository.save(participant);
    }

    public List<ParticipantDetailsDTO> getAll(Pageable pageable) {
        return participantRepository.findAll(pageable).stream()
                .map(ParticipantDetailsDTO::new).toList();
    }

    public ParticipantDetailsDTO getOne(Long participantId) {
        Participant participant = participantRepository.getReferenceById(participantId);
        return new ParticipantDetailsDTO(participant);
    }

    @Transactional
    public ParticipantDetailsDTO update(Long participantId, UpdateParticipantDTO participantDTO){
        Participant participant = participantRepository.getReferenceById(participantId);

        participant.setName(participantDTO.name());
        participant.setEmail(participantDTO.email());
        participant.setCellPhone(participant.getCellPhone());
        participant.setUpdatedAt(LocalDateTime.now());

        participantRepository.save(participant);
        return new ParticipantDetailsDTO(participant);
    }

    @Transactional
    public EventRecordsForParticipantDTO registerEvent(Long participantId,Long eventId){
        Participant participant = participantRepository.getReferenceById(participantId);
        Event event = eventRepository.getReferenceById(eventId);
        participant.getEvents().add(event);
        return new EventRecordsForParticipantDTO(participant);
    }


    @Transactional
    public void delete(Long participantId){
        participantRepository.deleteById(participantId);
    }

}
