package gui.zonas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import entidades.Jogador;
import entidades.carta.Carta;
import main.Game;
import logica.Logica;

public class CemiterioGui {
private Game game;
    private Jogador jogador1;
    private Jogador jogador2;
    private JFrame frame;
    private Logica logica;

    public CemiterioGui(Game game, Jogador jogador1, Jogador jogador2, JFrame frame, Logica logica ){
        this.game = game;
        this.frame = frame;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.logica = logica;
        
    }

    public JPanel createCemiterioPanel(Jogador jogador){

        JPanel playerCemiterioPanel = new JPanel();
        playerCemiterioPanel.setLayout(new BoxLayout(playerCemiterioPanel, BoxLayout.Y_AXIS));
        playerCemiterioPanel.setBackground(Color.BLACK);

        //botao que "abre" uma page com o cemiterio de cada jogador
        JButton cardButton = new JButton( "Cemiterio " + jogador.getNome());
            cardButton.setPreferredSize(new Dimension(100, 60));
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            cardButton.setAlignmentY(Component.BOTTOM_ALIGNMENT);
            cardButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {

                    // jdialog para exibir as cartas
                    JDialog cemiterioDialog = new JDialog();
                    cemiterioDialog.setTitle("Cemitério de " + jogador.getNome());
                    cemiterioDialog.setSize(300, 400); // Ajuste o tamanho conforme necessário
                    cemiterioDialog.setLocationRelativeTo(null); // Centraliza na tela
                    
                    
                    JPanel cemiterioPanel = new JPanel();
                    cemiterioPanel.setLayout(new BoxLayout(cemiterioPanel, BoxLayout.Y_AXIS));
                    cemiterioPanel.setBackground(Color.DARK_GRAY);
                    //for que itera sobre as cartas
                    for (Carta carta : jogador.getCemiterio().getCartasCemiterio()){

                        JButton cartaButton = new JButton(carta.getNome());
                        cartaButton.setPreferredSize(new Dimension(150, 40));
                        cartaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                        cartaButton.addActionListener(ev -> {
                            // informações da carta
                            JOptionPane.showMessageDialog(cemiterioDialog, 
                                "Detalhes da Carta: \n" + carta.toString(), 
                                "Detalhes da Carta", 
                                JOptionPane.INFORMATION_MESSAGE);
                        });
                        cemiterioPanel.add(cartaButton);
                        cemiterioPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espaço entre cartas

                    }

                    // adciona o dialog ao panel do cemiterio
                    cemiterioDialog.add(new JScrollPane(cemiterioPanel));
                    cemiterioDialog.setVisible(true);
                    
                }
            });
            playerCemiterioPanel.add(cardButton);
            return playerCemiterioPanel;

    }


}
