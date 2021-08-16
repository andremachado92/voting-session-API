package com.andremachado.br.domain.service;

import com.andremachado.br.domain.model.enums.VoteStatusEnum;
import com.andremachado.br.dto.ResultDTO;

import java.util.List;

public interface VoteService {
    void vote(Long agendaId, String associateCpf, VoteStatusEnum voteDescription);
    List<ResultDTO> countingOfVotes();
    void openSessionVotingOnAgenda(Long agendaId, Integer sessionDurationInMinutes ) throws InterruptedException;
}
