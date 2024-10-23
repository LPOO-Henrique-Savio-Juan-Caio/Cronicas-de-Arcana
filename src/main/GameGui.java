
package main;


import CronicasDeArcana.Carta;
import CronicasDeArcana.Jogador;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class GameGui extends javax.swing.JFrame {

    CartasJogo cartasjogo = new CartasJogo();


    private String nome1;
    private String nome2;
    private String[] deckJogador1;
    private String[] deckJogador2;


    private Jogador jogador1;
    private Jogador jogador2;



    public GameGui(String nome1, String nome2, List<Carta> arrayCartas, String[] deckJogador1, String[] deckJogador2) {
        initComponents();
    //iniciando os atributos

        this.nome1 = nome1;
        this.nome2 = nome2;
        this.deckJogador1 = deckJogador1;
        this.deckJogador2 = deckJogador2;



        //criando jogadores
        jogador1 = new Jogador(nome1, cartasjogo.getArrayCartas(), deckJogador1) ;
        jogador2 = new Jogador(nome2, cartasjogo.getArrayCartas(), deckJogador2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Carta2Jogador1 = new javax.swing.JButton();
        Carta1Jogador2 = new javax.swing.JButton();
        Carta4Jogador1 = new javax.swing.JButton();
        Carta3Jogador1 = new javax.swing.JButton();
        Carta5Jogador1 = new javax.swing.JButton();
        Carta1Jogador1 = new javax.swing.JButton();
        Carta3Jogador2 = new javax.swing.JButton();
        Carta4Jogador2 = new javax.swing.JButton();
        Carta5Jogador2 = new javax.swing.JButton();
        Carta2Jogador2 = new javax.swing.JButton();
        NomeJogador1 = new javax.swing.JLabel();
        NomeJogador2 = new javax.swing.JLabel();
        VidaJogador2 = new javax.swing.JLabel();
        VidaJogador1 = new javax.swing.JLabel();
        ManaJogador1 = new javax.swing.JLabel();
        ManaJogador2 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel5.setText("Vida:");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);




        Carta2Jogador1.setText("jButton1");
        Carta2Jogador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta2Jogador1ActionPerformed(evt);
            }
        });

        Carta1Jogador2.setText("jButton1");
        Carta1Jogador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta1Jogador2ActionPerformed(evt);
            }
        });

        Carta4Jogador1.setText("jButton1");
        Carta4Jogador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta4Jogador1ActionPerformed(evt);
            }
        });

        Carta3Jogador1.setText("jButton1");
        Carta3Jogador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta3Jogador1ActionPerformed(evt);
            }
        });

        Carta5Jogador1.setText("jButton1");
        Carta5Jogador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta5Jogador1ActionPerformed(evt);
            }
        });

        Carta1Jogador1.setText("jButton1");
        Carta1Jogador1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta1Jogador1ActionPerformed(evt);
            }
        });

        Carta3Jogador2.setText("jButton1");
        Carta3Jogador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta3Jogador2ActionPerformed(evt);
            }
        });

        Carta4Jogador2.setText("jButton1");
        Carta4Jogador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta4Jogador2ActionPerformed(evt);
            }
        });

        Carta5Jogador2.setText("jButton1");
        Carta5Jogador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta5Jogador2ActionPerformed(evt);
            }
        });

        Carta2Jogador2.setText("jButton1");
        Carta2Jogador2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Carta2Jogador2ActionPerformed(evt);
            }
        });

        NomeJogador1.setForeground(new java.awt.Color(255, 255, 255));
        NomeJogador1.setText("NomeJogador1");

        NomeJogador2.setForeground(new java.awt.Color(255, 255, 255));
        NomeJogador2.setText("NomeJogador2");

        VidaJogador2.setForeground(new java.awt.Color(255, 255, 255));
        VidaJogador2.setText("Vida:");

        VidaJogador1.setForeground(new java.awt.Color(255, 255, 255));
        VidaJogador1.setText("Vida:");

        ManaJogador1.setForeground(new java.awt.Color(255, 255, 255));
        ManaJogador1.setText("Mana:");

        ManaJogador2.setForeground(new java.awt.Color(255, 255, 255));
        ManaJogador2.setText("Mana:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ManaJogador1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(Carta5Jogador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Carta5Jogador2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Carta4Jogador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Carta4Jogador2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Carta3Jogador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Carta3Jogador2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Carta2Jogador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Carta2Jogador2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Carta1Jogador1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Carta1Jogador2))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomeJogador1)
                                    .addComponent(VidaJogador1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 330, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(VidaJogador2)
                                    .addComponent(NomeJogador2)
                                    .addComponent(ManaJogador2))))
                        .addGap(18, 18, 18))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeJogador1)
                    .addComponent(NomeJogador2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(VidaJogador2)
                    .addComponent(VidaJogador1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ManaJogador1)
                    .addComponent(ManaJogador2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Carta1Jogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Carta1Jogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Carta2Jogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Carta2Jogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Carta3Jogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Carta3Jogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Carta4Jogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Carta4Jogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Carta5Jogador1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Carta5Jogador2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Carta1Jogador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta1Jogador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta1Jogador1ActionPerformed

    private void Carta2Jogador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta2Jogador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta2Jogador1ActionPerformed

    private void Carta3Jogador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta3Jogador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta3Jogador1ActionPerformed

    private void Carta4Jogador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta4Jogador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta4Jogador1ActionPerformed

    private void Carta5Jogador1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta5Jogador1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta5Jogador1ActionPerformed

    private void Carta1Jogador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta1Jogador2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta1Jogador2ActionPerformed

    private void Carta2Jogador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta2Jogador2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta2Jogador2ActionPerformed

    private void Carta3Jogador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta3Jogador2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta3Jogador2ActionPerformed

    private void Carta4Jogador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta4Jogador2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta4Jogador2ActionPerformed

    private void Carta5Jogador2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Carta5Jogador2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Carta5Jogador2ActionPerformed


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                NewJFrame frame = new NewJFrame();
                frame.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Carta1Jogador1;
    private javax.swing.JButton Carta1Jogador2;
    private javax.swing.JButton Carta2Jogador1;
    private javax.swing.JButton Carta2Jogador2;
    private javax.swing.JButton Carta3Jogador1;
    private javax.swing.JButton Carta3Jogador2;
    private javax.swing.JButton Carta4Jogador1;
    private javax.swing.JButton Carta4Jogador2;
    private javax.swing.JButton Carta5Jogador1;
    private javax.swing.JButton Carta5Jogador2;
    private javax.swing.JLabel ManaJogador1;
    private javax.swing.JLabel ManaJogador2;
    private javax.swing.JLabel NomeJogador1;
    private javax.swing.JLabel NomeJogador2;
    private javax.swing.JLabel VidaJogador1;
    private javax.swing.JLabel VidaJogador2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
