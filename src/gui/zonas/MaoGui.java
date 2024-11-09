package gui.zonas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entidades.Jogador;
import entidades.carta.Carta;
import entidades.carta.Criatura;
import entidades.carta.Encantamento;
import entidades.carta.Feitico;
import main.Game;
import logica.Logica;

public class MaoGui {

    private Game game;
    private Jogador jogador1;
    private Jogador jogador2;
    private JFrame frame;
    private Logica logica;

    public MaoGui(Game game, Jogador jogador1, Jogador jogador2, JFrame frame, Logica logica ){
        this.game = game;
        this.frame = frame;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.logica = logica;
        
    }

        //função que cria o panel de cartas para cada jogador
    public JPanel createMaoPanel(Jogador jogador, Jogador jogadorRival) {
        JPanel playerMaoPanel = new JPanel();
        playerMaoPanel.setLayout(new BoxLayout(playerMaoPanel, BoxLayout.Y_AXIS));
        playerMaoPanel.setBackground(Color.BLACK);

        for (Carta carta : jogador.getMao().getCartasMao()) {
            JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
            cardButton.setPreferredSize(new Dimension(100, 60));
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            cardButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    logica.jogarCarta(jogador, carta, jogadorRival);
                }
            });

            cardButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        // Detalhes comuns para todas as cartas
                        String detalhesCarta = "Nome: " + carta.getNome() +
                                            "\nCusto de Mana: " + carta.getCustoMana() +
                                            "\nTipo de Carta: " + carta.getTipoCarta();

                        // Verifica o tipo da carta para adicionar mais informações
                        if (carta instanceof Criatura) {
                            Criatura criatura = (Criatura) carta;
                            detalhesCarta += "\nPoder: " + criatura.getPoder() +
                                            "\nHabilidade: " + criatura.getHabilidade() +
                                            "\nResistência: " + criatura.getResistencia();
                        } else if (carta instanceof Feitico) {
                            Feitico feitico = (Feitico) carta;
                            detalhesCarta += "\nEfeito: " + feitico.getEfeito();
                        } else if (carta instanceof Encantamento) {
                            Encantamento encantamento = (Encantamento) carta;
                            detalhesCarta += "\nEfeito: " + encantamento.getEfeito();
                        }

                        // Exibe os detalhes da carta no JOptionPane
                        JOptionPane.showMessageDialog(
                            frame, 
                            "Detalhes da Carta:\n" + detalhesCarta, 
                            "Detalhes da Carta", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            });
            playerMaoPanel.add(cardButton);
            playerMaoPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        }
        return playerMaoPanel;
    }

    public void atualizarPanelMao(Jogador jogador) {
        // Obtém o painel de mão do jogador
        JPanel playerPanel = jogador.equals(jogador1) ? game.getplayer1MaoPanel() : game.getplayer2MaoPanel();
        
        // Remove todas as cartas do painel
        playerPanel.removeAll();
    
        // Reconstrói o painel com as cartas atualizadas
        for (Carta cartaAtual : jogador.getMao().getCartasMao()) {
            JButton cardButton = new JButton(cartaAtual.getNome() + " (Mana: " + cartaAtual.getCustoMana() + ")");
            cardButton.setPreferredSize(new Dimension(100, 60));
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    
            // Define a ação do botão para jogar a carta
            cardButton.addActionListener(e -> logica.jogarCarta(jogador, cartaAtual, jogador.equals(jogador1) ? jogador2 : jogador1));

            // Adicionando MouseListener para clique com botão direito
            cardButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        // Detalhes comuns para todas as cartas
                        String detalhesCarta = "Nome: " + cartaAtual.getNome() +
                                            "\nCusto de Mana: " + cartaAtual.getCustoMana() +
                                            "\nTipo de Carta: " + cartaAtual.getTipoCarta();

                        // Verifica o tipo da carta para adicionar mais informações
                        if (cartaAtual instanceof Criatura) {
                            Criatura criatura = (Criatura) cartaAtual;
                            detalhesCarta += "\nPoder: " + criatura.getPoder() +
                                            "\nHabilidade: " + criatura.getHabilidade() +
                                            "\nResistência: " + criatura.getResistencia();
                        } else if (cartaAtual instanceof Feitico) {
                            Feitico feitico = (Feitico) cartaAtual;
                            detalhesCarta += "\nEfeito: " + feitico.getEfeito();
                        } else if (cartaAtual instanceof Encantamento) {
                            Encantamento encantamento = (Encantamento) cartaAtual;
                            detalhesCarta += "\nEfeito: " + encantamento.getEfeito();
                        }

                        // Exibe os detalhes da carta no JOptionPane
                        JOptionPane.showMessageDialog(
                            frame, 
                            "Detalhes da Carta:\n" + detalhesCarta, 
                            "Detalhes da Carta", 
                            JOptionPane.INFORMATION_MESSAGE
                        );
                    }
                }
            });
    
            // Adiciona o botão ao painel
            playerPanel.add(cardButton);
            playerPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        }
    
        // Atualiza o GUI do painel da mão
        playerPanel.revalidate();
        playerPanel.repaint();
    }

}
