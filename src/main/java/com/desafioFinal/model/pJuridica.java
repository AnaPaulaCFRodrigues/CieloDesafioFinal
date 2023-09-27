package com.desafioFinal.model;

import com.desafioFinal.dto.dadosAtualizarPJ;
import com.desafioFinal.dto.dadosCadastroPJ;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "pessoaJuridica")
@Entity(name = "pjuridica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class pJuridica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int MCC;

    private long CNPJ;

    private long CPF;

    private String nomePJ;

    private String emailPJ;

    private String razaoSocial;

    public pJuridica(dadosCadastroPJ dados) {
        this.CPF = dados.CPF();
        this.CNPJ = dados.CNPJ();
        this.MCC = dados.MCC();
        this.emailPJ = dados.emailPJ();
        this.nomePJ = dados.nomePJ();
        this.razaoSocial = dados.razaoSocial();
    }

    public pJuridica atualizarInformacoes(dadosAtualizarPJ dados, long id) {

        pJuridica pj = new pJuridica();

        pj.id = id;
        pj.CPF = dados.CPF();
        pj.CNPJ = dados.CNPJ();
        pj.MCC = dados.MCC();
        pj.emailPJ = dados.emailPJ();
        pj.nomePJ = dados.nomePJ();
        pj.razaoSocial = dados.razaoSocial();

        return pj;
    }
}
