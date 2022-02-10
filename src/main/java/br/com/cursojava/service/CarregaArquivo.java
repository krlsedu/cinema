package br.com.cursojava.service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public abstract class CarregaArquivo implements LeArquivo{
    @Override
    public Scanner getScanner(String path) throws IOException {

        return new Scanner(Path.of(path));

    }

    @Override
    public List<String> getLinhas(Scanner scanner) {

        List<String> linhas = new ArrayList<>();

        while (scanner.hasNextLine()) {
            linhas.add(scanner.nextLine());
        }

        return linhas;
    }

    public List<String> getLinhas(String path) throws IOException {
        Scanner scanner = getScanner(path);
        return getLinhas(scanner);
    }
}
