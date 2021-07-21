package br.com.letscode.java.moviesbattle.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
    private int index;
    private String userName;
    private String senha;
    private int score;
}
