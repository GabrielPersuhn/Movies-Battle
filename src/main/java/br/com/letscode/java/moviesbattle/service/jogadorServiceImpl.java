package br.com.letscode.java.moviesbattle.service;

import br.com.letscode.java.moviesbattle.dominio.Jogador;
import br.com.letscode.java.moviesbattle.dominio.Usuario;

public class jogadorServiceImpl implements jogadorService {
    @Override
    public Jogador turnUserIntoPlayer(Usuario user) { // quando uma nova partida começar
        Jogador player = new Jogador();
        player.setName(user.getUserName());
        player.setScore(0);
        player.setVidas(3);
        return player;
    }

    @Override
    public Jogador mistake(Jogador jogador) {
        jogador.setVidas(jogador.getVidas()-1);
        return jogador;
    }

    @Override
    public Jogador scoredCorrect(Jogador jogador) {
        jogador.setScore(jogador.getScore()+1);
        return jogador;
    }

}
