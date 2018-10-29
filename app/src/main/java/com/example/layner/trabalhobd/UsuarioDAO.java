package com.example.layner.trabalhobd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Layner on 10/17/2018.
 */

public class UsuarioDAO {
    private UsuarioDBHelper usuarioDBHelper;

    public UsuarioDAO(Context context) {
        this.usuarioDBHelper = new UsuarioDBHelper(context);
    }

    public boolean insertUsuario(Usuario usuario){
        SQLiteDatabase sqLiteDatabase = usuarioDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        //contentValues.put(UsuarioContract.COLUNA_ID, usuario.getId());
        contentValues.put(UsuarioContract.COLUNA_NOME, usuario.getNome());
        contentValues.put(UsuarioContract.COLUNA_TELEFONE, usuario.getTelefone());
        contentValues.put(UsuarioContract.COLUNA_EMAIL, usuario.getEmail());
        contentValues.put(UsuarioContract.COLUNA_CPF, usuario.getCPF());

        long affectedRows = sqLiteDatabase.insert(UsuarioContract.NOME_TABELA,null, contentValues);

        if (affectedRows > 1){
            Log.d("DB","Usuário " + usuario.getNome() + " criado com sucesso!");
        }

        if (affectedRows == -1) return false;
        return true;
    }

    public boolean deleteUsuario(int id){
        SQLiteDatabase sqLiteDatabase = usuarioDBHelper.getWritableDatabase();

        String where = UsuarioContract.COLUNA_ID + " = ?";
        String[] valuesWhere = {String.valueOf(id)};


        long affectedRows  = sqLiteDatabase.delete(UsuarioContract.NOME_TABELA, where, valuesWhere);
        if (affectedRows == -1) return false;
        return true;
    }

    public boolean editUsuario (Usuario usuario){
        SQLiteDatabase sqLiteDatabase = usuarioDBHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(UsuarioContract.COLUNA_NOME, usuario.getNome());
        contentValues.put(UsuarioContract.COLUNA_TELEFONE, usuario.getTelefone());
        contentValues.put(UsuarioContract.COLUNA_EMAIL, usuario.getEmail());
        contentValues.put(UsuarioContract.COLUNA_CPF, usuario.getCPF());

        String where = UsuarioContract.COLUNA_ID + " = ?";
        String[] valuesWhere = {String.valueOf(usuario.getId())};

        // CORRIGIR EDIÇÃO AQUI
        long affectedRows  = sqLiteDatabase.update(UsuarioContract.NOME_TABELA, contentValues, where, valuesWhere);
        if (affectedRows == -1) return false;
        return true;
    }

    public ArrayList<Usuario> retrieveAllUsuarios(){
        SQLiteDatabase sqLiteDatabase = usuarioDBHelper.getReadableDatabase();

        String[] columns = {UsuarioContract.COLUNA_ID, UsuarioContract.COLUNA_NOME,
                UsuarioContract.COLUNA_TELEFONE, UsuarioContract.COLUNA_EMAIL,
                UsuarioContract.COLUNA_CPF};

        String order = UsuarioContract.COLUNA_NOME + " ASC";
        Cursor result = sqLiteDatabase.query(UsuarioContract.NOME_TABELA,
                columns, null, null, null, null, order);

        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        while (result.moveToNext()){
            Usuario usuario = new Usuario();
            usuario.setId(result.getInt(result.getColumnIndex(UsuarioContract.COLUNA_ID)));
            usuario.setNome(result.getString(result.getColumnIndex(UsuarioContract.COLUNA_NOME)));
            usuario.setTelefone(result.getString(result.getColumnIndex(UsuarioContract.COLUNA_TELEFONE)));
            usuario.setEmail(result.getString(result.getColumnIndex(UsuarioContract.COLUNA_EMAIL)));
            usuario.setCPF(result.getString(result.getColumnIndex(UsuarioContract.COLUNA_CPF)));
            usuarios.add(usuario);
        }
        result.close();
        sqLiteDatabase.close();
        return usuarios;
    }
}
