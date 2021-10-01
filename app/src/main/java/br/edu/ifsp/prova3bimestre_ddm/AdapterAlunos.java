package br.edu.ifsp.prova3bimestre_ddm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterAlunos extends ArrayAdapter<Aluno> {
    private Context context;
    private ArrayList<Aluno> alunos;


    public AdapterAlunos(Context context, ArrayList<Aluno> alunos) {

        // super:
        // contexto, layout do item da lista, arraylist com os itens
        super(context, R.layout.item_lista, alunos);

        // guarda o contexto no atributo correspondente
        this.context = context;

        // guarda o arraylist com os itens no atributo correspondente
        this.alunos = alunos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // recuperar um objeto "inflador” de layouts...
        LayoutInflater li = LayoutInflater.from(parent.getContext());

        // "inflando" o xml do item da lista, gerando sua visualização (view)
        View itemView = li.inflate(R.layout.item_lista, parent, false);

        // pegando os objetos gráficos dentro do xml do item da lista
        TextView lblNomeAluno = itemView.findViewById(R.id.lblNomeAluno);
        TextView lblNota1 = itemView.findViewById(R.id.lblNota1);
        TextView lblNota2 = itemView.findViewById(R.id.lblNota2);
        TextView lblMedia = itemView.findViewById(R.id.lblMedia);

        // colocando dados neste item
        // o objeto esta no índice 'position'
        lblNomeAluno.setText(alunos.get(position).getNome());
        lblNota1.setText(Double.toString(alunos.get(position).getNota1()));
        lblNota2.setText(Double.toString(alunos.get(position).getNota2()));
        lblMedia.setText(Double.toString(alunos.get(position).calculaMedia(alunos.get(position).getNota1(),alunos.get(position).getNota2())));


        // a view do item da lista está montada!!
        // é só devolver
        return itemView;
    }

}
