package com.desafioFinal.controller;

import com.desafioFinal.dto.dadosAtualizarPF;
import com.desafioFinal.dto.dadosCadastroPF;
import com.desafioFinal.dto.dadosListaPF;
import com.desafioFinal.model.pFisica;
import com.desafioFinal.repository.pessoaFisicaRepository;
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
@RequestMapping
public class PessoaFisicaController {

    @Autowired
    private pessoaFisicaRepository pfRespository;

    @PostMapping("/pessoaPF")
    @Transactional
    public ResponseEntity<pFisica> cadastrarPF(@RequestBody @Valid dadosCadastroPF dados) {
        try {
            var pf = pfRespository.save(new pFisica(dados));

            return new ResponseEntity<>(pf, HttpStatus.CREATED);
        }catch(Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/pessoaPF")
    public ResponseEntity<List<dadosListaPF>> listarPF() {
        try {
            List<dadosListaPF> listaPF = new ArrayList<dadosListaPF>();

            listaPF = pfRespository.findAll().stream().map(dadosListaPF::new).toList();

            if (listaPF.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(listaPF, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/pessoaPF/{id}")
    @Transactional
    public ResponseEntity<pFisica> updatePF(@PathVariable("id") long id, @RequestBody @Valid dadosAtualizarPF dados) {
        Optional<pFisica> pfData = pfRespository.findById(id);

        if (pfData.isPresent()) {
            pFisica pfTemp = pfData.get();

            return new ResponseEntity<>(pfRespository.save(pfTemp.atualizarInformacoes(dados,id)), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pessoaPF/{id}")
    @Transactional
    public ResponseEntity<HttpStatus> deletePF(@PathVariable("id") long id) {
        try {
            pfRespository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }

}


