package CronicasDeArcana;

public class Jogador {

    private String nome;
    private double vida;
    private double mana;
    private Deck deck;
    private Mao mao;
    private Cemiterio cemiterio;

    public Jogador(String nome, double vida, double mana, Mao mao, Cemiterio cemiterio){
        this.nome = nome;
        this.vida = vida;
        this.mana = mana;
        // this.deck = new Deck();
        this.mao = new Mao();
        this.cemiterio = new Cemiterio();


    }




}
