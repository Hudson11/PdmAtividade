package br.ufrn.eaj.tads.testedaltonismo;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageSwitcher;
import android.widget.ImageView;

public class TesteActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);

        Button cancelar = findViewById(R.id.cancelar);
        Button ok = findViewById(R.id.ok);

        EditText digita = findViewById(R.id.digite);

        ImageView imagem = findViewById(R.id.imagem);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Bundle test = getIntent().getExtras();

        if(test.getInt("botao") == 1){
            //Log.i("meuapp","Identificou");
            imagem.setImageResource(R.id.teste1);
        }
        else if(test.getInt("botao") == 2){
            //Log.i("meuapp","Identificou");
            imagem.setImageDrawable(getResources().getDrawable(R.id.teste2));
        }
        else{
            //Log.i("meuapp","Identificou");
            imagem.setImageDrawable(getResources().getDrawable(R.id.teste3));
        }
    }
}
