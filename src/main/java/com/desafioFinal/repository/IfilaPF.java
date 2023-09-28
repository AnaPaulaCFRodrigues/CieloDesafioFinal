package com.desafioFinal.repository;

import com.desafioFinal.model.pFisica;

public interface IfilaPF {

    void addPJ(pFisica item);

    pFisica removerPJ();

    boolean isEmpty();

    int size();
}
