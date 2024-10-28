package CronicasDeArcana;

import java.util.ArrayList;
import java.util.List;
import main.DeckPadrao;

public class Jogador {

    private String nome;
    private double vida;
    private double mana;
    private Deck deck;
    private Mao mao;
    private Cemiterio cemiterio;
    private CampodeBatalha CampoBatalha;


    //a questao aqui é que mao e cemiterio mudarao durante todo o jogo, ou seja, teremos que criar funções para mudar os objetos dessas classes.
    public Jogador(String nome, ArrayList<Carta> arrayCartas, ArrayList<String> nomecartasDeck ){
        //alteração que eu(juan) fiz:
        //vida e mana nao precisam ser passados no construtor ja que eles terao uma vida e mana padrao
        //isso aq eh nd ver
        DeckPadrao deckPadrao = new DeckPadrao();
        
        
        this.nome = nome;
        this.vida = 100;
        this.mana = 100;
        this.deck = new Deck(nomecartasDeck, arrayCartas);
        this.mao = new Mao(nomecartasDeck, arrayCartas, this.deck );
        this.cemiterio = new Cemiterio();
        this.CampoBatalha = new CampodeBatalha();


    }

    public Cemiterio getCemiterio() {
        return cemiterio;
    }

    public CampodeBatalha getCampoBatalha() {
        return CampoBatalha;
    }

    public Mao getMao() {
        return mao;
    }

    public String imprimirMao() {
        return mao.imprimirMao();
    }

    //vamos tirar vida e mana do construtor, ja que todos terao a msm quantidade

    public String getNome(){
        return this.nome;
    }

    public void setVida(double vida){
        this.vida = vida;
    }
    public double getVida(){
        return this.vida;
    }

    public void setMana(double mana){
        this.mana = mana;
    }
    public double getMana(){
        return this.mana;
    }
    public Deck getDeck() {
        return deck;
    }

    public Carta selecionarCarta(String nomeCarta){
        for (Carta carta : mao.getCartasMao()) {
            if (carta.getNome().equalsIgnoreCase(nomeCarta)) {
                return carta; // Retorna a carta caso encontre o nome no array de cartas
            }
        }
        return null;
    }

    public Carta selecionarCarta(List<Carta> cartas, String nomeCarta) {
        for (Carta carta : cartas) {
            if (carta.getNome().equalsIgnoreCase(nomeCarta)) {
                return carta; // Retorna a carta caso encontre o nome no array de cartas
            }
        }
        return null;
    }

    public void alterarVida(Carta carta){
        this.setVida(this.getVida() - carta.getPoder());
    }

    public void alterarMana(Carta carta){
        this.setMana(this.getMana() - carta.getCustoMana());
    }

    public void removerCarta(Carta carta){
        this.mao.removerCarta(carta);
    }

    public void adicionarCarta(Carta carta){
        this.mao.adicionarCarta(carta);
    }

    @Override
public String toString() {
    return "Jogador: " + nome + "\n" +
           "Vida: " + vida + ", Mana: " + mana + "\n" +
           "Mão: " + mao + "\n" +
           "Deck: " + deck;
}
}
