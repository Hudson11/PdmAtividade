package br.ufrn.eaj.tads.testedaltonismo;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class TesteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        Button cancelar = findViewById(R.id.cancelar);
        Button ok = findViewById(R.id.ok);
        ImageView imagem = findViewById(R.id.imagem);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });


        Bundle test = getIntent().getExtras();
        final int valor = test.getInt("botao");

        if(valor == 1){
            Log.i("meuapp","Identificou");
            imagem.setImageResource(R.drawable.teste1);
        }
        else if(valor == 2){
            Log.i("meuapp","Identificou");
            imagem.setImageResource(R.drawable.teste2);
        }
        else{
            Log.i("meuapp","Identificou");
            imagem.setImageResource(R.drawable.teste3);
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText digita = findViewById(R.id.digite);
                if (digita.getText().toString().equals("")){
                    Toast.makeText(TesteActivity.this, "Campo vazio", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent intent = new Intent();
                    Bundle data = new Bundle();

                    data.putString("resultado", digita.getText().toString());
                    intent.putExtras(data);

                    setResult(valor, intent);

                    finish();
                }
            }
        });

    }


}
