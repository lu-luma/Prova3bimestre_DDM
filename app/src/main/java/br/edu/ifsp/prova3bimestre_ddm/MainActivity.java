package br.edu.ifsp.prova3bimestre_ddm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
//Trabalho feito pelas alunas: Laura Neri Thomaz da Silva e Luiza Maria da Silva
public class MainActivity extends AppCompatActivity {
    private ListView lista;
    private Button btnInserir;
    // atributo com os textos a serem exibidos na lista
    private ArrayList<Aluno> alunos = new ArrayList<>();

   private AdapterAlunos adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById( R.id.lista );
        btnInserir = findViewById( R.id.btnInserir );
        btnInserir.setOnClickListener(new EscutadorBotaoInserir());
        adaptador = new AdapterAlunos(this, alunos);
        lista.setAdapter(adaptador);
        // configurar a lista com o escutador de cliques comuns
        lista.setOnItemClickListener( new EscutadorLista() );

        // configurar a lista para aceitar cliques longos
        lista.setLongClickable( true );

        // configurar a lista com o escutador de cliques longos
        lista.setOnItemLongClickListener( new EscutadorLista() );


    }
    private class EscutadorBotaoInserir implements View.OnClickListener {
        @Override
        public void onClick(View view) {

            Intent i = new Intent( getApplicationContext(), InserirAluno_Activity.class);
            startActivityForResult(i,1);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        super.onActivityResult(requestCode, resultCode, i);
        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {
                Aluno a = (Aluno) i.getSerializableExtra("aluno");
                alunos.add(a);
                adaptador.notifyDataSetChanged();
            }
        }

    }
    private class EscutadorLista implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            // O parâmetro i é o número do item clicado ...
            Toast.makeText(MainActivity.this, "Dados do aluno \n " + "Nome: "+alunos.get(i).getNome() +"\n"
                    +"Nota1: "+alunos.get(i).getNota1()+"\n"+"Nota2: "+alunos.get(i).getNota2()+"\n"
                    +"Média: "+alunos.get(i).getMedia(),
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
            // remover o item de índice i do ArrayList
            alunos.remove( i );
            // avisar o adapter que o arraylist mudou
            adaptador.notifyDataSetChanged();
            // mensagem informativa
            Toast.makeText(MainActivity.this, "Item apagado!", Toast.LENGTH_LONG).show();
            // receita de bolo: retornar true, indicando que o evento foi tratado.
            // se retornar false, vai querer tratar clique comum também
            return true;
        }
    }


}