package com.desafioFinal.controller;

import com.desafioFinal.dto.dadosAtualizarPF;
import com.desafioFinal.dto.dadosCadastroPF;
import com.desafioFinal.dto.dadosListaPF;
import com.desafioFinal.model.pFisica;
import com.desafioFinal.repository.pessoaFisicaRepository;
import com.desafioFinal.service.filaPF;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api")
public class PessoaFisicaController {

    @Autowired
    private pessoaFisicaRepository pfRepository;

    @Autowired
    private filaPF fila;


    @PostMapping("/pessoaPF")
    @Transactional
    public ResponseEntity<pFisica> cadastrarPF(@RequestBody @Valid dadosCadastroPF dados) {
        try {
            List<pFisica> pTemp = new ArrayList<pFisica>();
            pTemp = pfRepository.findByCPF(dados.CPF());

            if (pTemp.isEmpty()) {
                var pf = pfRepository.save(new pFisica(dados));

                //adicionando na lista
                fila.addPF(pf);

                return new ResponseEntity<>(pf, HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(null, HttpStatus.FOUND);
            }

        } catch (Exception e) {

            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pessoaPF")
    public ResponseEntity<List<dadosListaPF>> listarPF() {
        try {
            List<dadosListaPF> listaPF = new ArrayList<dadosListaPF>();

            listaPF = pfRepository.findAll().stream().map(dadosListaPF::new).toList();

            if (listaPF.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listaPF, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pessoaPF/{cpf}")
    @Transactional
    public ResponseEntity<pFisica> procurarPF(@PathVariable("cpf") String cpf) {
        List<pFisica> pTemp = new ArrayList<pFisica>();
        pTemp = pfRepository.findByCPF(cpf);

        if (pTemp.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(pTemp.get(0), HttpStatus.OK);
        }
    }

    @GetMapping("/pessoaPF/{id}")
    @Transactional
    public ResponseEntity<pFisica> procurarPFByID(@PathVariable("id") long id) {
        Optional<pFisica> pTemp = pfRepository.findById(id);

        if (pTemp.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(pTemp.get(), HttpStatus.OK);
        }
    }

    @PutMapping("/pessoaPF/{id}")
    @Transactional
    public ResponseEntity<pFisica> updatePF(@PathVariable("id") long id, @RequestBody @Valid dadosAtualizarPF dados) {
        Optional<pFisica> pfData = pfRepository.findById(id);

        if (pfData.isPresent()) {
            pFisica pfTemp = pfData.get();

            //adicionando na lista
            fila.addPF(pfRepository.save(pfTemp.atualizarInformacoes(dados, id)));

            return new ResponseEntity<>(pfRepository.save(pfTemp.atualizarInformacoes(dados, id)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pessoaPF/{id}")
    @Transactional
    public ResponseEntity<HttpStatus> deletePF(@PathVariable("id") long id) {
        try {
            pfRepository.deleteById(id);
            //removendo da lista
            fila.removerPF();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/fila")
    public boolean isEmpty() {
        return fila.isEmpty();
    }

    @GetMapping("/fila/size")
    public int size() {
        return fila.size();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}


