package com.andremachado.br.domain.model.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SessionVotingStatusEnum {

    SESSION_VOTING_OPEN("OPEN","indica que a sessão de votação está aberta"),
    SESSION_VOTING_CLOSE("CLOSE","indica que a sessão de votação está fechada");

    private String name;
    private String description;
}
