package com.andremachado.br.domain.service.impl;
import com.andremachado.br.domain.model.Agenda;
import com.andremachado.br.domain.model.enums.SessionVotingStatusEnum;
import com.andremachado.br.domain.repository.AgendaRepository;
import com.andremachado.br.domain.service.AgendaService;
import com.andremachado.br.dto.AgendaCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(AgendaCreateDTO dto) {
       agendaRepository.save(Agenda.builder().
                description(dto.getDescription()).
                sessionStatus(SessionVotingStatusEnum.SESSION_VOTING_CLOSE.getName()).
                build());
    }
}
