package br.com.cursojava.service;

import java.io.IOException;
import java.util.List;

public class CarregaAtor extends CarregaArquivo{
    private final String CAMINHO_ARQUIVO = "";


    public void carregaDadosAtor(){
        try {
            List<String> linhasArquivo = getLinhas(CAMINHO_ARQUIVO);




        } catch (IOException e) {
            System.out.println("Houve um erro ao ler o arquivo");
        }
    }
}
