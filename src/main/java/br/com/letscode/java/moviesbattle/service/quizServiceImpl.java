package br.com.letscode.java.moviesbattle.service;

import br.com.letscode.java.moviesbattle.dominio.Filme;
import br.com.letscode.java.moviesbattle.dominio.Jogador;
import br.com.letscode.java.moviesbattle.dominio.Quiz;
import br.com.letscode.java.moviesbattle.dominio.Response;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


@Service
public class quizServiceImpl {

    private String caminhoRanking = "src/main/java/br/com/letscode/java/moviesbattle/arquivos/jogadores.csv";

    private Path pathJogadores;

    private final Set<Filme> filmes = new LinkedHashSet<>();
    private final Set<Quiz> quizzes = new LinkedHashSet<>();

    public quizServiceImpl() {
        this.filmes.add(new Filme("teste 1", "1", 9.5, 10));
        this.filmes.add(new Filme("teste 2", "2", 8.0, 5));
        this.filmes.add(new Filme("teste 3", "1", 7, 10));
        this.filmes.add(new Filme("teste 4", "1", 5, 10));
    }

    public Filme getRandomMovie(Set<Filme> filmes){
        Random random = new Random();
        int randomNumber = random.nextInt(filmes.size());
        int currentIndex = 0;

        for (Filme element : filmes) {
            if (currentIndex == randomNumber) {
                return element;
            }
            currentIndex++;
        }
        return null;
    }

    public Set<Filme> listAllMovies() {
        return filmes;
    }

    public Set<Quiz> listAllQuizzes(){
        return quizzes;
    }

    public String createNewQuiz() {

        Quiz quiz = new Quiz();
        this.quizzes.add(quiz);

        Filme first = new Filme();
        Filme second = new Filme();

        first = getRandomMovie(filmes);
        second = getRandomMovie(filmes);
             
        if (first != second) {
            quiz.setIndex(first.getIdIMDB()+second.getIdIMDB());
            quiz.setFirstMovie(first);
            quiz.setSecondMovie(second);

            if(first.getNotaIMDB() >= second.getNotaIMDB()) {
                quiz.setAnswer(first.getIdIMDB());
            }else{
                quiz.setAnswer(second.getIdIMDB());
            }

            return "Qual dos dois filmes tem a maior nota no IMDB?" +
                    "Nome: " + first.getTitulo() + ", ID: " + first.getIdIMDB() +
                    "Nome: " + second.getTitulo() + ", ID: " + second.getIdIMDB();
        } else {

            while (first == second) {
                second = getRandomMovie(filmes);
            }
            quiz.setIndex(first.getIdIMDB()+second.getIdIMDB());
            quiz.setFirstMovie(first);
            quiz.setSecondMovie(second);

            if(first.getNotaIMDB() >= second.getNotaIMDB()) {
                quiz.setAnswer(first.getIdIMDB());
            }else{
                quiz.setAnswer(second.getIdIMDB());
            }

            return "Qual dos dois filmes tem a maior nota no IMDB?" +
                    "Nome: " + first.getTitulo() + ", ID: " + first.getIdIMDB() +
                    "Nome: " + second.getTitulo() + ", ID: " + second.getIdIMDB();
        }
    }

    /*
    A resposta do jogador será enviada como requisição POST para "/quizz" informando usuário,
    senha e id do filme/série vencedor. Tudo deve estar encapsulado no "request body".
    O endpoint responde verdadeiro/falso para o resultado e atualiza o progresso em "jogos.csv".
    O progresso de cada jogador será armazenado no arquivo "jogos.csv", contendo login e o
    progresso atual no formato "x/y" onde x=acertos e y=total.
    O histórico ficará em "ranking.csv" e sempre deve ser lido ordenado da maior pontuação
    para a menor.
     */
   // public Response resultAndUpdate(Response response) {
    //    this.quizzes.s
    //    response.getIdIMDB();
    //    updateJogo(response.getUserName(), response.getSenha());
    //
    //    return null;
    //}

    public void updateJogosCsv(Set quizzes, String pathJogos, Jogador player){
        /**
         * 1-verifica se player já está em jogos.csv
         * 2- Se estiver, pegue tal userName ; se não estiver, uma nova linha será escrita
         * 3- linha será no formato: player.getUserName , player.getVidas, player.getScore, quizzes
         */


        int linhaCount = 0;
        boolean hasBeenFound = false;
        final Scanner scan = new Scanner(pathJogos);
        while (scan.hasNextLine()){
            String linha  = scan.nextLine();
            linhaCount++;
            if(linha.contains(player.getName())){
                hasBeenFound = true;
                break;
            }


        }

        }



}






