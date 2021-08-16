package com.andremachado.br.api.controller;
import com.andremachado.br.domain.service.AgendaService;
import com.andremachado.br.dto.AgendaCreateDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/agendas")
@Api(tags = "Agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @ApiOperation("create a agenda")
    public ResponseEntity<Void> create(@Valid @RequestBody AgendaCreateDTO agendaCreateDTO){
        agendaService.create(agendaCreateDTO);
        return ResponseEntity.noContent().build();
    }

}
