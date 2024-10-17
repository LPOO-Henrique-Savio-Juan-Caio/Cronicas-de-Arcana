package main;

import CronicasDeArcana.Carta;
import CronicasDeArcana.Jogador;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Game {
    //aqui onde faremos toda logica do jogo
    //outra class vai receber o gui

    //como primeira parte do jogo, vamos instanciar jogador1, jogador2
    //esses jogadores vao receber nome e seu deck
    //obviamente pretendo criar um meno que recebera essas informações

    private Jogador jogador1;
    private Jogador jogador2;

    private JFrame frame;
    private JPanel panel1;

    //construtor para instanciar essas classes
    //obviamente esse construtor sera preenchido no menu do jogo
    public Game(String nome1, String nome2, List<Carta> arrayCartas, String[] deckJogador1, String[] deckJogador2, JFrame frame ) {
        this.frame = frame;
        jogador1 = new Jogador(nome1, arrayCartas, deckJogador1) ;
        jogador2 = new Jogador(nome2, arrayCartas, deckJogador2);
    }


    //tela
    public void gameStart(){

    }

    //so pra testar se ta rodando
    @Override
    public String toString() {
        return "Game: " + jogador1.getNome() + " vs " + jogador2.getNome();
    }

}
