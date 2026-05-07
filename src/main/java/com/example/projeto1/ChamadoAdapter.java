package com.example.projeto1;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChamadoAdapter extends RecyclerView.Adapter<ChamadoAdapter.ChamadoViewHolder> {

    private List<Chamado> chamados;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Chamado chamado);
    }

    public ChamadoAdapter(List<Chamado> chamados, OnItemClickListener listener) {
        this.chamados = chamados;
        this.listener = listener;
    }

    public void setChamados(List<Chamado> chamados) {
        this.chamados = chamados;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ChamadoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_chamado, parent, false);
        return new ChamadoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChamadoViewHolder holder, int position) {
        Chamado chamado = chamados.get(position);
        holder.bind(chamado, listener);
    }

    @Override
    public int getItemCount() {
        return chamados.size();
    }

    static class ChamadoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvData, tvTipo;
        ImageView ivIcone;
        View vStatus;

        public ChamadoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvItemTitulo);
            tvData = itemView.findViewById(R.id.tvItemData);
            tvTipo = itemView.findViewById(R.id.tvItemTipo);
            ivIcone = itemView.findViewById(R.id.ivIconeTipo);
            vStatus = itemView.findViewById(R.id.vStatusColor);
        }

        public void bind(final Chamado chamado, final OnItemClickListener listener) {
            tvTitulo.setText(chamado.getTitulo());
            tvData.setText(chamado.getData());
            tvTipo.setText(chamado.getTipo());

            if ("TI".equals(chamado.getTipo())) {
                ivIcone.setImageResource(android.R.drawable.ic_menu_gallery); // Placeholder for computer icon
            } else {
                ivIcone.setImageResource(android.R.drawable.ic_menu_manage); // Placeholder for wrench icon
            }

            // Cores de Status: Vermelho (Aberto), Amarelo (Em Atendimento), Verde (Concluído)
            switch (chamado.getStatus()) {
                case "Aberto":
                    vStatus.setBackgroundColor(Color.RED);
                    break;
                case "Em Atendimento":
                    vStatus.setBackgroundColor(Color.YELLOW);
                    break;
                case "Concluído":
                    vStatus.setBackgroundColor(Color.GREEN);
                    break;
            }

            itemView.setOnClickListener(v -> listener.onItemClick(chamado));
        }
    }
}
