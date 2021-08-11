package com.andremachado.br.api.controller;
import com.andremachado.br.domain.service.AgendaService;
import com.andremachado.br.dto.AgendaCreateDTO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public void create(@Valid @RequestBody AgendaCreateDTO agendaCreateDTO){
        agendaService.create(agendaCreateDTO);
    }

    @PutMapping("/{agendaId}/openSession")
    @ResponseStatus(code = HttpStatus.OK)
    public void openSession(@PathVariable Long agendaId,
                            @RequestParam(value = "sessionDurationInMinutes",required = false) Integer sessionDurationInMinutes) {
        agendaService.openSessionVotingOnAgenda(agendaId, sessionDurationInMinutes);
    }
}
