/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import napakalaki.BadConsequence;

/**
 *
 * @author Charlie
 */
public class PendingBadView extends javax.swing.JPanel {
    private BadConsequence pendingBad;
    /**
     * Creates new form PendingBadView
     */
    public PendingBadView() {
        initComponents();
    }
    
    public void setPending(BadConsequence b){
        pendingBad = b;
        jTextArea.setText(pendingBad.toString());
        repaint();
        revalidate();
    }
    
    public void setVisiblePending(boolean visibilidad){
        this.setVisible(visibilidad);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTexto = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();

        setLayout(new java.awt.GridLayout(1, 0));

        jTextArea.setColumns(20);
        jTextArea.setRows(5);
        jTexto.setViewportView(jTextArea);

        add(jTexto);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JScrollPane jTexto;
    // End of variables declaration//GEN-END:variables
}