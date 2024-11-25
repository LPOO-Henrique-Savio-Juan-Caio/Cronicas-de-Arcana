package gui.menu;

import gui.background.BackgroundPanel;
import static soundTrack.SoundManager.playSoundEffect;
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
    private static JFrame frame;
    public static Font fonteCustomizada1;
    public TelaInicial(JFrame frame) {
        this.frame = frame;

        // Container da tela
        Image backgroundImage = new ImageIcon("arquivos/imagens/telaInicialFundo.jpeg").getImage();

        // Inicializa o painel com a imagem de fundo
        panel1 = new BackgroundPanel(backgroundImage);
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Título da tela
        // Carregar a mesma fonte personalizada para o botão "JOGAR"
        try {
            fonteCustomizada1 = Font.createFont(Font.TRUETYPE_FONT, new File("arquivos/fonte/GODOFWAR.TTF"));
            fonteCustomizada1 = fonteCustomizada1.deriveFont(Font.PLAIN, 20); // Ajuste o tamanho conforme necessário
            
            // Botão de jogar
            jogarButton = new JButton("JOGAR");
            jogarButton.setFont(fonteCustomizada1); // Aplicando a fonte personalizada ao botão
            jogarButton.setBackground(Color.BLACK);
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
        gbc.fill = GridBagConstraints.NONE; // Não preenche o espaço horizontal
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1; // Definir largura específica (não ocupar toda a largura da linha)
        gbc.insets = new Insets(300, 200, 30, 150); // Adicionar uma margem
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

    public void menuStart() {
        frame.setTitle("Cronicas de Arcana");
        frame.setContentPane(panel1); // Adiciona o painel da interface
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao clicar em "X"

        // Define a resolução fixa
        Dimension resolution4x3 = new Dimension(1024, 768);
        frame.setMinimumSize(resolution4x3); // Define o tamanho mínimo da janela
        frame.setSize(resolution4x3); // Define o tamanho inicial da janela
        frame.setMaximumSize(resolution4x3); // Define o tamanho máximo para manter a proporção
        frame.setResizable(false);
        frame.setVisible(true);
    }

    // Metodo para iniciar o menu InserirNomes
    private void iniciarInserirNomes() {
        // Cria uma nova instância de InserirNomes e inicia a tela
    	new Thread(() -> playSoundEffect("arquivos/soundtracks/clickButtom01.wav")).start();
        InserirNomes inserirNomes = new InserirNomes(frame);
        inserirNomes.menuStart(); // Chama o metodo de iniciar a tela InserirNomes
    }

    public static JFrame getFrame(){
        return frame;
    }
}
