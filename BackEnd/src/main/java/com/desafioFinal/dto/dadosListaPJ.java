package com.desafioFinal.dto;

import com.desafioFinal.model.pJuridica;

public record dadosListaPJ(long id, String CNPJ, String razaoSocial, String MCC, String CPF, String nomePJ, String emailPJ) {

    public dadosListaPJ(pJuridica pj) {
        this(pj.getId(), pj.getCNPJ(), pj.getRazaoSocial(), pj.getMCC(), pj.getCPF(), pj.getNomePJ(),pj.getEmailPJ());
    }

}
