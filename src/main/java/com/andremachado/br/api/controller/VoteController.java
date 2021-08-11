package com.andremachado.br.api.controller;
import com.andremachado.br.domain.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/agenda/{agendaId}")
    @ResponseStatus(code = HttpStatus.OK)
    public void vote(@PathVariable Long agendaId,
                     @RequestParam("associateCpf") String associateCpf,
                     @RequestParam("voteDescription") String voteDescription ){
        voteService.vote(agendaId,associateCpf,voteDescription);
    }
}
