package br.com.letscode.java.moviesbattle.DAO;

import br.com.letscode.java.moviesbattle.dominio.Jogador;
import br.com.letscode.java.moviesbattle.dominio.Usuario;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;


public class jogadorDAOimpl implements jogadorDAO {
    private String caminhoRanking = "src/main/java/br/com/letscode/java/moviesbattle/arquivos/ranking.csv";

    private Path pathRanking;

    public void initRanking() {
        try {
            pathRanking = Paths.get(caminhoRanking);
            if (!pathRanking.toFile().exists()) {
                Files.createFile(pathRanking);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public String jogadorToCsVFormat(Jogador player ){
        return String.format("%s,%s",player.getName(),player.getScore());}

    public Jogador csvLineToJogador(String linha){
        StringTokenizer token = new StringTokenizer(linha, ",");
        Jogador player = new Jogador();
        player.setName(token.nextToken());
        player.setScore(Integer.parseInt(token.nextToken()));
        player.setVidas(0);
    return player;}

    public List<Jogador> getAllJogadores() throws IOException {
        List<Jogador> player;
        try (BufferedReader br = Files.newBufferedReader(pathRanking)){
            player = br.lines().filter(Objects::nonNull).filter(Predicate.not(String::isEmpty)).map(this::csvLineToJogador).collect(Collectors.toList());
        }
        return player; }


    public Optional<Jogador> findByName (String name) throws IOException {
        List<Jogador> registeredUsers = getAllJogadores();
        return registeredUsers.stream().filter(user -> user.getName().equals(name)).findFirst();
    }

    private void writeToRank(String jogadorStr, StandardOpenOption option) throws IOException {
        try (BufferedWriter bf = Files.newBufferedWriter(pathRanking, option)) {
            bf.flush();
            bf.write(jogadorStr);
        }
    }

    @Override
    public void showUsTheRank(String pathRanking) throws IOException {
        LineNumberReader reader  = new LineNumberReader(new FileReader(pathRanking));
        reader.skip(Long.MAX_VALUE);
        int lines = reader.getLineNumber();
        reader.close();
        System.out.println("-----RANKING----");
        StringTokenizer comma = new StringTokenizer(",");
        List<Jogador> topRank = getAllJogadores();
        lines = (lines>5? 5 : lines);
        for (int i = 0 ; i<lines ; i++){
            System.out.printf("%s \t - \t %d" , topRank.get(i).getName(),topRank.get(i).getScore());
        }
    }

    @Override
    public List<Jogador> rankSort() throws IOException {
        List<Jogador> rank = getAllJogadores();
        Collections.sort(rank, jogadorScoreComparator);
        return rank;
    }

    public static Comparator<Jogador> jogadorScoreComparator = (rank1, rank2) -> rank2.getScore() - rank1.getScore();

    @Override
    public Jogador inserirJogadorNoRank(Jogador player) throws IOException {
        writeToRank(jogadorToCsVFormat(player), StandardOpenOption.APPEND);
        return player;
    }






}


