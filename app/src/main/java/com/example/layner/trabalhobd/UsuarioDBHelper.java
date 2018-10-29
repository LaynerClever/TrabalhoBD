package com.example.layner.trabalhobd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Layner on 10/17/2018.
 */

public class UsuarioDBHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE = "CREATE TABLE " + UsuarioContract.NOME_TABELA + " ( " +
            UsuarioContract.COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
            UsuarioContract.COLUNA_NOME + " TEXT, " +
            UsuarioContract.COLUNA_TELEFONE + " TEXT, " +
            UsuarioContract.COLUNA_EMAIL + " TEXT, " +
            UsuarioContract.COLUNA_CPF + " TEXT); ";

    private static final String SQL_DELETE = "DROP TABLE IF EXISTS " + UsuarioContract.NOME_TABELA;
    private static final int VERSAO = 20;
    private static final String NOME_DATABASE = "usuarios.db";

    public UsuarioDBHelper(Context context){
        super(context, NOME_DATABASE, null, VERSAO);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL(SQL_DELETE);
        onCreate(sqLiteDatabase);
    }
}
