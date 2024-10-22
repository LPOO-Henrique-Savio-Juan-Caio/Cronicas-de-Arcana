package main;

import CronicasDeArcana.Carta;
import CronicasDeArcana.Jogador;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//VOU FAZER A TELA DO JOGO SEM FUNCIONAR, TRAZER PRO INTELLIJ E FAZER FUNCIONAR.

public class Game {
    //aqui onde faremos toda logica do jogo
    //outra class vai receber o gui

    //como primeira parte do jogo, vamos instanciar jogador1, jogador2
    //esses jogadores vao receber nome e seu deck
    //obviamente pretendo criar um meno que recebera essas informações

    //inicializando todas as cartas do jogo
    CartasJogo cartasjogo = new CartasJogo();


    private String nome1;
    private String nome2;
    private String[] deckJogador1;
    private String[] deckJogador2;

    private Jogador jogador1;
    private Jogador jogador2;

    private JFrame frame;
    private JPanel panel1;

    //construtor para instanciar essas classes
    //obviamente esse construtor sera preenchido no menu do jogo
    public Game(String nome1, String nome2, List<Carta> arrayCartas, String[] deckJogador1, String[] deckJogador2, JFrame frame ) {
        //iniciando os atributos
        this.frame = frame;
        this.nome1 = nome1;
        this.nome2 = nome2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;

        //criando jogadores
        jogador1 = new Jogador(nome1, arrayCartas, deckJogador1) ;
        jogador2 = new Jogador(nome2, arrayCartas, deckJogador2);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    //tela
    public void gameStart(){
        JFrame frame = new JFrame("Cronicas de Arcana");
        frame.setContentPane(new Game(nome1, nome2, cartasjogo.getArrayCartas(), deckJogador1, deckJogador2, frame).getPanel1());
        frame.setMinimumSize(new Dimension(800,474));// Adiciona o painel da classe Menu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Configura para fechar ao clicar no 'X
        frame.pack();  // Ajusta o tamanho da janela para caber nos componentes
        frame.setVisible(true);  // Torna a janela visível

    }

    //so pra testar se ta rodando
    @Override
    public String toString() {
        return "Game: " + jogador1.getNome() + " vs " + jogador2.getNome();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}