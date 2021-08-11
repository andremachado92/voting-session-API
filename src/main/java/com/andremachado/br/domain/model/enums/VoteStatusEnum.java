package com.andremachado.br.domain.model.enums;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VoteStatusEnum {

    SIM("SIM","Representa o voto SIM"),
    NAO("NAO","Representa o voto NAO");

    private String name;
    private String description;
}
