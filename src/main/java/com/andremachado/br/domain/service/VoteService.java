package com.andremachado.br.domain.service;

public interface VoteService {
    void vote(Long agendaId, String associateCpf);
}
