package br.com.letscode.java.moviesbattle.excecoes;

public class InvalidPassword extends RuntimeException{
    public InvalidPassword(String message) {
        super(message);
    }
}
