package com.example.medidas;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //declarar uma variavel para cada componente da tela que vamos usar, sao os edittext

    EditText txtUltimoPeso;
    EditText txtAltura;
    EditText txtCintura;
    EditText txtBusto;
    EditText txtQuadril;
    EditText txtBiceps;
    EditText txtQuadriceps;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // o txtdentro do parentestes busca do .xml
        txtUltimoPeso =findViewById(R.id.txtUltimoPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtCintura = findViewById(R.id.txtCintura);
        txtBusto = findViewById(R.id.txtBusto);
        txtQuadril = findViewById(R.id.txtQuadril);
        txtBiceps = findViewById(R.id.txtBiceps);
        txtQuadriceps = findViewById(R.id.txtQuadriceps);
        this.Carregar();
    }

    // criar o listenr do evento salvar

    public void onBotaoSalvar(View v){

        // conjunto de dados sera salvo com MinhasMedidas
        // grava as coisas la dentro

        SharedPreferences preferences = getSharedPreferences("MinhasMedidas", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        // gravar string, nome qual o nome? Edilaine
        editor.putString("Nome", "Edilaine");
        //o txtparcial1 dessa tela busca a variavel global acima o parcial1 é o nome do campo
        editor.putString("Último Peso",txtUltimoPeso.getText().toString());
        editor.putString("Altura",txtAltura.getText().toString());
        editor.putString("Cintura", txtCintura.getText().toString());
        editor.putString("Busto", txtBusto.getText().toString());
        editor.putString("Quadril", txtQuadril.getText().toString());
        editor.putString("Biceps", txtBiceps.getText().toString());
        editor.putString("Quadriceps", txtQuadriceps.getText().toString());
        editor.apply();
    }

    public void Carregar(){// nao recebe o view pq nao é botao, ele carrega do oncreate

        SharedPreferences preferences = getSharedPreferences("MinhasMedidas", MODE_PRIVATE);
        String UltimoPeso = preferences.getString("Último Peso","0");
        String altura = preferences.getString("Altura","0");
        String cintura = preferences.getString("Cintura","0");
        String busto = preferences.getString("Busto", "0");
        String quadril = preferences.getString("Quadril", "0");
        String biceps = preferences.getString("Biceps", "0");
        String quadriceps = preferences.getString("Quadriceps", "0");
        txtUltimoPeso.setText(UltimoPeso);
        txtAltura.setText(altura);
        txtCintura.setText(cintura);
        txtBusto.setText(busto);
        txtQuadril.setText(quadril);
        txtBiceps.setText(biceps);
        txtQuadriceps.setText(quadriceps);


    }
}
