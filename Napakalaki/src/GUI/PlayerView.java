/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.util.ArrayList;
import javax.swing.JPanel;
import napakalaki.CultistPlayer;
import napakalaki.Napakalaki;
import napakalaki.Player;
import napakalaki.Treasure;

/**
 *
 * @author OdeclasOnarres
 */
public class PlayerView extends javax.swing.JPanel {
    Player playerModel;
    Napakalaki napakalakiModel;
    /**
     * Creates new form PlayerView
     */
    
    public void setPlayer(Player p){
        playerModel=p;    
        jEnemigoDatos.setText(p.getEnemy().getName());
        if(p.getBadConsequence()==null)
            jMalRolloDatos.setText("No");
        else
            jMalRolloDatos.setText("Si");
        if(p.isDead())
            jMuertoDatos.setText("Si");
        else
            jMuertoDatos.setText("No");
 
        jNivelDatos.setText(p.getLevels()+"");
        jCombatLevelDatos.setText(p.getCombatLevel()+"");
        jNombreDatos.setText(p.getName());
        if(p.canISteal())
            jRobarDatos.setText("Si");
        else
            jRobarDatos.setText("No");
        
        jNSectDatos.setText(Integer.toString(CultistPlayer.getTotalCultistPlayer()));
        
        if(playerModel.getClass() == CultistPlayer.class)
            jSectarioDatos.setText("Si");
        else
            jSectarioDatos.setText("No");
        
        if(playerModel.getBadConsequence()==null)
            pendingBadView1.setVisiblePending(false);
        else
            pendingBadView1.setVisiblePending(true);
        
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
    
    public void setNapakalaki(Napakalaki n){
        napakalakiModel=n;
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

        jPanel1 = new javax.swing.JPanel();
        jpInfo = new javax.swing.JPanel();
        jlNombre = new javax.swing.JLabel();
        jNombreDatos = new javax.swing.JLabel();
        jlNivel = new javax.swing.JLabel();
        jNivelDatos = new javax.swing.JLabel();
        jlCombatLevel = new javax.swing.JLabel();
        jCombatLevelDatos = new javax.swing.JLabel();
        jlMalRollo = new javax.swing.JLabel();
        jMalRolloDatos = new javax.swing.JLabel();
        jlRobar = new javax.swing.JLabel();
        jRobarDatos = new javax.swing.JLabel();
        jlMuerto = new javax.swing.JLabel();
        jMuertoDatos = new javax.swing.JLabel();
        jlEnemigo = new javax.swing.JLabel();
        jEnemigoDatos = new javax.swing.JLabel();
        jlSectario = new javax.swing.JLabel();
        jSectarioDatos = new javax.swing.JLabel();
        jlNSect = new javax.swing.JLabel();
        jNSectDatos = new javax.swing.JLabel();
        jpBotones = new javax.swing.JPanel();
        btRobar = new javax.swing.JButton();
        btEquipar = new javax.swing.JButton();
        btDescartar = new javax.swing.JButton();
        btDescTodos = new javax.swing.JButton();
        pendingBadView1 = new GUI.PendingBadView();
        jpTesoros = new javax.swing.JPanel();
        jpVisibles = new javax.swing.JPanel();
        jpOcultos = new javax.swing.JPanel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 10));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 700));
        jPanel1.setLayout(new java.awt.GridLayout(3, 1));

        jpInfo.setBorder(javax.swing.BorderFactory.createTitledBorder("Información"));
        jpInfo.setLayout(new java.awt.GridLayout(9, 1));

        jlNombre.setText("Nombre: ");
        jlNombre.setPreferredSize(new java.awt.Dimension(14, 14));
        jpInfo.add(jlNombre);
        jpInfo.add(jNombreDatos);

        jlNivel.setText("Nivel: ");
        jpInfo.add(jlNivel);
        jpInfo.add(jNivelDatos);

        jlCombatLevel.setText("CombatLevel: ");
        jpInfo.add(jlCombatLevel);
        jpInfo.add(jCombatLevelDatos);

        jlMalRollo.setText("Mal rollo: ");
        jpInfo.add(jlMalRollo);
        jpInfo.add(jMalRolloDatos);

        jlRobar.setText("Puedo robar: ");
        jpInfo.add(jlRobar);
        jpInfo.add(jRobarDatos);

        jlMuerto.setText("Muerto: ");
        jpInfo.add(jlMuerto);
        jpInfo.add(jMuertoDatos);

        jlEnemigo.setText("Enemigo: ");
        jpInfo.add(jlEnemigo);
        jpInfo.add(jEnemigoDatos);

        jlSectario.setText("Sectario: ");
        jpInfo.add(jlSectario);
        jpInfo.add(jSectarioDatos);

        jlNSect.setText("Numero de sectarios: ");
        jpInfo.add(jlNSect);
        jpInfo.add(jNSectDatos);

        jPanel1.add(jpInfo);

        jpBotones.setLayout(new java.awt.GridLayout(2, 2));

        btRobar.setText("Robar");
        jpBotones.add(btRobar);

        btEquipar.setText("Equipar");
        btEquipar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEquiparActionPerformed(evt);
            }
        });
        jpBotones.add(btEquipar);

        btDescartar.setText("Descartar");
        jpBotones.add(btDescartar);

        btDescTodos.setText("Descartar todos");
        jpBotones.add(btDescTodos);

        jPanel1.add(jpBotones);
        jPanel1.add(pendingBadView1);

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 515));

        jpTesoros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 10));
        jpTesoros.setLayout(new javax.swing.BoxLayout(jpTesoros, javax.swing.BoxLayout.Y_AXIS));

        jpVisibles.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros visibles"));
        jpVisibles.setMaximumSize(new java.awt.Dimension(816, 230));
        jpVisibles.setMinimumSize(new java.awt.Dimension(816, 230));
        jpVisibles.setPreferredSize(new java.awt.Dimension(700, 350));
        jpTesoros.add(jpVisibles);

        jpOcultos.setBorder(javax.swing.BorderFactory.createTitledBorder("Tesoros ocultos"));
        jpOcultos.setMaximumSize(new java.awt.Dimension(816, 230));
        jpOcultos.setMinimumSize(new java.awt.Dimension(816, 230));
        jpOcultos.setPreferredSize(new java.awt.Dimension(700, 350));
        jpTesoros.add(jpOcultos);

        add(jpTesoros, new org.netbeans.lib.awtextra.AbsoluteConstraints(264, 0, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void btEquiparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEquiparActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btEquiparActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDescTodos;
    private javax.swing.JButton btDescartar;
    private javax.swing.JButton btEquipar;
    private javax.swing.JButton btRobar;
    private javax.swing.JLabel jCombatLevelDatos;
    private javax.swing.JLabel jEnemigoDatos;
    private javax.swing.JLabel jMalRolloDatos;
    private javax.swing.JLabel jMuertoDatos;
    private javax.swing.JLabel jNSectDatos;
    private javax.swing.JLabel jNivelDatos;
    private javax.swing.JLabel jNombreDatos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jRobarDatos;
    private javax.swing.JLabel jSectarioDatos;
    private javax.swing.JLabel jlCombatLevel;
    private javax.swing.JLabel jlEnemigo;
    private javax.swing.JLabel jlMalRollo;
    private javax.swing.JLabel jlMuerto;
    private javax.swing.JLabel jlNSect;
    private javax.swing.JLabel jlNivel;
    private javax.swing.JLabel jlNombre;
    private javax.swing.JLabel jlRobar;
    private javax.swing.JLabel jlSectario;
    private javax.swing.JPanel jpBotones;
    private javax.swing.JPanel jpInfo;
    private javax.swing.JPanel jpOcultos;
    private javax.swing.JPanel jpTesoros;
    private javax.swing.JPanel jpVisibles;
    private GUI.PendingBadView pendingBadView1;
    // End of variables declaration//GEN-END:variables
}
