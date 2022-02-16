package br.com.cursojava.service;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public interface LeArquivo {
    Scanner getScanner(String path) throws IOException;
    List<String> getLinhas(Scanner scanner);

    void lerDadosArquivo();
}
