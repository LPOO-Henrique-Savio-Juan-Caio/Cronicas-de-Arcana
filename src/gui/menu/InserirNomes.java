package gui.menu;

import static gui.menu.TelaInicial.fonteCustomizada1;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import static soundTrack.SoundManager.playSoundEffect;

public class InserirNomes {

    // componentes do GUI
    private JPanel panel1;
    private JTextField nomeJogador1;
    private JTextField nomeJogador2;
    private JButton continuarButton;
    private JFrame frame;

    public InserirNomes(JFrame frame) {
        this.frame = TelaInicial.getFrame();

        // Conteiner da tela
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel1.setBackground(Color.WHITE);

        // Carrega a fonte customizada
        Font customFont;
        customFont = fonteCustomizada1;
        JLabel titleLabel = new JLabel("INSIRA OS NOMES DOS JOGADORES: ");
        titleLabel.setFont(customFont.deriveFont(Font.BOLD, 26)); // Define tamanho maior para o título
        titleLabel.setForeground(Color.BLACK);

        // Posição do título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel1.add(titleLabel, gbc);

        // Título do primeiro campo de texto
        JLabel jogador1Label = new JLabel("JOGADOR 1:");
        jogador1Label.setFont(customFont); // Define fonte customizada para o rótulo
        jogador1Label.setForeground(Color.BLACK);

        // Posição
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel1.add(jogador1Label, gbc);

        // Campo de texto para jogador 1
        nomeJogador1 = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(nomeJogador1, gbc);

        // Título do segundo campo de texto
        JLabel jogador2Label = new JLabel("JOGADOR 2:");
        jogador2Label.setFont(customFont); // Define fonte customizada para o rótulo
        jogador2Label.setForeground(Color.BLACK);

        // Posição
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(jogador2Label, gbc);

        // Campo de texto para jogador 2
        nomeJogador2 = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel1.add(nomeJogador2, gbc);

        // Botão de continuar
        continuarButton = new JButton("Continuar");
        continuarButton.setFont(customFont); // Aplica a fonte customizada ao botão
        continuarButton.setBackground(Color.BLACK);
        continuarButton.setForeground(Color.WHITE);

        // Posição do botão
        gbc.gridx = 1;
        gbc.gridy = 5;
        //gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(continuarButton, gbc);

        Border bordaPreta = BorderFactory.createLineBorder(Color.BLACK, 3);
        panel1.setBorder(bordaPreta);

        // Ação do botão continuar
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String jogador1Nome = nomeJogador1.getText();
                String jogador2Nome = nomeJogador2.getText();

                //verificacao para nome vazio
                if(jogador1Nome.isEmpty() || jogador2Nome.isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Os nomes dos jogadores não podem estar em branco.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                //verificacao para nomes iguais
                else if( jogador1Nome.equals(jogador2Nome)){
                    JOptionPane.showMessageDialog(frame, "Os nomes dos jogadores não podem ser iguais.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                else{
                    // Inicia o próximo menu com os nomes dos jogadores
                EscolhaDeck1 menu2 = new EscolhaDeck1(jogador1Nome, jogador2Nome, frame);
                menu2.menu2Start();

                }
            }
        });
    }

    // Inicia o menu
    public void menuStart() {
    	new Thread(() -> playSoundEffect("arquivos/soundtracks/clickButtom01.wav")).start();
        frame.setContentPane(new InserirNomes(frame).panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Define a resolução com proporção 4:3
        Dimension resolution4x3 = new Dimension(1024, 768);
        frame.setMinimumSize(resolution4x3);
        frame.setSize(resolution4x3);
        frame.setMaximumSize(resolution4x3);
        frame.setVisible(true);
    }

}