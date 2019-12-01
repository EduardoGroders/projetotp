package com.eduardogroders;

public class Disciplina {

    private String nome;
    private int codigoDisciplina = 0;
    private int cargaHorariaGeral;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoDisciplina() { return codigoDisciplina; }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCargaHorariaGeral() { return cargaHorariaGeral; }

    public void setCargaHorariaGeral(int cargaHorariaGeral) {
        this.cargaHorariaGeral = cargaHorariaGeral;
    }

    public Disciplina(){
        this.nome = "";
        this.cargaHorariaGeral = 0;
        this.codigoDisciplina = 0;
    }

    public Disciplina(String nome, int cargaHorariaGeral, int codigoDisciplina){
        this.nome = nome;
        this.cargaHorariaGeral = cargaHorariaGeral;
        this.codigoDisciplina = codigoDisciplina;
    }
}
