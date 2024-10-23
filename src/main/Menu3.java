package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu3 {
    private JPanel panel1;

    //deixando estatico para poder testar!
    public static String jogador1;
    public static String jogador2;
    public static String[] deckJogador1;

    private String[] deckJogador2;


    private JLabel titulomenu3;
    private JButton deck1;
    private JButton deck2;
    private JFrame frame;

    CartasJogo cartasjogo = new CartasJogo();

    DeckPadrao deckPadrao = new DeckPadrao();

    public Menu3(String jogador1, String jogador2, String[] deckJogador1, JFrame frame) {
        this.frame = frame;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.deckJogador1 = deckJogador1;
        deck1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deckJogador2 = deckPadrao.getDeckPadrao1();
                GameGui game = new GameGui(jogador1, jogador2, cartasjogo.getArrayCartas(), deckJogador1, deckJogador2);
//                game.gameStart();
                frame.dispose();
                System.out.println(game.toString());

            }
        });
        deck2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deckJogador2 = deckPadrao.getDeckPadrao2();
                GameGui game = new GameGui(jogador1, jogador2, cartasjogo.getArrayCartas(), deckJogador1, deckJogador2);
//                game.gameStart();
                frame.dispose();
                System.out.println(game.toString());

            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void menu3Start() {

        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu3(jogador1, jogador2, deckJogador1, frame).getPanel1());
        frame.setMinimumSize(new Dimension(450,474));// Adiciona o painel da classe Menu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Configura para fechar ao clicar no 'X
        frame.pack();  // Ajusta o tamanho da janela para caber nos componentes
        frame.setVisible(true);  // Torna a janela visível
    }
}