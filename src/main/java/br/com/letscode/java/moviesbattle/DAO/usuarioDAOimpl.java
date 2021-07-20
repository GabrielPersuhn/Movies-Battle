package br.com.letscode.java.moviesbattle.DAO;

import br.com.letscode.java.moviesbattle.dominio.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class usuarioDAOimpl implements usuarioDAO{
    private String caminhoUsuarios = "src/main/java/br/com/letscode/java/moviesbattle/arquivos/jogadores.csv";

    private Path pathUsuarios;


    public void initUsuarios() {
        try {
            pathUsuarios = Paths.get(caminhoUsuarios);
            if (!pathUsuarios.toFile().exists()) {
                Files.createFile(pathUsuarios);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public Optional<Usuario> findByUserName(String userName) throws IOException {
        List<Usuario> registeredUsers = getAll();
        return registeredUsers.stream().filter(user -> user.getUserName().equals(userName)).findFirst();
    }



    @Override
    public List<Usuario> getAll() throws IOException {
        List<Usuario> user;
        try (BufferedReader br = Files.newBufferedReader(pathUsuarios)){
            user = br.lines().filter(Objects::nonNull).filter(Predicate.not(String::isEmpty)).map(this::csvLineToUser).collect(Collectors.toList());
        }
        return user; }

    @Override
    public String userToCsVLine (Usuario usuario){
        return String.format("%s,%s,%s,%s\r\n", usuario.getIndex(), usuario.getUserName(), usuario.getSenha(), usuario.getScore()); }



    @Override
    public Usuario csvLineToUser(String linha) {
        StringTokenizer token = new StringTokenizer(linha, ",");
        Usuario readUser = new Usuario();
        readUser.setIndex(Integer.parseInt(token.nextToken()));
        readUser.setUserName(token.nextToken());
        readUser.setSenha(token.nextToken());
        readUser.setScore(Integer.parseInt(token.nextToken()));
        return readUser;
    }

    private void writeToUsuario(String usuarioStr, StandardOpenOption option) throws IOException {
        try (BufferedWriter bf = Files.newBufferedWriter(pathUsuarios, option)) {
            bf.flush();
            bf.write(usuarioStr);
        }
    }

    @Override
    public Usuario inserirUsuarioNoArquivo(Usuario user) throws IOException {
        writeToUsuario(userToCsVLine(user), StandardOpenOption.APPEND);
        return user;
    }





}
