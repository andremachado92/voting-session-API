package com.andremachado.br.domain.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Agenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String sessionStatus;

}
