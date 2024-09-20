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
    public Jogador(String nome, double vida, double mana,  List<Carta> arrayCartas,  String[] nomecartasDeck){
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        this.deck = new Deck(nomecartasDeck, arrayCartas);
        this.mao = new Mao(nomecartasDeck, arrayCartas);
        this.cemiterio = new Cemiterio();


    }

    public String imprimirMao() {
        return mao.toString();
    }

    //vamos tirar vida e mana do construtor, ja que todos terao a msm quantidade
    




}
