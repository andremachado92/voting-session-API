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
@Table(name = "AGENDA")
public class Agenda {

    @Id
    @Column(name = "AGEND_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "AGEND_DESCRIPTION")
    private String description;

    @Column(name = "AGEND_SESSIONS_STATUS")
    private String sessionStatus;
}
