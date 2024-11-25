package entidades;

import static Enum.Valores.*;
import cartas.DeckPadrao;
import entidades.carta.*;
import entidades.zonas.*;
import java.util.ArrayList;

public class Jogador {

    private String nome;
    private double vida;
    private double mana;
    private Deck deck;
    private Mao mao;
    private Cemiterio cemiterio;
    private CampoDeBatalha CampoBatalha;

    public Jogador(String nome, ArrayList<Carta> arrayCartas, ArrayList<String> nomecartasDeck ){
        DeckPadrao deckPadrao = new DeckPadrao();
        this.nome = nome;
        this.vida = VIDA.getValor();
        this.mana = MANA.getValor();
        this.deck = new Deck(nomecartasDeck, arrayCartas);
        this.mao = new Mao(nomecartasDeck, arrayCartas, this.deck );
        this.cemiterio = new Cemiterio();
        this.CampoBatalha = new CampoDeBatalha();
    }

    public Cemiterio getCemiterio() {
        return cemiterio;
    }

    public CampoDeBatalha getCampoBatalha() {
        return CampoBatalha;
    }

    public Mao getMao() {
        return mao;
    }

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

    public void addMana(double manaAdd){
        this.mana = this.mana + manaAdd;
    }

    public double getMana(){
        return this.mana;
    }

    public void alterarVida(Carta carta){
        this.setVida(this.getVida() - carta.getPoder());
    }

    public void alterarMana(Carta carta){
        this.setMana(this.getMana() - carta.getCustoMana());
    }

    public void alterarVidaDouble(double valor){
        this.setVida(this.getVida() + valor);
    }

    public void alterarManaDouble(double valor){
        this.setMana(this.getMana() + valor);
    }

}
