package com.example.projeto1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class AtendimentoActivity extends AppCompatActivity {

    private TextView tvTitulo, tvInfo, tvDescricao;
    private TextInputEditText etSolucao;
    private Spinner spStatus;
    private MaterialButton btnAtualizar;
    private Chamado chamadoAtual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atendimento);

        tvTitulo = findViewById(R.id.tvDetalheTitulo);
        tvInfo = findViewById(R.id.tvDetalheInfo);
        tvDescricao = findViewById(R.id.tvDetalheDescricao);
        etSolucao = findViewById(R.id.etSolucao);
        spStatus = findViewById(R.id.spStatus);
        btnAtualizar = findViewById(R.id.btnAtualizar);

        int chamadoId = getIntent().getIntExtra("CHAMADO_ID", -1);
        if (chamadoId != -1) {
            chamadoAtual = AppDatabase.getInstance(this).chamadoDao().getChamadoById(chamadoId);
            if (chamadoAtual != null) {
                preencherCampos();
            }
        }

        configurarSpinnerStatus();

        btnAtualizar.setOnClickListener(v -> atualizarChamado());

        Button btnVoltarMenu = findViewById(R.id.btnVoltarMenu);
        btnVoltarMenu.setOnClickListener(v -> {
            finish();
        });
    }

    private void configurarSpinnerStatus() {
        String[] statusOpcoes = {"Aberto", "Em Atendimento", "Concluído"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, statusOpcoes);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spStatus.setAdapter(adapter);

        if (chamadoAtual != null) {
            for (int i = 0; i < statusOpcoes.length; i++) {
                if (statusOpcoes[i].equals(chamadoAtual.getStatus())) {
                    spStatus.setSelection(i);
                    break;
                }
            }
        }
    }

    private void preencherCampos() {
        tvTitulo.setText(chamadoAtual.getTitulo());
        tvInfo.setText("Data: " + chamadoAtual.getData() + " | Local: " + chamadoAtual.getLocal() + " | Tipo: " + chamadoAtual.getTipo());
        tvDescricao.setText(chamadoAtual.getDescricao());
        etSolucao.setText(chamadoAtual.getSolucao());
    }

    private void atualizarChamado() {
        if (chamadoAtual == null) return;

        chamadoAtual.setSolucao(etSolucao.getText().toString().trim());
        chamadoAtual.setStatus(spStatus.getSelectedItem().toString());

        AppDatabase.getInstance(this).chamadoDao().update(chamadoAtual);

        Toast.makeText(this, "Chamado atualizado!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
