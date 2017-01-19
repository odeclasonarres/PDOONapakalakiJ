/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import napakalaki.Treasure;

/**
 *
 * @author Charlie
 */
public class TreasureView extends javax.swing.JPanel {
    private Treasure treasureModel;
    private boolean selected=false;
    /**
     * Creates new form TreasureView
     */
    public TreasureView() {
        initComponents();
        this.setBackground(Color.BLUE);
    }
    
    public void setTreasure(Treasure t){
        treasureModel = t;
        System.out.println(t.getName());
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/Treasures/"+ treasureModel.getName() + ".jpg")));
        this.setOpaque(selected);
        repaint();
        revalidate();
    }
    
    public Treasure getTreasure(){
        return treasureModel;
    }
    
    public boolean isSelected(){
        return selected;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(136, 220));
        setVerifyInputWhenFocusTarget(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jLabel1.setPreferredSize(new java.awt.Dimension(112, 191));
        jLabel1.setVerifyInputWhenFocusTarget(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if(isSelected()){
            selected = false;
            this.setBackground(Color.BLUE);
        }else{
            selected = true;
            this.setBackground(Color.red);
        }
        this.setOpaque(selected);
        repaint();
        revalidate();
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
