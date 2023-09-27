package com.desafioFinal.controller;

import com.desafioFinal.dto.dadosAtualizarPJ;
import com.desafioFinal.dto.dadosCadastroPJ;
import com.desafioFinal.dto.dadosListaPJ;
import com.desafioFinal.model.pJuridica;
import com.desafioFinal.repository.pessoaJuridicaRepository;
import com.desafioFinal.service.filaPJ;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PessoaJuridicaController {

    @Autowired
    private pessoaJuridicaRepository pjRepository;

    @Autowired
    private filaPJ fila;

    @PostMapping("/pessoaPJ")
    public ResponseEntity<pJuridica> cadastrarPJ(@RequestBody @Valid dadosCadastroPJ dados) {
        try {
            var pj = pjRepository.save(new pJuridica(dados));

            //adicionando na lista
            fila.addPJ(pj);

            return new ResponseEntity<>(pj, HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pessoaPJ")
    public ResponseEntity<List<dadosListaPJ>> listarPJ() {
        try {
            List<dadosListaPJ> listaPJ = new ArrayList<dadosListaPJ>();

            listaPJ = pjRepository.findAll().stream().map(dadosListaPJ::new).toList();

            if (listaPJ.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listaPJ, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping("/pessoaPJ/{id}")
    @Transactional
    public ResponseEntity<pJuridica> updatePF(@PathVariable("id") long id, @RequestBody @Valid dadosAtualizarPJ dados) {
        Optional<pJuridica> pfData = pjRepository.findById(id);

        if (pfData.isPresent()) {
            pJuridica pjTemp = new pJuridica();
            return new ResponseEntity<>(pjRepository.save(pjTemp.atualizarInformacoes(dados, id)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pessoaPJ/{id}")
    @Transactional
    public ResponseEntity<HttpStatus> deletePF(@PathVariable("id") long id) {
        try {
            pjRepository.deleteById(id);

            //removendo da lista
            fila.removerPJ();

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
