package br.com.letscode.java.moviesbattle.dominio;

import lombok.Data;

@Data
public class Usuario {
    private int index;
    private String userName;
    private String senha;
    private int score;
}
