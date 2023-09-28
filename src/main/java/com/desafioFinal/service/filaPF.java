package com.desafioFinal.service;

import com.desafioFinal.model.pFisica;
import org.springframework.stereotype.Service;
import java.util.LinkedList;

@Service
public class filaPF {

    private LinkedList<pFisica> fila_pf = new LinkedList<>();

    public void addPJ(pFisica item) {
        fila_pf.addLast(item);
    }

    public pFisica removerPJ() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return fila_pf.removeFirst();
    }

    public boolean isEmpty() {
        return fila_pf.isEmpty();
    }

    public int size() {
        return fila_pf.size();
    }
}
