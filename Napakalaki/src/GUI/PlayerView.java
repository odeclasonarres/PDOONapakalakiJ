/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.JPanel;
import napakalaki.Player;
import napakalaki.Treasure;

/**
 *
 * @author OdeclasOnarres
 */
public class PlayerView extends javax.swing.JPanel {
    Player playerModel;
    /**
     * Creates new form PlayerView
     */
    
    public void setPlayer(Player p){
        playerModel=p;    
        jlEnemigo.setText(p.getEnemy().getName());
        jlMalRollo.setText(p.getBadConsequence().toString());
        jlMuerto.setText(p.isDead()+"");
        //jlNSect.
        jlNivel.setText(p.getLevels()+"");
        jlCombatLevel.setText(p.getCombatLevel()+"");
        jlNombre.setText(p.getName());
        jlRobar.setText(p.canISteal()+"");
        //jlSectario;
        // A continuación se actualizan sus tesoros 
        fillTreasurePanel (jpVisibles, playerModel.getVisibleTreasures()); 
        fillTreasurePanel (jpOcultos, playerModel.getHiddenTreasures()); 
        repaint(); 
        revalidate();
    }
    
    private void fillTreasurePanel(JPanel aPanel, ArrayList<Treasure> aList){ 
        // Se elimina la información antigua 
        aPanel.removeAll(); 
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas 
        // al panel 
        for (Treasure t : aList){ 
            TreasureView aTreasureView = new TreasureView(); 
            aTreasureView.setTreasure (t); 
            aTreasureView.setVisible (true); 
            aPanel.add (aTreasureView); 
        } 
        // Se fuerza la actualización visual del panel 
        aPanel.repaint(); 
        aPanel.revalidate(); 
    }

    
    public PlayerView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpInfo = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jlNivel = new javax.swing.JLabel();
        jlEnemigo = new javax.swing.JLabel();
        jlMuerto = new javax.swing.JLabel();
        jlRobar = new javax.swing.JLabel();
        jlMalRollo = new javax.swing.JLabel();
        jlSectario = new javax.swing.JLabel();
        jlNSect = new javax.swing.JLabel();
        jlCombatLevel = new javax.swing.JLabel();
        jpMonstruos = new javax.swing.JPanel();
        jpOcultos = new javax.swing.JPanel();
        jpVisibles = new javax.swing.JPanel();

        jpInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Información"));

        jlNombre.setText("jLabel1");

        jlNivel.setText("jLabel2");

        jlEnemigo.setText("jLabel3");

        jlMuerto.setText("jLabel4");

        jlRobar.setText("jLabel5");

        jlMalRollo.setText("jLabel6");

        jlSectario.setText("jLabel7");

        jlNSect.setText("jLabel8");

        jlCombatLevel.setText("jLabel1");

        javax.swing.GroupLayout jpInfoLayout = new javax.swing.GroupLayout(jpInfo);
        jpInfo.setLayout(jpInfoLayout);
        jpInfoLayout.setHorizontalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlNombre)
                    .addComponent(jlNivel)
                    .addComponent(jlEnemigo)
                    .addComponent(jlMuerto)
                    .addComponent(jlRobar)
                    .addComponent(jlMalRollo)
                    .addComponent(jlSectario)
                    .addComponent(jlNSect)
                    .addComponent(jlCombatLevel))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        jpInfoLayout.setVerticalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlNombre)
                .addGap(18, 18, 18)
                .addComponent(jlNivel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jlCombatLevel)
                .addGap(18, 18, 18)
                .addComponent(jlEnemigo)
                .addGap(18, 18, 18)
                .addComponent(jlMuerto)
                .addGap(18, 18, 18)
                .addComponent(jlRobar)
                .addGap(18, 18, 18)
                .addComponent(jlMalRollo)
                .addGap(18, 18, 18)
                .addComponent(jlSectario)
                .addGap(18, 18, 18)
                .addComponent(jlNSect))
        );

        jpMonstruos.setLayout(new javax.swing.BoxLayout(jpMonstruos, javax.swing.BoxLayout.Y_AXIS));

        jpOcultos.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros ocultos"));
        jpMonstruos.add(jpOcultos);

        jpVisibles.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros visibles"));
        jpMonstruos.add(jpVisibles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpMonstruos, javax.swing.GroupLayout.PREFERRED_SIZE, 463, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jpMonstruos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlCombatLevel;
    private javax.swing.JLabel jlEnemigo;
    private javax.swing.JLabel jlMalRollo;
    private javax.swing.JLabel jlMuerto;
    private javax.swing.JLabel jlNSect;
    private javax.swing.JLabel jlNivel;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlRobar;
    private javax.swing.JLabel jlSectario;
    private javax.swing.JPanel jpInfo;
    private javax.swing.JPanel jpMonstruos;
    private javax.swing.JPanel jpOcultos;
    private javax.swing.JPanel jpVisibles;
    // End of variables declaration//GEN-END:variables
}
