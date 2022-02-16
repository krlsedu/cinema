package br.com.cursojava.model;

public class Genero {
    private int id;
    private String descricao;
    private int classificacaoEtaria;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Genero{" +
                "descricao='" + descricao + '\'' +
                '}';
    }
}
