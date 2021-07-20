package br.com.letscode.java.moviesbattle.DAO;

import br.com.letscode.java.moviesbattle.dominio.Filme;

public interface filmesDAO {

    Filme csvLineToFilme(String linha);
}
