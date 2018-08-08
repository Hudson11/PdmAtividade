package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    int cont = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button teste1 = findViewById(R.id.teste1);
        Button teste2 = findViewById(R.id.teste2);
        Button teste3 = findViewById(R.id.teste3);

        Button verifica = findViewById(R.id.verifica);

        teste1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TesteActivity.class);
      
                intent.putExtra("botao", 1);
                startActivityForResult(intent, 10);
            }
        });

        teste2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TesteActivity.class);

                intent.putExtra("botao", 2);
                startActivityForResult(intent, 11);
            }
        });

        teste3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TesteActivity.class);

                intent.putExtra("botao", 3);
                startActivityForResult(intent, 12);
            }
        });

        verifica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView resultado = findViewById(R.id.resultado);

                if (cont == 3) {
                    resultado.setText("PASSOU");
                } else {
                    resultado.setText("REPROVADO");
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        Bundle bundle = data.getExtras();
        String valor;

        if (bundle != null) {
            valor = bundle.getString("resultado");
            if (requestCode == 10) {
                TextView texto = findViewById(R.id.texto1);
                texto.setText(valor);
                if (valor.equals("2")) {
                    cont++;
                }
            } else if (requestCode == 11) {
                TextView texto = findViewById(R.id.texto2);
                texto.setText(valor);
                if (valor.equals("29")) {
                    cont++;
                }
            } else {
                TextView texto = findViewById(R.id.texto3);
                texto.setText(valor);
                if (valor.equals("74")) {
                    cont++;
                }
            }
        }
    }
}

