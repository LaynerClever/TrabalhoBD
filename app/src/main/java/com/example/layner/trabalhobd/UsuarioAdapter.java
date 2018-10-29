package com.example.layner.trabalhobd;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Layner on 10/17/2018.
 */

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioViewHolder> {
    private List<Usuario> usuarios;
    private Context context;

    public UsuarioAdapter(List<Usuario> usuarios, Context context) {
        this.usuarios = usuarios;
        this.context = context;
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View linha = LayoutInflater.from(this.context)
                .inflate(R.layout.item_layout, parent, false);
        UsuarioViewHolder linhaViewHolder = new UsuarioViewHolder(linha);

        return linhaViewHolder;
    }

    @Override
    public void onBindViewHolder(UsuarioViewHolder holder, final int position) {
       final Usuario usuario = usuarios.get(position);
        holder.tvResultadoId.setText(String.valueOf(usuario.getId()));
        holder.tvResultadoNome.setText(usuario.getNome());
        holder.tvResultadoTelefone.setText(usuario.getTelefone());
        holder.tvResultadoEmail.setText(usuario.getEmail());
        holder.tvResultadoCPF.setText(usuario.getCPF());

        holder.btEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), EditarUsuario.class);
                intent.putExtra("usuario", (Serializable) usuario);
                view.getContext().startActivity(intent);
            }
        });

        holder.btExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Usuario usuario = usuarios.get(position);
                UsuarioDAO usuarioDAO = new UsuarioDAO(view.getContext());
                boolean isSuccess = usuarioDAO.deleteUsuario(usuario.getId());
                if(isSuccess) {
                    usuarioDAO.deleteUsuario(usuario.getId());
                    Toast.makeText(view.getContext(), "Usuário removido com sucesso!",Toast.LENGTH_LONG).show();
                }else{
                    Log.d("Error","Erro ao excluir o usuário!");
                }
                usuarios.remove(position);
                notifyDataSetChanged();
                notifyItemRemoved(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }
}
