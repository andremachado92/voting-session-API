package com.andremachado.br.domain.service.impl;

import com.andremachado.br.api.exception.ObjectNotFoundException;
import com.andremachado.br.domain.model.Agenda;
import com.andremachado.br.domain.model.enums.SessionVotingStatusEnum;
import com.andremachado.br.domain.repository.AgendaRepository;
import com.andremachado.br.domain.service.AgendaService;
import com.andremachado.br.dto.AgendaCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.TimerTask;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(AgendaCreateDTO dto) {
       agendaRepository.save(
                Agenda.builder().
                description(dto.getDescription()).
                sessionStatus(SessionVotingStatusEnum.SESSION_VOTING_CLOSE.getName()).
                build());
    }

    @Override
    public Agenda findById(Long agendaId) {
        return agendaRepository.findById(agendaId).orElseThrow(
                () -> new ObjectNotFoundException("Pauta não encontrada para o id: "+agendaId));
    }



}
