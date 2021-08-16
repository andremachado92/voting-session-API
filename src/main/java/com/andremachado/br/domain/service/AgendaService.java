package com.andremachado.br.domain.service;
import com.andremachado.br.domain.model.Agenda;
import com.andremachado.br.dto.AgendaCreateDTO;

public interface AgendaService {
    void create(AgendaCreateDTO dto);
    Agenda findById(Long agendaId);
}
