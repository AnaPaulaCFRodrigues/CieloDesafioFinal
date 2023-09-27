package com.desafioFinal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record dadosAtualizarPJ(
        @NotBlank
        long id,
        @NotBlank
        long CNPJ,
        @NotBlank
        String razaoSocial,
        @NotBlank
        @Pattern(regexp = "\\d{4}")
        int MCC,
        @NotBlank
        long CPF,
        @NotBlank
        String nomePJ,
        @NotBlank
        @Email
        @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$")
        String emailPJ
) {
}