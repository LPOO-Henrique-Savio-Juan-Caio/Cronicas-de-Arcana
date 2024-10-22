package main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu2 {
    private JPanel panel1;
    DeckPadrao deckPadrao = new DeckPadrao();

    private String Jogador1;
    private String Jogador2;
    private JButton deck1;
    private JButton deck2;
    private JLabel titulomenu2;
    private String[] deckJogador1;
    private JFrame frame;

    public Menu2(String Jogador1, String Jogador2, JFrame frame) {
        this.frame = frame;
        //recebe o nome dos jogadores
        this.Jogador1 = Jogador1;
        this.Jogador2 = Jogador2;


        //o jogador escolhe seu deck esse deck é um array com o nome das cartas
        deck1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deckJogador1 = deckPadrao.getDeckPadrao1();

                //vai pro proximo menu(escolha do prox jogador)
                Menu3 menu3 = new Menu3(Jogador1, Jogador2, deckJogador1, frame);
                menu3.menu3Start();
                frame.dispose();



            }
        });
        deck2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deckJogador1 = deckPadrao.getDeckPadrao2();

                //vai pro proximo menu(escolha do prox jogador)
                Menu3 menu3 = new Menu3(Jogador1, Jogador2, deckJogador1, frame);
                menu3.menu3Start();
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    //metode que inicia essa tela:
    public void menu2Start() {

        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu2(Jogador1, Jogador2, frame).getPanel1());
        frame.setMinimumSize(new Dimension(450,474));// Adiciona o painel da classe Menu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Configura para fechar ao clicar no 'X
        frame.pack();  // Ajusta o tamanho da janela para caber nos componentes
        frame.setVisible(true);  // Torna a janela visível
    }
}
//decidi criar 2 decks padroes, o jogador 1 escolhe nesse menu, e o jogador 2 escolhe no proximo