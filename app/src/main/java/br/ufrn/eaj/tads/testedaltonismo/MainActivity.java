package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.CheckBox;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    boolean resp1 = false, resp2 = false, resp3 = false;
    String r1,r2,r3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        Boolean salvar = prefs.getBoolean("salvar", false);

        if(salvar){
            r1 = prefs.getString("resposta1","");
            r2 = prefs.getString("resposta2","");
            r3 = prefs.getString("resposta3","");

            CheckBox cb = findViewById(R.id.checkBox);
            cb.setChecked(true);

            reloadTextViews();
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);

        Log.i("SALVOU", "Método foi invocado");

        outState.putString("resposta1",r1);
        outState.putString("resposta2",r2);
        outState.putString("resposta3",r3);
    }

    @Override
    protected void onRestoreInstanceState(Bundle onSaveState){
        super.onRestoreInstanceState(onSaveState);

        Log.i("RESTAUROU","Método invocadc");

        r1 = onSaveState.getString("resposta1");
        r2 = onSaveState.getString("resposta2");
        r3 = onSaveState.getString("resposta3");

        reloadTextViews();
    }

    @Override
    protected void onStop() {
        super.onStop();

        CheckBox cb = findViewById(R.id.checkBox);

        if (cb.isChecked()){
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.putBoolean("salvar", true);
            editor.putString("resposta1", r1);
            editor.putString("resposta2", r2);
            editor.putString("resposta3", r3);

            editor.commit();
        }else{
            SharedPreferences prefs = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();

            editor.remove("salvar");
            editor.remove("resposta1");
            editor.remove("resposta2");
            editor.remove("resposta3");

            editor.commit();
        }
    }

    public void Click(View v){

        Button button1 = findViewById(R.id.teste1);
        Button button2 = findViewById(R.id.teste2);
        Button button3 = findViewById(R.id.teste3);

        if(button1.getId() == v.getId()) {
            Intent intent = new Intent(MainActivity.this, TesteActivity.class);

            intent.putExtra("botao", 1);
            startActivityForResult(intent, 10);
        }
        else if(button2.getId() == v.getId()){
            Intent intent = new Intent(MainActivity.this, TesteActivity.class);

            intent.putExtra("botao", 2);
            startActivityForResult(intent, 11);
        }
        else if(button3.getId() == v.getId()){
            Intent intent = new Intent(MainActivity.this, TesteActivity.class);

            intent.putExtra("botao", 3);
            startActivityForResult(intent, 12);
        }
    }

    public void verifica(View v){
        TextView resultado = findViewById(R.id.resultado);

        if (resp1 == true && resp2 == true && resp3 == true) {
            resultado.setText("PASSOU");
        } else {
            resultado.setText("REPROVADO");
        }
    }

    private void reloadTextViews() {
        TextView tv1 = findViewById(R.id.texto1);
        TextView tv2 = findViewById(R.id.texto2);
        TextView tv3 = findViewById(R.id.texto3);

        tv1.setText(r1);
        tv2.setText(r2);
        tv3.setText(r3);
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
                    resp1 = true;
                    r1 = texto.getText().toString();
                }
            } else if (requestCode == 11) {
                TextView texto = findViewById(R.id.texto2);
                texto.setText(valor);
                if (valor.equals("29")) {
                    resp2 = true;
                    r2 = texto.getText().toString();
                }
            } else {
                TextView texto = findViewById(R.id.texto3);
                texto.setText(valor);
                if (valor.equals("74")) {
                    resp3 = true;
                    r3 = texto.getText().toString();
                }
            }
        }
    }
}

