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
import static gui.menu.TelaInicial.fonteCustomizada1;

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

    /**
     * Cria um painel de mão para um jogador com posicionamento vertical.
     *
     * @param jogador      O jogador cujo painel de mão está sendo criado.
     * @param jogadorRival O jogador rival.
     * @param initialX     Posição X inicial dos botões.
     * @param initialY     Posição Y inicial dos botões.
     * @return JPanel configurado com os botões das cartas.
     */
    public JPanel createMaoPanel(Jogador jogador, Jogador jogadorRival, int initialX, int initialY) {
        JPanel playerMaoPanel = new JPanel();
        playerMaoPanel.setLayout(null); // Layout absoluto
        playerMaoPanel.setBackground(new Color(0, 0, 0, 0));

        int x = initialX; // Posição inicial X
        int y = initialY; // Posição inicial Y
        int incrementoY = 108; // Incremento vertical para cada botão
        int buttonWidth = 117;
        int buttonHeight = 80;

        // Calcular a largura e altura necessárias para o painel
        int totalHeight = 630;
        int panelWidth = 150; // Ajuste conforme necessário

        fonteCustomizada1 = fonteCustomizada1.deriveFont(Font.PLAIN, 15);

        for (Carta carta : jogador.getMao().getCartasMao()) {
            JButton cardButton = new JButton(carta.getNome() + " (Mana: " + carta.getCustoMana() + ")");
            cardButton.setFont(fonteCustomizada1);
            cardButton.setBounds(x, y, buttonWidth, buttonHeight); // Define a posição e tamanho do botão
            cardButton.setBackground(Color.BLACK);
            cardButton.setForeground(Color.WHITE);

            // Define a ação do botão para jogar a carta
            cardButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    logica.jogarCarta(jogador, carta, jogadorRival);
                }
            });

            // Adiciona MouseListener para clique com botão direito
            cardButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        exibirDetalhesCarta(carta);
                    }
                }
            });

            playerMaoPanel.add(cardButton);
            y += incrementoY; // Atualiza a posição vertical para o próximo botão
        }

        // Define o tamanho preferido do painel com base no número de cartas
        playerMaoPanel.setPreferredSize(new Dimension(panelWidth, totalHeight));

        return playerMaoPanel;
    }

    /**
     * Atualiza o painel de mão de um jogador.
     *
     * @param jogador O jogador cujo painel de mão será atualizado.
     */
    public void atualizarPanelMao(Jogador jogador) {
        // Obtém o painel de mão correspondente ao jogador
        JPanel playerPanel = jogador.equals(jogador1) ? game.getplayer1MaoPanel() : game.getplayer2MaoPanel();

        // Remove todas as cartas do painel
        playerPanel.removeAll();
        playerPanel.setLayout(null); // Layout absoluto
        playerPanel.setBackground(new Color(0, 0, 0, 0));

        // Define posições iniciais com base no jogador
        int initialX, initialY;
        if (jogador.equals(jogador1)) {
            initialX = 33;
            initialY = 4;
        } else {
            initialX = 5;
            initialY = 130;
        }

        int x = initialX; // Posição inicial X
        int y = initialY; // Posição inicial Y
        int incrementoY = 108; // Incremento vertical para cada botão
        int buttonWidth = 117;
        int buttonHeight = 80;

        fonteCustomizada1 = fonteCustomizada1.deriveFont(Font.PLAIN, 15);

        // Calcular a largura e altura necessárias para o painel
        int totalHeight = 630;
        int panelWidth = 150; // Ajuste conforme necessário

        // Reconstrói o painel com as cartas atualizadas
        for (Carta cartaAtual : jogador.getMao().getCartasMao()) {
            JButton cardButton = new JButton(cartaAtual.getNome() + " (Mana: " + cartaAtual.getCustoMana() + ")");
            cardButton.setBounds(x, y, buttonWidth, buttonHeight); // Define posição e tamanho
            cardButton.setBackground(Color.BLACK);
            cardButton.setForeground(Color.WHITE);
            cardButton.setFont(fonteCustomizada1);

            // Define a ação do botão para jogar a carta
            cardButton.addActionListener(e -> logica.jogarCarta(jogador, cartaAtual, jogador.equals(jogador1) ? jogador2 : jogador1));

            // Adicionando MouseListener para clique com botão direito
            cardButton.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        exibirDetalhesCarta(cartaAtual);
                    }
                }
            });

            // Adiciona o botão ao painel
            playerPanel.add(cardButton);
            y += incrementoY; // Atualiza a posição vertical para o próximo botão
        }

        // Define o tamanho preferido do painel com base no número de cartas
        playerPanel.setPreferredSize(new Dimension(panelWidth, totalHeight));

        // Atualiza o GUI do painel da mão
        playerPanel.revalidate();
        playerPanel.repaint();
    }

    /**
     * Exibe os detalhes de uma carta em um JOptionPane.
     *
     * @param carta A carta cujos detalhes serão exibidos.
     */
    private void exibirDetalhesCarta(Carta carta) {
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
            detalhesCarta += "\nEfeito: " + interpretarEfeito(feitico.getEfeito());
        } else if (carta instanceof Encantamento) {
            Encantamento encantamento = (Encantamento) carta;
            detalhesCarta += "\nEfeito: " + interpretarEfeito(encantamento.getEfeito());
        }

        // Exibe os detalhes da carta no JOptionPane
        JOptionPane.showMessageDialog(
                frame,
                "Detalhes da Carta:\n" + detalhesCarta,
                "Detalhes da Carta",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    /**
     * Interpreta o efeito da carta para exibição.
     *
     * @param efeito O efeito da carta como String.
     * @return Uma descrição legível do efeito.
     */
    private String interpretarEfeito(String efeito) {
        switch (efeito) {
            case "muito_dano":
            case "dano":
                return "dano";
            case "muita_mana":
            case "mana":
                return "mana";
            case "muita_vida":
            case "vida":
                return "vida";
            default:
                return "reviver";
        }
    }
}
