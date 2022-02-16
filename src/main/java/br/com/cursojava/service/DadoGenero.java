package br.com.cursojava.service;

import br.com.cursojava.model.Genero;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DadoGenero extends CarregaArquivo {
    private final String CAMINHO_ARQUIVO = "src\\main\\resources\\generos.csv";

    private List<Genero> generos;

    public DadoGenero() {
        generos = new ArrayList<>();
        lerDadosArquivo();
    }

    @Override
    public void lerDadosArquivo() {
        try {
            List<String> linhasArquivo = getLinhas(CAMINHO_ARQUIVO);

            for (String linha : linhasArquivo) {
                var genero = new Genero();
                genero.setDescricao(linha);
                generos.add(genero);
            }
        } catch (IOException e) {
            System.out.println("Houve um erro ao ler o arquivo");
        }
    }

    public Genero getGeneroPorDescricao(String descricao) {
        for (Genero genero : generos) {
            if (genero.getDescricao().equalsIgnoreCase(descricao)) {
                return genero;
            }
        }
        return null;
    }
}
