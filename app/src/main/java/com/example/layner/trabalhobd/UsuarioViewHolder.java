package com.example.layner.trabalhobd;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Layner on 10/17/2018.
 */

public class UsuarioViewHolder extends RecyclerView.ViewHolder {
    public TextView tvResultadoNome;
    public TextView tvResultadoTelefone;
    public TextView tvResultadoEmail;
    public TextView tvResultadoCPF;
    public TextView tvResultadoId;
    public Button btEditar;
    public Button btExcluir;

    public UsuarioViewHolder(View itemView) {
        super(itemView);
        this.tvResultadoNome =itemView.findViewById(R.id.tvResultadoNome);
        this.tvResultadoTelefone =itemView.findViewById(R.id.tvResultadoTelefone);
        this.tvResultadoEmail =itemView.findViewById(R.id.tvEditarEmail);
        this.tvResultadoCPF =itemView.findViewById(R.id.tvResultadoCPF);
        this.tvResultadoId =itemView.findViewById(R.id.tvResultadoId);
        this.btEditar =itemView.findViewById(R.id.btEditar);
        this.btExcluir =itemView.findViewById(R.id.btExcluir);
    }
}
