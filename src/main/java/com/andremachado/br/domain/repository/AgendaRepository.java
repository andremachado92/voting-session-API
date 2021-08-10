package com.andremachado.br.domain.repository;
import com.andremachado.br.domain.model.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendaRepository extends JpaRepository<Agenda,Long> {
}
