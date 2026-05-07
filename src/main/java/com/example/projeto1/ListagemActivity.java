package com.example.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.ChipGroup;

import java.util.List;

public class ListagemActivity extends AppCompatActivity {

    private RecyclerView rvChamados;
    private ChamadoAdapter adapter;
    private ChipGroup chipGroupStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        rvChamados = findViewById(R.id.rvChamados);
        chipGroupStatus = findViewById(R.id.chipGroupStatus);

        rvChamados.setLayoutManager(new LinearLayoutManager(this));
        
        adapter = new ChamadoAdapter(null, chamado -> {
            Intent intent = new Intent(ListagemActivity.this, AtendimentoActivity.class);
            intent.putExtra("CHAMADO_ID", chamado.getId());
            startActivity(intent);
        });
        rvChamados.setAdapter(adapter);

        chipGroupStatus.setOnCheckedStateChangeListener((group, checkedIds) -> {
            carregarChamados();
        });

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregarChamados();
    }

    private void carregarChamados() {
        List<Chamado> lista;
        int checkedId = chipGroupStatus.getCheckedChipId();

        if (checkedId == R.id.chipAbertos) {
            lista = AppDatabase.getInstance(this).chamadoDao().getChamadosByStatus("Aberto");
        } else if (checkedId == R.id.chipEmAtendimento) {
            lista = AppDatabase.getInstance(this).chamadoDao().getChamadosByStatus("Em Atendimento");
        } else if (checkedId == R.id.chipConcluidos) {
            lista = AppDatabase.getInstance(this).chamadoDao().getChamadosByStatus("Concluído");
        } else {
            lista = AppDatabase.getInstance(this).chamadoDao().getAllChamados();
        }

        adapter.setChamados(lista);
    }
}
