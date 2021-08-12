package com.andremachado.br.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResultDTO {
    private String agenda;
    private String voteDescription;
    private Long vote;
}
