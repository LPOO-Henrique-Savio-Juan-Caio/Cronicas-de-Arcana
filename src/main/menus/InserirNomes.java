package main.menus;

//importações
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;





public class InserirNomes {

    // componentes do GUI
    private JPanel panel1;
    private JTextField nomeJogador1;
    private JTextField nomeJogador2;
    private JButton continuarButton;
    private JFrame frame;

    
    public InserirNomes(JFrame frame) {
        this.frame = frame; 
        //obs: o laytou GridBagLayout funciona atraves de celular, é meio paia...
        
        //conteiner da tela
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel1.setBackground(Color.BLACK);

        //titulo da tela
        JLabel titleLabel = new JLabel("CRÔNICAS DE ARCANA");
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
        titleLabel.setForeground(Color.WHITE);

        //posição do titulo
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel1.add(titleLabel, gbc);

        //titulo do primeiro campo de texto
        JLabel jogador1Label = new JLabel("JOGADOR 1:");
        jogador1Label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jogador1Label.setForeground(Color.WHITE);

        //posição
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel1.add(jogador1Label, gbc);

        //campo de texto
        nomeJogador1 = new JTextField(15); // Campo para o nome do Jogador 1
        //posição
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel1.add(nomeJogador1, gbc);

        //titulo segundo campo de texto
        JLabel jogador2Label = new JLabel("JOGADOR 2:");
        jogador2Label.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jogador2Label.setForeground(Color.WHITE);
        //posição
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel1.add(jogador2Label, gbc);

        //campo de texto 2
        nomeJogador2 = new JTextField(15); // Campo para o nome do Jogador 2
        //posição
        gbc.gridx = 1;
        gbc.gridy = 3;
        panel1.add(nomeJogador2, gbc);

        //botao de continuar
        continuarButton = new JButton("Continuar");
        continuarButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
        continuarButton.setBackground(Color.BLACK);
        continuarButton.setForeground(Color.WHITE);
        //posição
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel1.add(continuarButton, gbc);

        //ação do botao
        continuarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //pega os textos (nome dos jogadores)
                String jogador1Nome = nomeJogador1.getText();
                String jogador2Nome = nomeJogador2.getText(); 

                // instancia e inicia o proximo menu ja com o nome dos jogadores
                EscolhaDeck1 menu2 = new EscolhaDeck1(jogador1Nome, jogador2Nome, frame);
                menu2.menu2Start();
                frame.dispose(); 
                
            }
        });
    }

    //tela
    public void menuStart() {
        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new InserirNomes(frame).panel1); // Adiciona o painel da interface
        frame.setMinimumSize(new Dimension(450, 474)); // Define o tamanho mínimo da janela
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao clicar em "X"
        frame.pack(); // Ajusta o tamanho da janela automaticamente
        frame.setVisible(true); // Exibe a janela
    }

   
       
}