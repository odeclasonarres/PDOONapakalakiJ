/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author OdeclasOnarres
 */
public class PruebaNapakalaki {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Prize p= new Prize(1, 1);
       BadConsequence bc=new BadConsequence("dddd", 1, 1, 1);
       Monster m=new Monster("prueba", 0, p, bc);
       
        System.out.println(p.toString());
        System.out.println(bc.toString());
        System.out.println(m.toString());
    }
    
}
