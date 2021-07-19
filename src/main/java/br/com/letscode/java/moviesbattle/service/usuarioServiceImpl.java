package br.com.letscode.java.moviesbattle.service;


import br.com.letscode.java.moviesbattle.DAO.usuarioDAO;
import br.com.letscode.java.moviesbattle.dominio.Usuario;
import com.fasterxml.jackson.annotation.JacksonInject;

import java.io.IOException;
import java.util.List;

public class usuarioServiceImpl implements usuarioService {

    @JacksonInject
    private usuarioDAO usuarioDao;



    @Override
    public List<Usuario> listAll() throws IOException {
        return null;
    }



    @Override
    public int isThereSuchUser(String nome) {
        return 0;
    }
}
