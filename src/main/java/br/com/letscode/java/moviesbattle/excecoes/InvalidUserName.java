package br.com.letscode.java.moviesbattle.excecoes;

public class InvalidUserName extends RuntimeException{
    public InvalidUserName(String message) {
        super(message);
    }
}
