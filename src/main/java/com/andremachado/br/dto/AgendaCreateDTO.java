package com.andremachado.br.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class AgendaCreateDTO {

    @NotBlank
    private String description;

}
