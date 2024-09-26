package main;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;
    Menu menu;

    public GamePanel() {
        setPreferredSize(new Dimension(1100, 800));
        setBackground(Color.black);
        setLayout(null); // Para posicionamento absoluto dos componentes

        // Inicializar o menu e adicionar os componentes ao painel
        menu = new Menu();
        menu.addComponentsToPanel(this);
    }

    public void launchGame() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / 60; // 60 FPS
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    private void update() {
        // Adicione lógica de atualização aqui, se necessário
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // Desenha o fundo preto e os componentes Swing
    }
}
