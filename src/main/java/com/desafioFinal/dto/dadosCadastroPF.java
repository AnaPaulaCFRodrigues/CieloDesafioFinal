package com.desafioFinal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record dadosCadastroPF(
        @NotBlank
        long CPF,
        @NotBlank
        @Pattern(regexp = "\\d{4}")
        int MCC,
        @NotBlank
        String nomePF,
        @NotBlank
        @Email
        @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
        String emailPF) {
}