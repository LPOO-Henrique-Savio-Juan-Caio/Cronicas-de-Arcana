package gui.zonas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.atomic.AtomicReference;

import entidades.Jogador;
import entidades.carta.Carta;
import main.Game;
import logica.Logica;

import static gui.menu.TelaInicial.fonteCustomizada1;

public class CemiterioGui {
private Game game;
    private Jogador jogador1;
    private Jogador jogador2;
    private JFrame frame;
    private Logica logica;
    private Carta cartaSelecionada;

    public CemiterioGui(Game game, Jogador jogador1, Jogador jogador2, JFrame frame, Logica logica ){
        this.game = game;
        this.frame = frame;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.logica = logica;
        
    }

    public JPanel createCemiterioPanel(Jogador jogador, Jogador jogadorRival, int initialX, int initialY){

        JPanel playerCemiterioPanel = new JPanel();
        playerCemiterioPanel.setLayout(null);
        playerCemiterioPanel.setBackground(new Color(0, 0, 0, 0));

        int x = initialX; // Posição inicial X
        int y = initialY; // Posição inicial Y
        int buttonWidth = 120;
        int buttonHeight = 100;

        //botao que "abre" uma page com o cemiterio de cada jogador
            JButton cardButton = new JButton("");
            cardButton.setBounds(x, y, buttonWidth, buttonHeight);
            cardButton.setBackground(new Color(0, 0, 0, 0));
            cardButton.setForeground(new Color(0, 0, 0, 0));
            cardButton.setBorderPainted(false);
            cardButton.setMargin(new Insets(0, 0, 0, 0));
            cardButton.setContentAreaFilled(false);
            cardButton.setFocusPainted(false);

            cardButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {

                    // jdialog para exibir as cartas
                    JDialog cemiterioDialog = new JDialog();
                    cemiterioDialog.setFont(fonteCustomizada1);
                    cemiterioDialog.setTitle("Cemitério de " + jogador.getNome());
                    cemiterioDialog.setSize(300, 400); // Ajuste o tamanho conforme necessário
                    cemiterioDialog.setLocationRelativeTo(null); // Centraliza na tela
                    
                    
                    JPanel cemiterioPanel = new JPanel();
                    cemiterioPanel.setLayout(new BoxLayout(cemiterioPanel, BoxLayout.Y_AXIS));
                    cemiterioPanel.setBackground(Color.BLACK);
                    cemiterioPanel.setFont(fonteCustomizada1);
                    //for que itera sobre as cartas
                    for (Carta carta : jogador.getCemiterio().getCartasCemiterio()){

                        JButton cartaButton = new JButton(carta.getNome());
                        cardButton.setFont(fonteCustomizada1);
                        cartaButton.setPreferredSize(new Dimension(150, 40));
                        cartaButton.setAlignmentX(Component.CENTER_ALIGNMENT);
                        cartaButton.addActionListener(ev -> {
                            // informações da carta
                            JOptionPane msg = new JOptionPane();
                            msg.setFont(fonteCustomizada1);
                            msg.showMessageDialog(cemiterioDialog,
                                "Detalhes da Carta: \n" + carta.toString(), 
                                "Detalhes da Carta", 
                                msg.INFORMATION_MESSAGE);

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
            playerCemiterioPanel.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
            return playerCemiterioPanel;

    }



    public Carta selecionarCartaCemiterio(Jogador jogador) {

        // jdialog para exibir as cartas
        JDialog cemiterioDialog = new JDialog();
        cemiterioDialog.setFont(fonteCustomizada1);
        cemiterioDialog.setTitle("Cemitério de " + jogador.getNome());
        cemiterioDialog.setSize(300, 400); // Ajuste o tamanho conforme necessário
        cemiterioDialog.setLocationRelativeTo(null); // Centraliza na tela

        JPanel cemiterioPanel = new JPanel();
        cemiterioPanel.setLayout(new BoxLayout(cemiterioPanel, BoxLayout.Y_AXIS));
        cemiterioPanel.setBackground(Color.BLACK);
        cemiterioPanel.setFont(fonteCustomizada1);

        // Loop para adicionar botões de cartas
        for (Carta carta : jogador.getCemiterio().getCartasCemiterio()) {
            JButton cartaButton = new JButton(carta.getNome());
            cartaButton.setFont(fonteCustomizada1);
            cartaButton.setPreferredSize(new Dimension(150, 40));
            cartaButton.setAlignmentX(Component.CENTER_ALIGNMENT);

            // Ao clicar, define a carta selecionada e fecha o diálogo
            cartaButton.addActionListener(ev -> {
                cartaSelecionada = carta;
                cemiterioDialog.dispose();
            });

            cemiterioPanel.add(cartaButton);
            cemiterioPanel.add(Box.createRigidArea(new Dimension(0, 5))); // Espaço entre cartas
        }

        // Adiciona o painel ao diálogo e exibe
        cemiterioDialog.add(new JScrollPane(cemiterioPanel));
        cemiterioDialog.setModal(true); // Define o diálogo como modal para pausar a execução
        cemiterioDialog.setVisible(true);

        // Retorna a carta selecionada
        return cartaSelecionada;
    }
}



