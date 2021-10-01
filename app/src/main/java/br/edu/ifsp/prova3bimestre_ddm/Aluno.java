package br.edu.ifsp.prova3bimestre_ddm;

import java.io.Serializable;

public class Aluno implements Serializable {
    private String nome;
    private double nota1;
    private  double nota2;
    private double media;

    public Aluno(String nome, double nota1, double nota2) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double calculaMedia(double n1, double n2){
        setMedia((n1+n2)/2);
        return media;
    }
}
