package com.desafioFinal.model;

import com.desafioFinal.dto.dadosAtualizarPF;
import com.desafioFinal.dto.dadosCadastroPF;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pessoaFisica")
@Entity(name = "pfisica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class pFisica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int MCC;

    private long CPF;

    private String nomePF;

    private String emailPF;


    public pFisica(dadosCadastroPF dados) {
        this.CPF = dados.CPF();
        this.emailPF = dados.emailPF();
        this.MCC = dados.MCC();
        this.nomePF = dados.nomePF();
    }

    public pFisica(dadosAtualizarPF dados) {
        this.CPF = dados.CPF();
        this.emailPF = dados.emailPF();
        this.MCC = dados.MCC();
        this.nomePF = dados.nomePF();
    }

    public pFisica atualizarInformacoes(dadosAtualizarPF dados, long id) {

        pFisica pf = new pFisica();

        pf.id = id;
        pf.CPF = dados.CPF();
        pf.emailPF = dados.emailPF();
        pf.MCC = dados.MCC();
        pf.nomePF = dados.nomePF();

        return pf;
    }
}
