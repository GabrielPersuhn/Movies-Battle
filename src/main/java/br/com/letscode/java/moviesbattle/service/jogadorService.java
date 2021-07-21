package br.com.letscode.java.moviesbattle.service;

import br.com.letscode.java.moviesbattle.dominio.Jogador;
import br.com.letscode.java.moviesbattle.dominio.Usuario;

import java.io.IOException;

public interface jogadorService {
    Jogador turnUserIntoPlayer(Usuario user);
    Jogador mistake(Jogador jogador);
    Jogador scoredCorrect(Jogador jogador);



}
