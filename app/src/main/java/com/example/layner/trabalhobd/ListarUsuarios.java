package com.example.layner.trabalhobd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ListarUsuarios extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);

        UsuarioDAO usuarioDAO = new UsuarioDAO(ListarUsuarios.this);

        ArrayList<Usuario> usuarios = usuarioDAO.retrieveAllUsuarios();
        for (int i = 0; i < usuarios.size(); i++){
            Usuario usuario = usuarios.get(i);
        }

        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(usuarios, ListarUsuarios.this);

        RecyclerView lista = findViewById(R.id.lista);

        lista.setAdapter(usuarioAdapter);

        //LINEAR
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ListarUsuarios.this,
                LinearLayoutManager.VERTICAL, false);

        lista.addItemDecoration(new DividerItemDecoration(ListarUsuarios.this, DividerItemDecoration.VERTICAL));
        lista.setLayoutManager(linearLayoutManager);
    }
}
