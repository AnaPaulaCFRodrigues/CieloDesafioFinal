package com.desafioFinal.dto;

import com.desafioFinal.model.pFisica;
import com.desafioFinal.model.pJuridica;

public record dadosListaPF(long id, String CPF, String MCC, String nomePF, String emailPF) {

    public dadosListaPF(pFisica pf) {
        this(pf.getId(), pf.getCPF(), pf.getMCC(), pf.getNomePF(), pf.getEmailPF());
    }
}

