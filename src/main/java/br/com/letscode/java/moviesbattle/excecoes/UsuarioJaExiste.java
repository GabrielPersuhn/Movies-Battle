package br.com.letscode.java.moviesbattle.excecoes;

public class UsuarioJaExiste extends RuntimeException{
    public UsuarioJaExiste(String message) {
        super(message);
    }
}
