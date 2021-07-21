package br.com.letscode.java.moviesbattle.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class Jogador {
    private int index;
    private String name;
    private int vidas;
    private int score;

}
