package br.com.letscode.java.moviesbattle.dominio;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Filme {
    private String titulo;
    private String idIMDB;
    private double notaIMDB;
    private int votos;
}
