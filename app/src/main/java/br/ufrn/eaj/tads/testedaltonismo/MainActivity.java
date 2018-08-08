package br.ufrn.eaj.tads.testedaltonismo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*Button teste1 = findViewById(R.id.teste1);
    Button teste2 = findViewById(R.id.teste2);
    Button teste3 = findViewById(R.id.teste3);

    TextView texto1 = findViewById(R.id.texto1);
    TextView texto2 = findViewById(R.id.texto2);
    TextView texto3 = findViewById(R.id.texto3);

    Button verifica = findViewById(R.id.verifica);

   // static final int MY_REQUES = 1;
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button teste1 = findViewById(R.id.teste1);
        Button teste2 = findViewById(R.id.teste2);
        Button teste3 = findViewById(R.id.teste3);

        TextView texto1 = findViewById(R.id.texto1);
        TextView texto2 = findViewById(R.id.texto2);
        TextView texto3 = findViewById(R.id.texto3);

        Button verifica = findViewById(R.id.verifica);

        final int MY_REQUES1 = 1;
        final int MY_REQUES2 = 2;
        final int MY_REQUES3= 3;

        teste1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TesteActivity.class );
                Bundle bundle = new Bundle();

                bundle.putInt("botao",1);
                intent.putExtras(bundle);
                startActivityForResult(intent, MY_REQUES1);
            }
        });

        teste2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TesteActivity.class );
                Bundle bundle = new Bundle();

                bundle.putInt("botao", 2);
                intent.putExtras(bundle);
                startActivityForResult(intent, MY_REQUES2);
            }
        });

        teste3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TesteActivity.class );
                Bundle bundle = new Bundle();

                bundle.putInt("botao", 3);
                intent.putExtras(bundle);
                startActivityForResult(intent, MY_REQUES3);
            }
        });

    }

    /*void Click(View v){

        Intent intent = new Intent(MainActivity.this, TesteActivity.class );
        Bundle bundle = new Bundle();

        if(teste1.getId() == v.getId()){
            bundle.putInt("botao", 1);
            startActivityForResult(intent, MY_REQUES1);
        }
        else if(teste2.getId() == v.getId()){
            bundle.putInt("botao", 2);
            startActivityForResult(intent, MY_REQUES2);
        }
        else{
            bundle.putInt("botao", 3);
            startActivityForResult(intent, MY_REQUES3);
        }
    }*/
}
