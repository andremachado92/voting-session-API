package com.andremachado.br.api;
import com.andremachado.br.domain.service.AgendaService;
import com.andremachado.br.dto.AgendaCreateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void create(@Valid @RequestBody AgendaCreateDTO agendaCreateDTO){
        agendaService.create(agendaCreateDTO);
    }
}