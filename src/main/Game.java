
package main;

import CronicasDeArcana.Carta;
import CronicasDeArcana.Jogador;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

// oq falta: 
// trocar as cartas da mao
// quando a mana for mt pequena mudar o turno

public class Game {

    private Jogador jogador1;
    private Jogador jogador2;
    private boolean isTurnoJogador1 = true;
    private boolean manaInsuficiente = true;

    private JFrame frame;
    private JPanel panel1;
    private JLabel playerInfo1, playerInfo2;
    private JPanel player1CardsPanel, player2CardsPanel;

    public Game(String nome1, String nome2, String[] deckJogador1, String[] deckJogador2, JFrame frame) {
        this.frame = frame;

        jogador1 = new Jogador(nome1, new CartasJogo().getArrayCartas(), deckJogador1);
        jogador2 = new Jogador(nome2, new CartasJogo().getArrayCartas(), deckJogador2);

        initUI();
        gameStart();
    }

    private void initUI() {
        panel1 = new JPanel(new BorderLayout());
        panel1.setBackground(Color.BLACK);

        JPanel playerInfoPanel = new JPanel(new BorderLayout());
        playerInfoPanel.setBackground(Color.BLACK);

        playerInfo1 = new JLabel(createPlayerInfo(jogador1));
        setupPlayerLabel(playerInfo1);
        JPanel player1Panel = new JPanel();
        player1Panel.setBackground(Color.BLACK);
        player1Panel.add(playerInfo1);

        playerInfo2 = new JLabel(createPlayerInfo(jogador2));
        setupPlayerLabel(playerInfo2);
        JPanel player2Panel = new JPanel();
        player2Panel.setBackground(Color.BLACK);
        player2Panel.add(playerInfo2);

        playerInfoPanel.add(player1Panel, BorderLayout.WEST);
        playerInfoPanel.add(player2Panel, BorderLayout.EAST);
        panel1.add(playerInfoPanel, BorderLayout.NORTH);

        player1CardsPanel = createPlayerCardsPanel(jogador1, jogador2);
        player2CardsPanel = createPlayerCardsPanel(jogador2, jogador1);

        panel1.add(player1CardsPanel, BorderLayout.WEST);
        panel1.add(player2CardsPanel, BorderLayout.EAST);
    }

    private JPanel createPlayerCardsPanel(Jogador jogador, Jogador jogadorRival) {
        JPanel playerCardsPanel = new JPanel();
        playerCardsPanel.setLayout(new BoxLayout(playerCardsPanel, BoxLayout.Y_AXIS));
        playerCardsPanel.setBackground(Color.BLACK);

        for (Carta carta : jogador.getMao().getCartasMao()) {
            JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
            cardButton.setPreferredSize(new Dimension(80, 40));
            cardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            cardButton.addActionListener(new ActionListener() {
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    jogarCarta(jogador, carta, jogadorRival);
                }
            });
            playerCardsPanel.add(cardButton);
            playerCardsPanel.add(Box.createRigidArea(new Dimension(0, 30)));
        }
        return playerCardsPanel;
    }

    private void setupPlayerLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(Color.WHITE);
    }

    private String createPlayerInfo(Jogador jogador) {
        return "<html>" + jogador.getNome() + "<br>Vida: " + jogador.getVida() + "<br>Mana: " + jogador.getMana() + "</html>";
    }

    private void jogarCarta(Jogador jogador, Carta carta, Jogador jogadorRival) {
        if (isTurnoJogador1 && jogador.equals(jogador1) || !isTurnoJogador1 && jogador.equals(jogador2)) {

            if (jogador.getMana() >= carta.getCustoMana()) {
                jogador.alterarMana(carta);
                jogadorRival.alterarVida(carta);

                atualizarPainelJogadores();
                passarTurno();
            } else {
                JOptionPane.showMessageDialog(frame, "Mana insuficiente!");
            }
        } else {
            JOptionPane.showMessageDialog(frame, "Não é o seu turno!");
        }
    }
        

          

    private void atualizarPainelJogadores() {
        playerInfo1.setText(createPlayerInfo(jogador1));
        playerInfo2.setText(createPlayerInfo(jogador2));
        frame.revalidate();
        frame.repaint();
    }

    private void passarTurno() {
        isTurnoJogador1 = !isTurnoJogador1;
    
        // Checa as condições de vitória:
        if (jogador1.getVida() <= 0) {
            JOptionPane.showMessageDialog(frame, "Vitória de " + jogador2.getNome()); 
            frame.dispose(); 
            return;
        } else if (jogador2.getVida() <= 0) {
            JOptionPane.showMessageDialog(frame, "Vitória de " + jogador1.getNome()); 
            frame.dispose(); 
            return;
        }
    
        // Verifica mana no início do turno:
        Jogador jogadorAtual = isTurnoJogador1 ? jogador1 : jogador2;
        Jogador proximoJogador = isTurnoJogador1 ? jogador2 : jogador1;
        if (verificarMana(jogadorAtual) && verificarMana(proximoJogador)) {
            JOptionPane.showMessageDialog(frame, "Mana insuficiente para ambos, EMPATE");
            frame.dispose();  // Chama recursivamente para passar para o próximo turno
        } 
        else if (verificarMana(jogadorAtual)) { 
            JOptionPane.showMessageDialog(frame, "Mana insuficiente para " + jogadorAtual.getNome() + ". Pulando turno...");
            passarTurno();
        }
        else {
            JOptionPane.showMessageDialog(frame, "Turno de " + jogadorAtual.getNome());
        }
    }

    private boolean  verificarMana(Jogador jogador) {
        manaInsuficiente = true; // Supõe que a mana é insuficiente inicialmente
    
        for (Carta carta : jogador.getMao().getCartasMao()) {
            if (jogador.getMana() >= carta.getCustoMana()) {
                manaInsuficiente = false; // Suficiente para pelo menos uma carta
                return manaInsuficiente; // Interrompe o loop, já que encontramos uma carta jogável
            }

        
        }

        return manaInsuficiente;
    }

    public void gameStart() {
        frame.setContentPane(this.panel1);
        frame.setMinimumSize(new Dimension(800, 474));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
