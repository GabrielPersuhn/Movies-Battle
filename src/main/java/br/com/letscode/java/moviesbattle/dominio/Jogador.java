package br.com.letscode.java.moviesbattle.dominio;

import lombok.Data;

@Data
public class Jogador {
    private int index;
    private String name;
    private int vidas;
    private int score;
}
