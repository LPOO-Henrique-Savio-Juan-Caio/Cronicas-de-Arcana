package CronicasDeArcana;
import java.util.List;

public class Jogador {

    private String nome;
    private double vida;
    private double mana;
    private Deck deck;
    private Mao mao;
    private Cemiterio cemiterio;


    //a questao aqui é que mao e cemiterio mudarao durante todo o jogo, ou seja, teremos que criar funções para mudar os objetos dessas classes.
    public Jogador(String nome, double vida, double mana, Mao mao, Cemiterio cemiterio, List<Carta> arrayCartas, String[] cartasDeck, String[] cartasCemiterio, String[] cartasMao){
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.deck = new Deck(cartasDeck, arrayCartas);
        this.mao = new Mao(arrayCartas, cartasCemiterio);
        this.cemiterio = new Cemiterio(arrayCartas, cartasMao);


    }




}
