package main;
import java.util.HashMap;
import java.util.Map;

//classe pra criar uma lista com o nome dos jogadores e quantidades de vitorias
//depois criar uma tela com o ranking
public class Progressao {
    private Map<String, Integer> vitoriaJogadores;

    public Progressao(){

        vitoriaJogadores = new HashMap<>();
        
    }

    public int getVitoriaJogador(String nomeJogador){
            return vitoriaJogadores.getOrDefault(nomeJogador, 0);
    }

    //função destinada a add jogador a lista
    public void addJogador(String nomeJogador){
        //se nao tiver ninguem com esse nome, ele adiciona a lista com 0 vitorias
        if (!vitoriaJogadores.containsKey(nomeJogador)) {
            vitoriaJogadores.put(nomeJogador, 0);
        }

    }

    //depois que um jogador for declarado vencedor
    public void addVitoria(String nomeJogador){
        vitoriaJogadores.put(nomeJogador, vitoriaJogadores.get(nomeJogador) + 1);
    }

}
