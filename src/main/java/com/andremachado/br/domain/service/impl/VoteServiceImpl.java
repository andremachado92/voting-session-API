package com.andremachado.br.domain.service.impl;
import com.andremachado.br.api.exception.AgendaException;
import com.andremachado.br.api.exception.CpfException;
import com.andremachado.br.api.exception.UnableToVoteException;
import com.andremachado.br.domain.model.Agenda;
import com.andremachado.br.domain.model.Vote;
import com.andremachado.br.domain.repository.VoteRepository;
import com.andremachado.br.domain.service.AgendaService;
import com.andremachado.br.domain.service.VoteService;
import com.andremachado.br.dto.ValidationAssociateCpfDTO;
import com.andremachado.br.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class VoteServiceImpl implements VoteService {

    @Autowired
    private VoteRepository voteRepository;

    @Autowired
    private AgendaService agendaService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void vote(Long agendaId, String associateCpf,String voteDescription) {
        var agenda = agendaService.findById(agendaId);
        var cpf = Utils.cpfReplace(associateCpf);

        Utils.validationAgenda(agenda);
        validationAssociateCpf(cpf);

        voteRepository.save(
            Vote.builder().
                    agenda(agenda).
                    associateCpf(associateCpf).
                    associateId(UUID.randomUUID().toString()).
                    voteDescription(voteDescription).
                    build()
        );

    }


    private void validationAssociateCpf(String associateCpf) {
        var unfit = voteRepository.existsByAssociateCpf(associateCpf);
        var url= "https://user-info.herokuapp.com/users/" + associateCpf;
        var restTemplate = new RestTemplate();

        var valid = new ValidationAssociateCpfDTO();

        try{
             valid = restTemplate.getForObject(url, ValidationAssociateCpfDTO.class);
        }catch (Exception e){
            System.err.println(e.getMessage());
            throw new CpfException("CPF INVÁLIDO");
        }


        if(valid.getStatus().equals("UNABLE_TO_VOTE") || unfit.equals(Boolean.TRUE)){
            System.err.println(valid.getStatus());
            throw new UnableToVoteException("Associado Inapto para votar");
        }

    }
}
