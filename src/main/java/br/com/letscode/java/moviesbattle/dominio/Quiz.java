package br.com.letscode.java.moviesbattle.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Quiz {

    private String index;
    private Filme firstMovie;
    private Filme secondMovie;
    private String answer;
}
