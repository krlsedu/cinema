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

            for (int i = 0; i < linhasArquivo.size(); i++) {
                String linha = linhasArquivo.get(i);
                try {
                    String[] linhaSplit = linha.split(",");
                    var genero = new Genero();
                    genero.setDescricao(linhaSplit[0]);
                    generos.add(genero);
                } catch (Exception e) {
                    System.out.printf("Não foi possivel converter a linha %s para um genero\n", linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Houve um erro ao ler o arquivo");
        }
        System.out.println(generos);
    }

    public Genero getGeneroPorDescricao(String descricao) {
        for (Genero genero : generos) {
            if (genero.getDescricao().equals(descricao)) {
                return genero;
            }
        }
        return null;
    }
}
