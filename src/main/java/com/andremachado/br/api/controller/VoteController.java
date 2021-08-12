package com.andremachado.br.api.controller;
import com.andremachado.br.domain.model.enums.VoteStatusEnum;
import com.andremachado.br.domain.service.VoteService;
import com.andremachado.br.dto.ResultDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vote")
@Api(tags = "Vote")
public class VoteController {

    @Autowired
    private VoteService voteService;

    @PostMapping("/agenda/{agendaId}")
    @ResponseStatus(code = HttpStatus.OK)
    @ApiOperation("vote for an agenda")
    public void vote(@PathVariable Long agendaId,
                     @RequestParam("associateCpf") String associateCpf,
                     @RequestParam("voteDescription") VoteStatusEnum vote ){
        voteService.vote(agendaId,associateCpf,vote);
    }

    @GetMapping("countVotes")
    @ResponseStatus(code = HttpStatus.OK)
    @ApiOperation("count votes")
    public List<ResultDTO>countVotes(){
        return voteService.countingOfVotes();
    }
}
