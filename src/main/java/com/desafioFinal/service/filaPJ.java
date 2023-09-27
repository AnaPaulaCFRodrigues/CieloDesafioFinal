package com.desafioFinal.service;

import com.desafioFinal.repository.IfilaPJ;

import java.util.LinkedList;

import com.desafioFinal.model.pJuridica;
import org.springframework.stereotype.Service;

@Service
public class filaPJ implements IfilaPJ {
    private LinkedList<pJuridica> fila_pj = new LinkedList<>();

    public void addPJ(pJuridica item) {
        fila_pj.addLast(item);
    }

    public pJuridica removerPJ() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return fila_pj.removeFirst();
    }

    public boolean isEmpty() {
        return fila_pj.isEmpty();
    }

    public int size() {
        return fila_pj.size();
    }
}
