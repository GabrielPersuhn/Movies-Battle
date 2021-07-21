package br.com.letscode.java.moviesbattle.DAO;

import br.com.letscode.java.moviesbattle.dominio.Jogador;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface jogadorDAO {


    void showUsTheRank(String pathRanking) throws IOException;
    List<Jogador> rankSort() throws IOException;

    Jogador inserirJogadorNoRank(Jogador player) throws IOException;
}
