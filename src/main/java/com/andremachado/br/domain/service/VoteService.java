package com.andremachado.br.domain.service;

import com.andremachado.br.domain.model.enums.VoteStatusEnum;

public interface VoteService {
    void vote(Long agendaId, String associateCpf, VoteStatusEnum voteDescription);
}
