package main.gui;

import entidades.Jogador;
import entidades.carta.Carta;
import main.Game;
import main.Logica;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

//aqui pretendo colocar todas as funções GUI do campo de batalha

public class CampoBatalhaGui {
    private Game game;
    private Jogador jogador1;
    private Jogador jogador2;
    private JFrame frame;
    private Logica logica;

    //construtor:
    public CampoBatalhaGui( Game game, Jogador jogador1, Jogador jogador2, JFrame frame, Logica logica){
        this.game = game;
        this.frame = frame;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.logica = logica;
    }

    public JPanel createCampoBatalhaPanel(Jogador jogador, Jogador jogadorRival){
        JPanel playerCampoBatalhaPanel = new JPanel(new GridLayout(1, 2));
        playerCampoBatalhaPanel.setLayout(new BoxLayout(playerCampoBatalhaPanel, BoxLayout.Y_AXIS));
        playerCampoBatalhaPanel.setBackground(Color.BLACK);

        for(Carta carta : jogador.getCampoBatalha().getCartasnoCampo()){
            JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
            cardButton.setPreferredSize(new Dimension(100, 60));
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            cardButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    //função usada para dar dano tanto no jogador como nas cartas que estao no campo
                    logica.usarCartaNoCampoBatalha(jogador, carta, jogadorRival );
                }
            });

            

            playerCampoBatalhaPanel.add(cardButton);
            playerCampoBatalhaPanel.add(Box.createRigidArea(new Dimension(0, 30)));



        }

        return playerCampoBatalhaPanel;

    }


    public void atualizarCampoBatalhaPanel(Jogador jogador, JPanel campoBatalhaPanel, Jogador jogadorRival) {
        
        //remove as cartas do panel
        campoBatalhaPanel.removeAll();
    
        //lista para armazenar cartas com vida <= 0
        List<Carta> cartasParaRemover = new ArrayList<>();


        //itera sobre as cartas no campo de batalha
        for (Carta carta : jogador.getCampoBatalha().getCartasnoCampo()) {
            //verifica se as cartas estao vivas
            if (carta.getResistencia() > 0) {
                //cria gui da carta
                JPanel cartaPanel = new JPanel();
                cartaPanel.setLayout(new BoxLayout(cartaPanel, BoxLayout.Y_AXIS));
                cartaPanel.setBackground(Color.DARK_GRAY);

                JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
                cardButton.setPreferredSize(new Dimension(100, 60));
                cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                cardButton.addActionListener(e -> logica.usarCartaNoCampoBatalha(jogador, carta, jogadorRival ));
                
                //barra de progresso da vida (em desenvolvimento)
                // JProgressBar barraVida = new JProgressBar(0, (int) carta.getResistencia()); // vida máxima da carta
                // barraVida.setValue((int) carta.getResistencia()); // vida atual da carta
                // barraVida.setPreferredSize(new Dimension(100, 2));
                // barraVida.setForeground(Color.RED);//estipular uma condicional aqui
                // barraVida.setAlignmentX(Component.CENTER_ALIGNMENT);
    
                // cartaPanel.add(cardButton);
                // cartaPanel.add(barraVida);
                
    
                
                campoBatalhaPanel.add(cardButton);
                campoBatalhaPanel.add(Box.createRigidArea(new Dimension(0, 30)));
    
            } else {//caso n esteja viva
                
                //adciona ao cemiterio e coloca na lista pra remover
                jogador.getCemiterio().adicionarCarta(carta);
                cartasParaRemover.add(carta); // Marca para remoção depois
            }
        }
    
        //remove cartas da lista
        for (Carta carta : cartasParaRemover) {
            jogador.getCampoBatalha().removerCarta(carta);
        }
    
        
        campoBatalhaPanel.revalidate();
        campoBatalhaPanel.repaint();
    }

//a dificuldade aqui é a seguinte: como os metodos estarao em classes diferentes, eles terao que receber muito mais
//parametros!

 

}
