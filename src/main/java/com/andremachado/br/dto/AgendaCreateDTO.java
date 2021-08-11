package com.andremachado.br.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AgendaCreateDTO {

    @NotBlank
    @ApiModelProperty(notes = "Representa a descrição da pauta", example = "Nova Pauta")
    private String description;

}
