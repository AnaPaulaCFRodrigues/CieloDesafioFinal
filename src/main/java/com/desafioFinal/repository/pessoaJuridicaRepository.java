package com.desafioFinal.repository;

import com.desafioFinal.model.pJuridica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface pessoaJuridicaRepository  extends JpaRepository<pJuridica, Long> {


}
