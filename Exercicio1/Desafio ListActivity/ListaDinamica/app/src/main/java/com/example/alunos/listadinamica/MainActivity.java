package com.example.alunos.listadinamica;

import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.alunos.listadinamica.model.Pessoa;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public ArrayList<Pessoa> vetor = new ArrayList<Pessoa>();

    public void showList(View v) {
        Intent it = new Intent(this, mostraListaDinamica.class);
        it.putParcelableArrayListExtra("vetor", vetor);
        startActivity(it);

    }

    public boolean excecao(String s) {

        if(s.compareTo("")==0) {
            return false;
        }
        return true;
    }

    public void cadastrar(View v) {

        TextView texto = (TextView) findViewById(R.id.textExcecao);

        texto.setText("");

        EditText nome1 = (EditText) findViewById(R.id.editNome);
        EditText telefone1 = (EditText) findViewById(R.id.editTelefone);
        EditText idade1 = (EditText) findViewById(R.id.editIdade);

        String nome = nome1.getText().toString();
        String telefone = telefone1.getText().toString();
        String age = idade1.getText().toString();

        int idade = Integer.parseInt(age);

        if (excecao(nome) && excecao(telefone) && excecao(age)) {
            vetor.add(new Pessoa(nome, telefone, idade));
        } else {
            texto.setText("Há campo(s) inválido(s)");
        }

        nome1.getText().clear();
        telefone1.getText().clear();
        idade1.getText().clear();

    }
}
