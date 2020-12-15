package com.br.purple.model;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pes_id")
    private Long id;

    @NotNull
    @Column(name = "pes_nome")
    private String nome;

    @NotNull
    @Column(name = "pes_cpf_cnpj")
    private String cpfCnpj;

    @NotNull
    @Column(name = "pes_telefone")
    private String telefone;

    @NotNull
    @Column(name = "pes_email")
    private String email;

    @NotNull
    @Column(name = "pes_funcao")
    private String funcao;

    @NotNull
    @Column(name = "pes_login")
    private String login;

    @NotNull
    @Column(name = "pes_senha")
    private String senha;

    @NotNull
    @Column(name = "pes_perfil")
    private String perfil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }
}
