package br.com.letscode.java.moviesbattle.service;


import br.com.letscode.java.moviesbattle.DAO.usuarioDAO;
import br.com.letscode.java.moviesbattle.dominio.Jogador;
import br.com.letscode.java.moviesbattle.dominio.Usuario;
import br.com.letscode.java.moviesbattle.excecoes.InvalidPassword;
import br.com.letscode.java.moviesbattle.excecoes.InvalidUserName;
import br.com.letscode.java.moviesbattle.excecoes.UsuarioJaExiste;
import br.com.letscode.java.moviesbattle.sercurity.criptografia;
import com.fasterxml.jackson.annotation.JacksonInject;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class usuarioServiceImpl implements usuarioService {

    @JacksonInject
    private usuarioDAO usuarioDao;

    private criptografia criptografia;

    private jogadorService jogadorService;


    @Override
    public List<Usuario> listAll() throws IOException {
        return usuarioDao.getAll();
    }

    @Override
    public boolean loginAttempt(Usuario usuario, String senhaAttempt) {
        String senhaCriptografada = criptografia.encode(senhaAttempt);
        return senhaCriptografada.equals(usuario.getSenha());
    }


    @Override
    public int isThereSuchUser(String userName) throws IOException {  // retorna 0 se não houver - é uma maneira de juntar um método de retorno booleano com int
        if (usuarioDao.findByUserName(userName).isPresent()) {
            Usuario suchUser = usuarioDao.findByUserName(userName).get();
            return suchUser.getIndex();
        } else {
            return 0;
        }
    }

    @Override
    public Usuario createNewUser(Usuario newUser) throws IOException {
        if (isThereSuchUser(newUser.getUserName()) == 0) {
            throw new UsuarioJaExiste("Já existe um jogador com esse user name");
        } else if (checkValidUserName(newUser)) {
            throw new InvalidUserName("User Name inválido! O nome de usuário deve ter entre 5 e 10 caracteres. Também deve ser uma combinação de letras e numeros");
        } else if (checkValidPassword(newUser)) {
            throw new InvalidPassword("Senha inválida! A senha deve ter entre 4 e 8 dígitos, além de precisar ter pelomenos um número e letra");
        }
        return usuarioDao.inserirUsuarioNoArquivo(newUser);
    }
    // ideia de fluxo: primeiro chama usuarioDao.findByUserName -> é empty? -> vai pro método de criar um novo usuário
    //                                                            -> tem conteúdo? vai pra esse método de login abaixo
    @Override
    public Jogador logedUser(Optional<Usuario> usuarios, String senhaAttempt) throws IOException {
        boolean logged;
        Usuario user = usuarios.get();
        while(logged = false){
            logged = loginAttempt(user, senhaAttempt);
        }
    return jogadorService.turnUserIntoPlayer(user);
    }

    public boolean checkValidUserName(Usuario user) {
        boolean hasNumber = false;
        boolean hasLetter = false;
        boolean validLength = (user.getUserName().length() >= 5 && user.getUserName().length() <= 10);
        for (int i = 0; i < user.getUserName().length(); i++) {
            char digit = user.getUserName().charAt(i);
            if (Character.isDigit(digit)) {
                hasNumber = true;
            } else if (digit >= 'a' && digit <= 'z') {
                hasLetter = true;
            }
        }
        return (hasLetter && hasNumber && validLength);
    }

    public boolean checkValidPassword(Usuario user) {
        boolean hasNumber = false;
        boolean hasLetter = false;
        boolean validLength = (user.getSenha().length() >= 4 && user.getSenha().length() <= 8);
        for (int i = 0; i < user.getSenha().length(); i++) {
            char digit = user.getSenha().charAt(i);
            if (Character.isDigit(digit)) {
                hasNumber = true;
            } else if (digit >= 'a' && digit <= 'z') {
                hasLetter = true;
            }
        }
        return (hasLetter && hasNumber && validLength);
    }
}
