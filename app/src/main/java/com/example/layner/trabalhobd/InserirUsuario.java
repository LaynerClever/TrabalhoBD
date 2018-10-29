package com.example.layner.trabalhobd;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class InserirUsuario extends AppCompatActivity {

    private EditText edtNome, edtTelefone, edtEmail, edtCPF;
    private String nome, telefone, email, cpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_usuario);

        edtNome = findViewById(R.id.edtNome);
        edtTelefone = findViewById(R.id.edtTelefone);
        edtEmail = findViewById(R.id.edtEmail);
        edtCPF = findViewById(R.id.edtCPF);
    }

    public void salvar(View view){

        nome = edtNome.getText().toString();
        telefone = edtTelefone.getText().toString();
        email = edtEmail.getText().toString();
        cpf = edtCPF.getText().toString();

        UsuarioDAO usuarioDAO = new UsuarioDAO(InserirUsuario.this);
        Usuario usuario = new Usuario(nome,telefone,email,cpf);
        usuarioDAO.insertUsuario(usuario);

        edtNome.getText().clear();
        edtTelefone.getText().clear();
        edtEmail.getText().clear();
        edtCPF.getText().clear();
        Toast.makeText(view.getContext(), "Usuário inserido com sucesso!",Toast.LENGTH_LONG).show();
    }

    //BOTÃO VOLTAR
    public void voltar(View view){
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
