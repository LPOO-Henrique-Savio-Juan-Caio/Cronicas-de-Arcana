package main;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private JPanel titleNamePanel, startButtonPanel;
    private JLabel titleNameLabel;
    private Font titleFont = new Font("Times New Roman", Font.PLAIN, 70);
    private Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
    private JButton startButton;

    // Adiciona os componentes ao painel fornecido
    public void addComponentsToPanel(JPanel panel) {
        // Inicializa os paineis
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(150, 100, 800, 150); // Posição e tamanho
        titleNamePanel.setBackground(Color.black);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(150, 300, 800, 50); // Posição e tamanho
        startButtonPanel.setBackground(Color.black);

        // Inicializa o label de título
        titleNameLabel = new JLabel("CRONICAS DE ARCANA");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        // Inicializa o botão
        startButton = new JButton("START");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.RED);
        startButton.setFont(normalFont);

        startButton.setBorder(BorderFactory.createEmptyBorder());

        // Adiciona o label ao painel de título
        titleNamePanel.add(titleNameLabel);
        // Adiciona o botão ao painel do botão
        startButtonPanel.add(startButton);

        // Adiciona os paineis ao painel principal
        panel.add(titleNamePanel);
        panel.add(startButtonPanel);
    }
}
