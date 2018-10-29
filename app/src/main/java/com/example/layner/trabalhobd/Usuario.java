package com.example.layner.trabalhobd;

import java.io.Serializable;

/**
 * Created by Layner on 10/17/2018.
 */

public class Usuario implements Serializable {
    private int id;
    private String nome;
    private  String telefone;
    private String email;
    private String CPF;

    public Usuario(){}

    public Usuario(String nome, String telefone, String email, String CPF){
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.CPF = CPF;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
}
