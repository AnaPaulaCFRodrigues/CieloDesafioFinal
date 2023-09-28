package com.desafioFinal.repository;

import com.desafioFinal.model.pFisica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.*;

import java.util.List;

public interface pessoaFisicaRepository extends JpaRepository<pFisica, Long> {

    @Query("SELECT pf FROM pfisica pf WHERE pf.CPF = ?1")
    List<pFisica> findByCPF(String cpf);

}
