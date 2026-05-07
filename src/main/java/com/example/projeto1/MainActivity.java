package com.example.projeto1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView tvContadorAbertos;
    private MaterialButton btnNovoChamado, btnConsultarChamados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvContadorAbertos = findViewById(R.id.tvContadorAbertos);
        btnNovoChamado = findViewById(R.id.btnNovoChamado);
        btnConsultarChamados = findViewById(R.id.btnConsultarChamados);

        btnNovoChamado.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intent);
        });

        btnConsultarChamados.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListagemActivity.class);
            startActivity(intent);
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizarDashboard();
    }

    private void atualizarDashboard() {
        int count = AppDatabase.getInstance(this).chamadoDao().getOpenChamadosCount();
        tvContadorAbertos.setText(String.valueOf(count));
    }
}
