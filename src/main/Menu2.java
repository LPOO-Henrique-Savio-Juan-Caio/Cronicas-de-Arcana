package main;

import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu2 {
    private JPanel panel1;
    DeckPadrao deckPadrao = new DeckPadrao();

    //vou deixar os atributos estaticos por enquanto pra testar
    public static String Jogador1;
    public static String Jogador2;
    private JButton deck1;
    private JButton deck2;
    private JLabel titulomenu2;
    private String[] deckJogador1;

    public Menu2(String Jogador1, String Jogador2) {
        //recebe o nome dos jogadores
        this.Jogador1 = Jogador1;
        this.Jogador2 = Jogador2;
        deck1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deckJogador1 = deckPadrao.getDeckPadrao1();
                Menu3 menu3 = new Menu3(Jogador1, Jogador2, deckJogador1);
                //e depois ir pra proxima pagina



            }
        });
        deck2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deckJogador1 = deckPadrao.getDeckPadrao2();
                Menu3 menu3 = new Menu3(Jogador1, Jogador2, deckJogador1);
                //e depois ir pra proxima pagina
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    //criar metodo static para testar tela:
    public static void main(String[] args) {

        JFrame frame = new JFrame("Menu");
        frame.setContentPane(new Menu2(Jogador1, Jogador2).getPanel1());
        frame.setMinimumSize(new Dimension(450,474));// Adiciona o painel da classe Menu
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// Configura para fechar ao clicar no 'X
        frame.pack();  // Ajusta o tamanho da janela para caber nos componentes
        frame.setVisible(true);  // Torna a janela visível
    }
}
//decidi criar 2 decks padroes, o jogador 1 escolhe nesse menu, e o jogador 2 escolhe no proximo
