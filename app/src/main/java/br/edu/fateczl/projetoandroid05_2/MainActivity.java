package br.edu.fateczl.projetoandroid05_2;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    /*
     *@author:<Rodrigo Fortunato Martins Neves>
     */
    private EditText etValorBits;
    private TextView tvResultado;
    private Button btnCalcular;
    private Spinner spTipoConvert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etValorBits = findViewById(R.id.etValorBits);
        spTipoConvert= findViewById(R.id.spTipoConvert);
        btnCalcular = findViewById(R.id.btnCalcular);
        tvResultado = findViewById(R.id.tvResultado);

        preencherSpinner();
        btnCalcular.setOnClickListener(e ->converterBits());
    }

    private void preencherSpinner() {
        List<String> lista = new ArrayList<>();
        lista.add("Bytes");
        lista.add("KB");
        lista.add("MB");
        lista.add("GB");
        lista.add("TB");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,lista);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipoConvert.setAdapter(adapter);

    }

    private void converterBits() {
        float valor = Float.parseFloat(etValorBits.getText().toString());
        switch ((String) spTipoConvert.getSelectedItem()){
            case "Bytes":
                tvResultado.setText(String.valueOf(valor / 8 ));
                break;
            case "KB":
                tvResultado.setText(String.valueOf(valor / (8*1024) ));
                break;
            case "MB":
                tvResultado.setText(String.valueOf(valor / (8*(1024 ^ 2)) ));
                break;
            case "GB":
                tvResultado.setText(String.valueOf(valor / (8*(1024 ^ 3)) ));
                break;
            case "TB":
                tvResultado.setText(String.valueOf(valor / ((8*1024 ^ 4)) ));
                break;
            default:

        }
    }





}