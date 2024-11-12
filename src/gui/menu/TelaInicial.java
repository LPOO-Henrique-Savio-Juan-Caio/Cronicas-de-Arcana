package gui.menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class TelaInicial {

    private JPanel panel1;
    private JButton jogarButton;
    private JFrame frame;

    public TelaInicial(JFrame frame) {
        this.frame = frame;

        // Container da tela
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel1.setBackground(new Color(0, 128, 0)); // Verde escuro de fundo

        // Título da tela
        JLabel titleLabel = new JLabel("CRONICAS DE ARCANA");
        try {
            // Carregar a fonte personalizada
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("arquivos/fonte/GODOFWAR.TTF"));
            customFont = customFont.deriveFont(Font.PLAIN, 60); // Defina o tamanho da fonte conforme desejado

            // Aplicar a fonte personalizada ao JLabel
            titleLabel.setFont(customFont); // Aplicando a fonte personalizada
            titleLabel.setForeground(Color.RED); // Cor vermelha para o título
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            // Caso ocorra algum erro ao carregar a fonte, uma fonte padrão será usada
            titleLabel.setFont(new Font("Serif", Font.BOLD, 60)); // Fonte padrão
            titleLabel.setForeground(Color.RED); // Cor vermelha para o título
        }

        // Posição do título (centralizado no topo)
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 10, 200, 10); // Ajustando a margem superior
        gbc.anchor = GridBagConstraints.CENTER; // Centraliza o texto
        panel1.add(titleLabel, gbc);

        // Carregar a mesma fonte personalizada para o botão "JOGAR"
        try {
            Font customFontButton = Font.createFont(Font.TRUETYPE_FONT, new File("arquivos/fonte/GODOFWAR.TTF"));
            customFontButton = customFontButton.deriveFont(Font.PLAIN, 20); // Ajuste o tamanho conforme necessário

            // Botão de jogar
            jogarButton = new JButton("JOGAR");
            jogarButton.setFont(customFontButton); // Aplicando a fonte personalizada ao botão
            jogarButton.setBackground(Color.BLUE);
            jogarButton.setForeground(Color.WHITE);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
            // Caso ocorra algum erro ao carregar a fonte, uma fonte padrão será usada
            jogarButton = new JButton("JOGAR");
            jogarButton.setFont(new Font("Times New Roman", Font.BOLD, 20)); // Fonte padrão
            jogarButton.setBackground(Color.BLUE);
            jogarButton.setForeground(Color.WHITE);
        }

        // Posição do botão
        // Alterar o comportamento do GridBagConstraints para o botão
        gbc.fill = GridBagConstraints.NONE; // Não preenche o espaço horizontal
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Definir largura específica (não ocupar toda a largura da linha)
        gbc.insets = new Insets(10, 335, 10, 10); // Adicionar uma margem em torno do botão
        panel1.add(jogarButton, gbc);


        // Borda do painel
        Border bordaPreta = BorderFactory.createLineBorder(Color.BLACK, 3);
        panel1.setBorder(bordaPreta);

        // Ação do botão "JOGAR"
        jogarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Chama o metodo para iniciar o menu de InserirNomes
                iniciarInserirNomes();
            }
        });
    }

    // Metodo para inicializar a tela inicial
    public void menuStart() {
        frame.setTitle("Cronicas de Arcana");
        frame.setContentPane(panel1); // Adiciona o painel da interface
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao clicar em "X"

        // Define a resolução com proporção 4:3 (por exemplo, 1024x768)
        Dimension resolution4x3 = new Dimension(1024, 768);
        frame.setMinimumSize(resolution4x3); // Define o tamanho mínimo da janela
        frame.setSize(resolution4x3); // Define o tamanho inicial da janela
        frame.setMaximumSize(resolution4x3); // Define o tamanho máximo para manter a proporção

        frame.setVisible(true); // Exibe a janela
    }


    // Método para iniciar o menu InserirNomes
    private void iniciarInserirNomes() {
        // Cria uma nova instância de InserirNomes e inicia a tela
        InserirNomes inserirNomes = new InserirNomes(frame);
        inserirNomes.menuStart(); // Chama o método de iniciar a tela InserirNomes
        frame.dispose();
    }
}
