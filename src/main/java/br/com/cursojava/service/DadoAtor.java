package br.com.cursojava.service;

import br.com.cursojava.model.Ator;
import br.com.cursojava.model.enums.Sexo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DadoAtor extends CarregaArquivo {
    private final String CAMINHO_ARQUIVO = "src\\main\\resources\\atores.csv";

    private List<Ator> atores;

    public DadoAtor() {
        atores = new ArrayList<>();
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
                    Ator ator = new Ator();
                    ator.setNome(linhaSplit[0]);
                    ator.setIdade(Integer.parseInt(linhaSplit[1]));
                    switch (linhaSplit[2]) {
                        case "M":
                            ator.setSexo(Sexo.MASCULINO);
                            break;
                        case "F":
                            ator.setSexo(Sexo.FEMINO);
                            break;
                        case "O":
                            ator.setSexo(Sexo.OUTROS);
                            break;
                        default:
                            ator.setSexo(Sexo.NAO_INFORMADO);
                    }
                    atores.add(ator);
                } catch (Exception e) {
                    System.out.printf("Não foi possivel converter a linha %s para um ator\n", linha);
                }
            }
        } catch (IOException e) {
            System.out.println("Houve um erro ao ler o arquivo");
        }
    }

    public Ator getAtorPorNome(String nome) {
        for (Ator ator : atores) {
            if (ator.getNome().equalsIgnoreCase(nome)) {
                return ator;
            }
        }
        return null;
    }
}
