package com.desafioFinal.repository;

import com.desafioFinal.model.pFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface pessoaFisicaRepository extends JpaRepository<pFisica, Long> {

    List<pFisica> findByCPF(String cpf);

}
