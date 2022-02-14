package br.com.cursojava.model;

import java.util.ArrayList;
import java.util.List;

public class Filme {
    private String titulo;
    private Integer duracaoEmMinutos;
    private Genero genero;
    private List<Ator> atores = new ArrayList<>();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ", genero=" + genero +
                ", atores=" + atores +
                '}';
    }
}
