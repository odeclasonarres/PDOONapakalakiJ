/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.CombatResult;
import napakalaki.Monster;
import napakalaki.Napakalaki;
import napakalaki.Player;

/**
 *
 * @author Charlie
 */
public class NapakalakiView extends javax.swing.JFrame {
    Napakalaki napakalakiModel;
    Player currentPlayer;
    Monster currentMonster;
    /**
     * Creates new form NapakalakiView
     */
    public NapakalakiView() {
        initComponents();
        //playerView1=new PlayerView();
        //monsterView1=new MonsterView();

        
    }
    
    public void setNapakalaki(Napakalaki n){
        this.napakalakiModel = n;
        currentPlayer = napakalakiModel.getCurrentPlayer();
        currentMonster = napakalakiModel.getCurrentMonster();
        playerView1.setPlayer(currentPlayer);
        playerView1.setNapakalaki(napakalakiModel);
        monsterView1.setMonstruo(currentMonster);
        jButtonNextTurn.setEnabled(false);
        jButtonCombatir.setEnabled(false);
        monsterView1.setVisible(false);

        
        //currentPlayer = napakalakiModel.getCurrentPlayer();
        //currentMonster = napakalakiModel.getCurrentMonster();
        //playerView1.setPlayer(n.getCurrentPlayer());
        
        //monsterView1.setMonstruo(currentMonster);

        repaint();
        revalidate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        playerView1 = new GUI.PlayerView();
        jPanel2 = new javax.swing.JPanel();
        monsterView1 = new GUI.MonsterView();
        jPanel1 = new javax.swing.JPanel();
        jCombatResult = new javax.swing.JLabel();
        jButtonMostrarMonstruo = new javax.swing.JButton();
        jButtonCombatir = new javax.swing.JButton();
        jButtonNextTurn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(playerView1, java.awt.BorderLayout.CENTER);

        monsterView1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setMaximumSize(new java.awt.Dimension(226, 300));
        jPanel1.setMinimumSize(new java.awt.Dimension(226, 300));
        jPanel1.setPreferredSize(new java.awt.Dimension(226, 300));
        jPanel1.setLayout(new java.awt.GridLayout(4, 1));
        jPanel1.add(jCombatResult);

        jButtonMostrarMonstruo.setText("Mostrar monstruo");
        jButtonMostrarMonstruo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMostrarMonstruoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonMostrarMonstruo);

        jButtonCombatir.setText("Combatir");
        jButtonCombatir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCombatirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCombatir);

        jButtonNextTurn.setText("Siguiente turno");
        jButtonNextTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextTurnActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonNextTurn);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE)
                    .addComponent(monsterView1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(monsterView1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonMostrarMonstruoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMostrarMonstruoActionPerformed
        monsterView1.setVisible(true);
        jButtonMostrarMonstruo.setEnabled(false);
        jButtonCombatir.setEnabled(true);
        playerView1.manejarBotones(false);
        playerView1.robarActivado(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonMostrarMonstruoActionPerformed

    private void jButtonNextTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextTurnActionPerformed
        // TODO add your handling code here:
        if(napakalakiModel.nextTurn()){
            currentMonster = napakalakiModel.getCurrentMonster();
            currentPlayer = napakalakiModel.getCurrentPlayer();
            playerView1.setPlayer(currentPlayer);
            playerView1.setNapakalaki(napakalakiModel);
            playerView1.robarActivado(true);
            monsterView1.setMonstruo(currentMonster);
            jButtonMostrarMonstruo.setEnabled(true);
            jButtonNextTurn.setEnabled(false);
            jButtonCombatir.setEnabled(false);
            monsterView1.setVisible(false);
            jCombatResult.setText(" ");
            repaint();
            revalidate();
        }else{
            
            if(!playerView1.isPendingEmty())
                jCombatResult.setText("No cumples el mal rollo");
            else
                jCombatResult.setText("Tienes mas de 4 tesoros ocultos");
            repaint();
            revalidate();
        }
        //jPanel1.repaint();
        //jPanel1.revalidate();

    }//GEN-LAST:event_jButtonNextTurnActionPerformed

    private void jButtonCombatirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCombatirActionPerformed
        // TODO add your handling code here:
        
        CombatResult cr = napakalakiModel.developCombat();
        
        if(cr == CombatResult.WINGAME){
            jButtonNextTurn.setEnabled(false);
            jButtonCombatir.setEnabled(false);
            jButtonMostrarMonstruo.setEnabled(false);
            playerView1.manejarBotones(false);
            jCombatResult.setText("El jugador " + currentPlayer.getName() + " ha ganado la partida");
        }else{
            jCombatResult.setText(cr.toString());
            playerView1.setPlayer(napakalakiModel.getCurrentPlayer());
            if(cr == CombatResult.LOSE /*|| cr == CombatResult.LOSEANDCONVERT*/)
                playerView1.showPendingBad();
            
            playerView1.manejarBotones(true);
            playerView1.robarActivado(true);
            playerView1.repaint();
            playerView1.revalidate();   

            jButtonNextTurn.setEnabled(true);
            jButtonCombatir.setEnabled(false);
        }
        //playerView1.repaint();
        //playerView1.revalidate(); 
        repaint();
        revalidate();
    }//GEN-LAST:event_jButtonCombatirActionPerformed

                                                 

                                                  

    /**
     * @param args the command line arguments
     */
    public void showView(){
        this.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCombatir;
    private javax.swing.JButton jButtonMostrarMonstruo;
    private javax.swing.JButton jButtonNextTurn;
    private javax.swing.JLabel jCombatResult;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private GUI.MonsterView monsterView1;
    private GUI.PlayerView playerView1;
    // End of variables declaration//GEN-END:variables
}
