package com.desafioFinal.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.br.CPF;

public record dadosCadastroPF(
        @NotBlank(message = "Campo Não Informado!!!")
        @CPF(message = "CPF Inválido!!!")
        String CPF,
        @NotBlank(message = "Campo Não Informado!!!")
        @Pattern(regexp = "\\d{1,4}", message="Máximo de 4 dígitos")
        String MCC,
        @NotBlank(message = "Campo Não Informado!!!")
        String nomePF,
        @NotBlank(message = "Campo Não Informado!!!")
        @Email(message = "Email inválido!!!")
        @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$", message="Email inválido!!!")
        String emailPF) {
}