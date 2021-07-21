package br.com.letscode.java.moviesbattle.service;

import br.com.letscode.java.moviesbattle.DAO.jogadorDAO;
import br.com.letscode.java.moviesbattle.DAO.usuarioDAO;
import br.com.letscode.java.moviesbattle.dominio.Jogador;
import br.com.letscode.java.moviesbattle.dominio.Usuario;

import java.io.IOException;
import java.util.List;

public class rankingService {
    private jogadorDAO jogadorDAO;
    private usuarioDAO usuarioDao;

    public Jogador inserirJogador(Jogador player) throws IOException {
        if (jogadorDAO.getName()
        return jogadorDAO.inserirJogadorNoRank(player);
    }

    public Jogador atualizarScore (Jogador player){
        if (player.getVidas() == 0){
            player.setScore();

        }
    }



}