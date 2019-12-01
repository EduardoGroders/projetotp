package com.eduardogroders;


import java.util.*;
import java.text.*;


public class Aluno {


    private String nome;
    private String sobrenome;
    private char sexo;
    private int idAluno = 0;
    private int idade;
    private Calendar dataNascimento;


    public String getNome() { return nome; }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getSobrenome() { return sobrenome; }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }


    public char getSexo() { return sexo; }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }


    public int getIdAluno() { return idAluno; }



    public int getIdade(int idade) { return this.idade; }

    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }

    public void setIdade(int idade) {
        if(idade >= 0)
            this.idade = idade;
    }

    public Calendar getDataNascimento() { return dataNascimento; }



    public void setDataNascimento(Calendar dataNascimento) {
        if(dataNascimento != null){
            this.dataNascimento = dataNascimento;
            calculaIdade();
        }
    }


    public Aluno(){
        this.nome = "";
        this.sobrenome = "";
        this.sexo = '\u0000';
        this.dataNascimento = null;
        this.idAluno = 0;
    }


    public Aluno(String nome, String sobrenome, char sexo,  Calendar dataNascimento, int idAluno){
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.idAluno = idAluno;
    }



    private int calculaIdade(){

        Calendar today = Calendar.getInstance();

        int idade = today.get(Calendar.YEAR) - dataNascimento.get(Calendar.YEAR);

        dataNascimento.add(Calendar.YEAR, idade);

        if (today.before(dataNascimento)) {
            idade--;
        }

        this.idade = idade;
        return this.idade;

    }



}
