package com.eduardogroders;


public class Matricula {

    Aluno aluno = new Aluno();
    Disciplina disciplina = new Disciplina();
    DisciplinaPratica disciplinaPratica = new DisciplinaPratica();


    private short anoLetivo;
    private byte serie;
    private float notaPrimeiroBimestre;
    private float notaSegundoBimestre;
    private float notaTerceiroBimestre;
    private float notaQuartoBimestre;
    private boolean aprovado;
    private float media;


    private final int MAX_ALUNO = 10;
    private final int MAX_DISCIPLINA = 5;
    private final int MAX_MATRICULA = 30;


    public short getAnoLetivo() { return anoLetivo; }

    public void setAnoLetivo(short anoLetivo) {
        this.anoLetivo = anoLetivo;
    }



    public byte getSerie() { return serie; }

    public void setSerie(byte serie) {
        this.serie = serie;
    }



    public float getNotaPrimeiroBimestre() { return notaPrimeiroBimestre; }

    public void setNotaPrimeiroBimestre(float notaPrimeiroBimestre) {
        this.notaPrimeiroBimestre = notaPrimeiroBimestre;
    }



    public float getNotaSegundoBimestre() { return notaSegundoBimestre; }

    public void setNotaSegundoBimestre(float notaSegundoBimestre) {
        this.notaSegundoBimestre = notaSegundoBimestre;
    }



    public float getNotaTerceiroBimestre() { return notaTerceiroBimestre; }

    public void setNotaTerceiroBimestre(float notaTerceiroBimestre) {
        this.notaTerceiroBimestre = notaTerceiroBimestre;
    }




    public float getNotaQuartoBimestre() { return notaQuartoBimestre; }

    public void setNotaQuartoBimestre(float notaQuartoBimestre) {
        this.notaQuartoBimestre = notaQuartoBimestre;
    }




    public Boolean getAprovado() { return aprovado; }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }


    public float getMedia() { return media; }


    public Aluno getAluno() { return aluno; }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Disciplina getDisciplina() { return disciplina; }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public DisciplinaPratica getDisciplinaPratica() { return disciplinaPratica; }

    public void setDisciplinaPratica(DisciplinaPratica disciplinaPratica) {
        this.disciplinaPratica = disciplinaPratica;
    }

    public Matricula() {
        this.anoLetivo = '\u0000';
        this.serie = '\u0000';
        this.notaPrimeiroBimestre = 0.0f;
        this.notaSegundoBimestre = 0.0f;
        this.notaTerceiroBimestre = 0.0f;
        this.notaQuartoBimestre = 0.0f;
        this.aprovado = false;
        this.aluno = null;
        this.disciplina = null;
        this.disciplinaPratica = null;
    }


    public Matricula(short anoLetivo, byte serie, float notaPrimeiroBimestre, float notaSegundoBimestre, float notaTerceiroBimestre, float notaQuartoBimestre, Boolean aprovado) {
        this.anoLetivo = anoLetivo;
        this.serie = serie;
        this.notaPrimeiroBimestre = notaPrimeiroBimestre;
        this.notaSegundoBimestre = notaSegundoBimestre;
        this.notaTerceiroBimestre = notaTerceiroBimestre;
        this.notaQuartoBimestre = notaQuartoBimestre;
        this.aprovado = aprovado;
        this.aluno = aluno;
        this.disciplina = disciplina;
        this.disciplinaPratica = disciplinaPratica;
    }

    public float maiorNota(){

        if(notaPrimeiroBimestre > notaSegundoBimestre && notaPrimeiroBimestre > notaTerceiroBimestre && notaPrimeiroBimestre > notaQuartoBimestre){
            return notaPrimeiroBimestre;
        }
        else if(notaSegundoBimestre > notaPrimeiroBimestre && notaSegundoBimestre > notaTerceiroBimestre && notaSegundoBimestre > notaQuartoBimestre){
            return notaSegundoBimestre;
        }
        else if(notaTerceiroBimestre > notaPrimeiroBimestre && notaTerceiroBimestre > notaSegundoBimestre && notaTerceiroBimestre > notaQuartoBimestre){
            return notaTerceiroBimestre;
        }
        else {
            return notaQuartoBimestre;
        }
    }


    public float menorNota(){

        if(notaPrimeiroBimestre < notaSegundoBimestre && notaPrimeiroBimestre < notaTerceiroBimestre && notaPrimeiroBimestre < notaQuartoBimestre){
            return notaPrimeiroBimestre;
        }
        else if(notaSegundoBimestre < notaPrimeiroBimestre && notaSegundoBimestre < notaTerceiroBimestre && notaSegundoBimestre < notaQuartoBimestre){
            return notaSegundoBimestre;
        }
        else if(notaTerceiroBimestre < notaPrimeiroBimestre && notaTerceiroBimestre < notaSegundoBimestre && notaTerceiroBimestre < notaQuartoBimestre){
            return notaTerceiroBimestre;
        }
        else {
            return notaQuartoBimestre;
        }
    }


    public float media (float[] notas){

        float media;
        float somaNotas = 0;

        for(int i = 0; i < notas.length; i++){
            somaNotas += notas[i];
        }
        media = somaNotas / 4;
        return somaNotas / 4;
    }

    public float mediaPonderada(float[] notas, int[] pesos){

        float somaNotas = 0;
        float somaPesos = 0;

        for(int i = 0; i < notas.length; i++){
            somaNotas += notas[i] * pesos[i];
            somaPesos += pesos[i];
        }

        return somaNotas / somaPesos;
    }


    public void verifica(){

        if( getMedia() >= 7.0){
            aprovado = true;
        }
        else{
            aprovado = false;
        }
    }

}
