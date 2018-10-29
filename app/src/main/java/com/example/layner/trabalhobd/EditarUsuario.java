package com.example.layner.trabalhobd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;

public class EditarUsuario extends AppCompatActivity {

    private String nome, telefone, email, cpf;
    private EditText edtEditarNome, edtEditarTelefone, edtEditarEmail, edtEditarCpf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_usuario);

        Usuario usuario = (Usuario) getIntent().getSerializableExtra("usuario");

        edtEditarNome = findViewById(R.id.edtEditarNome);
        edtEditarNome.setText(usuario.getNome());


        edtEditarTelefone = findViewById(R.id.edtEditarTelefone);
        edtEditarTelefone.setText(usuario.getTelefone());


        edtEditarEmail = findViewById(R.id.edtEditarEmail);
        edtEditarEmail.setText(usuario.getEmail());


        edtEditarCpf = findViewById(R.id.edtEditarCPF);
        edtEditarCpf.setText(usuario.getCPF());
    }

    public void concluirEditar(View view){
        nome = edtEditarNome.getText().toString();
        telefone = edtEditarTelefone.getText().toString();
        email = edtEditarEmail.getText().toString();
        cpf = edtEditarCpf.getText().toString();

        UsuarioDAO usuarioDAO = new UsuarioDAO(EditarUsuario.this);
        Usuario usuario = new Usuario(nome,telefone,email,cpf);
        usuarioDAO.editUsuario(usuario);
        Toast.makeText(view.getContext(), "Usuário editado com sucesso!",Toast.LENGTH_LONG).show();
    }

    //BOTÃO CANCELAR
    public void cancelar(View view){
        Intent intent = new Intent(getApplicationContext(), ListarUsuarios.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
