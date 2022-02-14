package br.com.cursojava.model;

public class Genero {
    private String descricao;

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
