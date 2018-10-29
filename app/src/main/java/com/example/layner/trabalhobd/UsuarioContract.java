package com.example.layner.trabalhobd;

import android.provider.BaseColumns;

/**
 * Created by Layner on 10/17/2018.
 */

public class UsuarioContract implements BaseColumns {
    private UsuarioContract(){}

    public static final String NOME_TABELA = "usuarios";
    public static final String COLUNA_ID = "_id";
    public static final String COLUNA_NOME = "nome";
    public static final String COLUNA_TELEFONE = "telefone";
    public static final String COLUNA_EMAIL = "email";
    public static final String COLUNA_CPF = "cpf";
}
