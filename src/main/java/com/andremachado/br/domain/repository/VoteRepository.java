package com.andremachado.br.domain.repository;

import com.andremachado.br.domain.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoteRepository extends JpaRepository<Vote,Long> {
    Boolean existsByAssociateCpf(String associateCpf);
}
