package br.com.letscode.java.moviesbattle.DAO;

import br.com.letscode.java.moviesbattle.dominio.Filme;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.StringTokenizer;


public class filmesDAOimpl implements filmesDAO{
    final String caminhoFilmes = "src/main/java/br/com/letscode/java/moviesbattle/arquivos/filmes.csv";

    private Path pathFilmes;


    public void initFilmes() {
        try {
            pathFilmes = Paths.get(caminhoFilmes);
            if (!pathFilmes.toFile().exists()) {
                Files.createFile(pathFilmes);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public Filme csvLineToFilme(String linha ){
        Filme movie = new Filme();
        StringTokenizer comma  = new StringTokenizer(linha, ",");
        movie.setTitulo(comma.nextToken());
        movie.setNotaIMDB(Double.parseDouble(comma.nextToken()));
        movie.setVotos(Integer.parseInt(comma.nextToken()));
        movie.setIdIMDB(comma.nextToken());
        return movie;}




}
