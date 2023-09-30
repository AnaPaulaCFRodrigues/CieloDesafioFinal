package com.desafioFinal.repository;

import com.desafioFinal.model.pFisica;

import java.util.LinkedList;

public interface IfilaPF {

    void addPF(pFisica item);

    pFisica removerPF();

    boolean isEmpty();

    int size();

    LinkedList<pFisica> retornarLista();
}
