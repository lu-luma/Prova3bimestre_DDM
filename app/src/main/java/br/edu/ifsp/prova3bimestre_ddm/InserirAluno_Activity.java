package br.edu.ifsp.prova3bimestre_ddm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//Trabalho feito pelas alunas: Laura Neri Thomaz da Silva e Luiza Maria da Silva
public class InserirAluno_Activity extends AppCompatActivity {
    private EditText inputNome;
    private EditText inputNota1;
    private EditText inputNota2;
    private Button btnEnviar;
    private Button btnCancelar;
    private String nome;
    private double nota1;
    private double nota2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inserir_aluno);
        inputNome = findViewById(R.id.inputNome);
        inputNota1 = findViewById(R.id.inputNota1);
        inputNota2 = findViewById(R.id.inputNota2);
        btnEnviar = findViewById(R.id.btnEnviar);
        btnCancelar = findViewById(R.id.btnCancelar);
        btnEnviar.setOnClickListener(new EscutadorBotaoEnviar());
        btnCancelar.setOnClickListener(new EscutadorBotaoCancelar());
    }
    private class EscutadorBotaoEnviar implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            nome = inputNome.getText().toString();
           // System.out.println(nome);
            nota1 = Double.parseDouble(inputNota1.getText().toString());
            nota2 = Double.parseDouble(inputNota2.getText().toString());
            Aluno a = new Aluno(nome,nota1,nota2);
            Intent i = getIntent();
            i.putExtra("aluno",a);
            setResult(RESULT_OK,i);
            finish();
        }
    }
    private class EscutadorBotaoCancelar implements View.OnClickListener {
        @Override
        public void onClick(View view) {
           finish();
        }
    }
}