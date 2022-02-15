package br.com.cursojava.service;

import br.com.cursojava.model.Sala;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DadoSala extends CarregaArquivo {
    private final String CAMINHO_ARQUIVO = "src\\main\\resources\\salas.csv";

    private List<Sala> salas;

    public DadoSala() {
        salas = new ArrayList<>();
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
                    var sala = new Sala();
                    sala.setIdSala(Integer.parseInt(linhaSplit[0]));
                    sala.setCapacidade(Integer.parseInt(linhaSplit[1]));
                    salas.add(sala);
                } catch (Exception e) {
                    System.out.printf("Não foi possivel converter a linha %s para uma sala\n", linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Houve um erro ao ler o arquivo");
        }
    }

    public Sala getSalaPorNumero(Integer numero) {
        for (Sala sala : salas) {
            if (sala.getIdSala().equals(numero)) {
                return sala;
            }
        }
        return null;
    }
}
