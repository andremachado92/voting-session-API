package com.andremachado.br.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "VOTE")
public class Vote {

    @Id
    @Column(name = "VOTE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "VOTE_ID")
    private Agenda agenda;

    @Column(name = "VOTE_ID")
    private Long associateId;

    @Column(name = "VOTE_ID")
    private String associateCpf;
}
