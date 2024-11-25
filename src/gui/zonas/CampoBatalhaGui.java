package gui.zonas;

import entidades.Jogador;
import entidades.carta.Carta;
import main.Game;
import logica.Logica;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import static gui.menu.TelaInicial.fonteCustomizada1;

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
        playerCampoBatalhaPanel.setLayout(null);
        playerCampoBatalhaPanel.setBackground(new Color(0, 0, 0, 0));

        int x = 36; // Posição inicial X
        int y = 28; // Posição inicial Y
        int incrementoY = 123; // Incremento vertical para cada botão
        int buttonWidth = 130;//x
        int buttonHeight = 90;//y
        int totalHeight = 630;
        int panelWidth = 150;

        for(Carta carta : jogador.getCampoBatalha().getCartasNoCampo()){
            JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
            fonteCustomizada1 = fonteCustomizada1.deriveFont(Font.PLAIN, 10);
            cardButton.setFont(fonteCustomizada1);
            cardButton.setBounds(x, y, buttonWidth, buttonHeight);
            cardButton.setBackground(Color.BLACK);
            cardButton.setForeground(Color.WHITE);
            cardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //função usada para dar dano tanto no jogador como nas cartas que estao no campo
                    logica.usarCartaNoCampoBatalha(jogador, carta, jogadorRival );
                }
            });
            y += incrementoY;
            playerCampoBatalhaPanel.add(cardButton);
        }

        playerCampoBatalhaPanel.setPreferredSize(new Dimension(panelWidth, totalHeight));
        return playerCampoBatalhaPanel;

    }

    public void atualizarCampoBatalhaPanel(Jogador jogador, JPanel campoBatalhaPanel, Jogador jogadorRival) {
        //remove as cartas do panel
        campoBatalhaPanel.removeAll();
    
        //lista para armazenar cartas com vida <= 0
        List<Carta> cartasParaRemover = new ArrayList<>();

        int x = 36; // Posição inicial X
        int y = 28; // Posição inicial Y
        int incrementoY = 123; // Incremento vertical para cada botão
        int buttonWidth = 130;
        int buttonHeight = 90;

        //itera sobre as cartas no campo de batalha
        for (Carta carta : jogador.getCampoBatalha().getCartasNoCampo()) {
            //verifica se as cartas estao vivas
            if (carta.getResistencia() > 0) {
                //cria gui da carta
                JPanel cartaPanel = new JPanel();
                cartaPanel.setLayout(null);
                cartaPanel.setBackground(new Color(0,0,0, 0));

                JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
                fonteCustomizada1 = fonteCustomizada1.deriveFont(Font.PLAIN, 10); // Ajuste o tamanho conforme necessário
                cardButton.setFont(fonteCustomizada1);
                cardButton.setBounds(x, y, buttonWidth, buttonHeight);
                cardButton.setBackground(Color.BLACK);
                cardButton.setForeground(Color.WHITE);
                cardButton.addActionListener(e -> logica.usarCartaNoCampoBatalha(jogador, carta, jogadorRival ));
                campoBatalhaPanel.add(cardButton);
                y += incrementoY;
    
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
}
