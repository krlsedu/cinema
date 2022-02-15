package br.com.cursojava.service;

import br.com.cursojava.model.Filme;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DadoFilme extends CarregaArquivo {
    private final String CAMINHO_ARQUIVO = "src\\main\\resources\\filmes.csv";
    private final String CAMINHO_ARQUIVO_ATORES = "src\\main\\resources\\filmesAtores.csv";

    private List<Filme> filmes;
    private DadoGenero dadosGeneros;
    private DadoAtor dadoAtor;

    public DadoFilme(DadoAtor dadoAtor, DadoGenero dadosGeneros) {
        this.dadoAtor = dadoAtor;
        this.dadosGeneros = dadosGeneros;
        filmes = new ArrayList<>();
        lerDadosArquivo();
    }

    @Override
    public void lerDadosArquivo() {
        try {
            List<String> linhasArquivo = getLinhas(CAMINHO_ARQUIVO);

            for (String linha : linhasArquivo) {
                try {
                    String[] linhaSplit = linha.split(",");
                    var filme = new Filme();
                    filme.setTitulo(linhaSplit[0]);
                    filme.setDuracaoEmMinutos(Integer.parseInt(linhaSplit[1]));
                    filme.setGenero(dadosGeneros.getGeneroPorDescricao(linhaSplit[2]));
                    lerDadosArquivoAtroes(filme);
                    filmes.add(filme);
                } catch (Exception e) {
                    System.out.printf("Não foi possivel converter a linha %s para um filme\n", linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Houve um erro ao ler o arquivo");
        }
    }

    public void lerDadosArquivoAtroes(Filme filme) {
        try {
            List<String> linhasArquivo = getLinhas(CAMINHO_ARQUIVO_ATORES);

            for (String linha : linhasArquivo) {
                try {
                    String[] linhaSplit = linha.split(",");
                    if (linhaSplit[0].equalsIgnoreCase(filme.getTitulo())) {
                        filme.getAtores().add(dadoAtor.getAtorPorNome(linhaSplit[1]));
                    }
                } catch (Exception e) {
                    System.out.printf("Não foi possivel converter a linha %s para um ator do filme\n", linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Houve um erro ao ler o arquivo");
        }
    }

    public Filme getFilmePorTitulo(String titulo) {
        for (Filme filme : filmes) {
            if (filme.getTitulo().equalsIgnoreCase(titulo)) {
                return filme;
            }
        }
        return null;
    }
}
