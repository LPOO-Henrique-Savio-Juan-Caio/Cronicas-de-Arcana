package gui.menu;

//importações
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import cartas.DeckPadrao;
import java.util.ArrayList;
import gui.background.BackgroundPanel;

public class EscolhaDeck1 {

    private JPanel panel1;

    //classe com decks padroes (String)
    DeckPadrao deckPadrao = new DeckPadrao();

    private ArrayList<String> deckJogador1 = new ArrayList<>();
    private String Jogador1;
    private String Jogador2;

    //variaveis do GUI
    private JButton deck1Botao;
    private JButton deck2Botao;
    private JLabel titulomenu2;

    private JFrame frame;

    public EscolhaDeck1(String Jogador1, String Jogador2, JFrame frame) {
        this.frame = TelaInicial.getFrame();
        //recebe o nome dos jogadores
        this.Jogador1 = Jogador1;
        this.Jogador2 = Jogador2;

        //obs: o layout GridBagLayout funciona através de celular, é meio difícil...

        //conteiner da tela
        panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        panel1.setBackground(Color.WHITE);

        //titulo
        JLabel titulomenu2 = new JLabel(Jogador1 + " ESCOLHA SEU DECK:");
        try {
            Font fontePersonalizada = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("arquivos/fonte/GODOFWAR.TTF")).deriveFont(26f);
            titulomenu2.setFont(fontePersonalizada); // Aplica a fonte personalizada
        } catch (Exception e) {
            titulomenu2.setFont(new Font("Times New Roman", Font.BOLD, 26)); // Fallback caso falhe o carregamento da fonte
        }
        titulomenu2.setForeground(Color.BLACK);

        // posições do título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(20, 0, 20, 0); // Espaçamento superior e inferior
        gbc.anchor = GridBagConstraints.NORTH; // Garante que o título fique no topo
        panel1.add(titulomenu2, gbc);

        // botao deck1
        deck1Botao = new JButton("Deck1");
        try {
            Font fontePersonalizada = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/path/to/GODOFWAR.TTF")).deriveFont(15f);
            deck1Botao.setFont(fontePersonalizada); // Aplica a fonte personalizada
        } catch (Exception e) {
            deck1Botao.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Fallback caso falhe o carregamento da fonte
        }
        deck1Botao.setBackground(Color.BLACK);
        deck1Botao.setForeground(Color.WHITE);
        deck1Botao.setPreferredSize(new Dimension(120, 180)); // Aumenta o tamanho do botão

        //posição deck1
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(10, 10, 10, 10); // Define espaçamento ao redor do botão
        panel1.add(deck1Botao, gbc);

        // botao deck2
        deck2Botao = new JButton("Deck2");
        try {
            Font fontePersonalizada = Font.createFont(Font.TRUETYPE_FONT, getClass().getResourceAsStream("/path/to/GODOFWAR.TTF")).deriveFont(15f);
            deck2Botao.setFont(fontePersonalizada); // Aplica a fonte personalizada
        } catch (Exception e) {
            deck2Botao.setFont(new Font("Times New Roman", Font.BOLD, 15)); // Fallback caso falhe o carregamento da fonte
        }
        deck2Botao.setBackground(Color.BLACK);
        deck2Botao.setForeground(Color.WHITE);
        deck2Botao.setPreferredSize(new Dimension(120, 180)); // Aumenta o tamanho do botão

        //posição deck2
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel1.add(deck2Botao, gbc);

        //ações dos botoes:
        deck1Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //jogador1 escolhe deck1
                deckJogador1 = deckPadrao.getDeckPadrao1();

                //vai pro proximo menu(escolha do prox jogador)
                EscolhaDeck2 menu3 = new EscolhaDeck2(Jogador1, Jogador2, deckJogador1, frame);
                menu3.menu3Start();
            }
        });
        deck2Botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //jogador1 escolhe deck2
                deckJogador1 = deckPadrao.getDeckPadrao2();

                //vai pro proximo menu(escolha do prox jogador)
                EscolhaDeck2 menu3 = new EscolhaDeck2(Jogador1, Jogador2, deckJogador1, frame);
                menu3.menu3Start();
            }
        });
    }

    //metodo atualizado para ficar em 1024x768 fixo
    public void menu2Start() {
        frame.setContentPane(new EscolhaDeck1(Jogador1, Jogador2, frame).panel1); // Adiciona o painel da interface
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fecha o programa ao clicar em "X"

        // Define a resolução com proporção 4:3 (por exemplo, 1024x768)
        Dimension resolution4x3 = new Dimension(1024, 768);
        frame.setMinimumSize(resolution4x3); // Define o tamanho mínimo da janela
        frame.setSize(resolution4x3); // Define o tamanho inicial da janela
        frame.setMaximumSize(resolution4x3); // Define o tamanho máximo para manter a proporção

        frame.setVisible(true); // Exibe a janela
    }
}
