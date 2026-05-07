package com.example.projeto1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CadastroActivity extends AppCompatActivity {

    private TextInputEditText etTitulo, etDescricao;
    private TextView tvData;
    private Spinner spLocal;
    private com.google.android.material.button.MaterialButton btnSalvar;
    private android.widget.RadioGroup rgTipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Toolbar toolbar = findViewById(R.id.toolbarCadastro);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar.setNavigationOnClickListener(v -> finish());

        etTitulo = findViewById(R.id.etTitulo);
        etDescricao = findViewById(R.id.etDescricao);
        tvData = findViewById(R.id.tvData);
        spLocal = findViewById(R.id.spLocal);
        rgTipo = findViewById(R.id.rgTipo);
        btnSalvar = findViewById(R.id.btnSalvar);

        String dataAtual = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()).format(new Date());
        tvData.setText("Data: " + dataAtual);

        String[] locais = {"Bloco A", "Bloco B", "Bloco C", "Administrativo", "Outros"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, locais);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLocal.setAdapter(adapter);

        btnSalvar.setOnClickListener(v -> salvarChamado());

        Button btnVoltarMenu = findViewById(R.id.btnVoltarMenu);
        btnVoltarMenu.setOnClickListener(v -> {
                finish();
        });

    }

    private void salvarChamado() {
        String titulo = etTitulo.getText().toString().trim();
        String descricao = etDescricao.getText().toString().trim();
        String local = spLocal.getSelectedItem().toString();
        String data = tvData.getText().toString().replace("Data: ", "");
        
        int selectedTipoId = rgTipo.getCheckedRadioButtonId();
        String tipo = (selectedTipoId == R.id.rbTI) ? "TI" : "Infraestrutura";

        if (titulo.isEmpty() || descricao.isEmpty() || selectedTipoId == -1) {
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        Chamado chamado = new Chamado(titulo, data, descricao, local, tipo, "Aberto");
        AppDatabase.getInstance(this).chamadoDao().insert(chamado);

        Toast.makeText(this, "Chamado registrado com sucesso!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
