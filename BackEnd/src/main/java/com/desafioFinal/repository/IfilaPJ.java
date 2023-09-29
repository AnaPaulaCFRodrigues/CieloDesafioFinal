package com.desafioFinal.repository;

import com.desafioFinal.model.pJuridica;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public interface IfilaPJ {


    void addPJ(pJuridica item);

    pJuridica removerPJ();

    boolean isEmpty();

    int size();

    LinkedList<pJuridica> retornarLista();
}
