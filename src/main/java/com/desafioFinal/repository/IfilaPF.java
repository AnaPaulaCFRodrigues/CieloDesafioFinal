package com.desafioFinal.repository;

import com.desafioFinal.model.pFisica;

import java.util.LinkedList;

public interface IfilaPF {

    void addPJ(pFisica item);

    pFisica removerPJ();

    boolean isEmpty();

    int size();

    LinkedList<pFisica> retornarLista();
}
