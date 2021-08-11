package com.andremachado.br.utils;

import com.andremachado.br.api.exception.AgendaException;
import com.andremachado.br.api.exception.CpfException;
import com.andremachado.br.api.exception.UnableToVoteException;
import com.andremachado.br.domain.model.Agenda;
import com.andremachado.br.domain.repository.VoteRepository;
import com.andremachado.br.dto.ValidationAssociateCpfDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

public class Utils {


    public static String cpfReplace(String associateCpf) {
        return associateCpf.replaceAll("[^0-9]", "");
    }

    public static void validationAgenda(Agenda agenda) {
        if(agenda.getSessionStatus().equals("CLOSE")){
            throw new AgendaException("A pauta: "+ agenda.getDescription()+" está fechada para votação");
        }
    }

}
