package com.andremachado.br.domain.repository;

import com.andremachado.br.domain.model.Vote;
import com.andremachado.br.dto.ResultDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VoteRepository extends JpaRepository<Vote,Long> {
    Boolean existsByAssociateCpfAndAgendaId(String associateCpf, Long agendaId);

    @Query(value = "SELECT NEW com.andremachado.br.dto.ResultDTO(a.description," +
            "v.voteDescription,COUNT(v.voteDescription)) FROM Vote AS v " +
            "JOIN Agenda AS a ON v.agenda.id = a.id " +
            "GROUP BY a.description, v.voteDescription " +
            "ORDER BY v.voteDescription DESC")
    List<ResultDTO>countVotes();
}

