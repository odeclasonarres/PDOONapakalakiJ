/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author OdeclasOnarres
 */
public class PruebaNapakalaki {
    static ArrayList<Monster> monstruos = new ArrayList();
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BadConsequence badConsequence = new BadConsequence("ierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        Prize prize = new Prize(4,2);
        monstruos.add(new Monster("El rey de rosa", 13,prize, badConsequence));
      
        
       Prize p= new Prize(1, 1);
       BadConsequence bc=new BadConsequence("dddd", 1, 1, 1);
       Monster m=new Monster("prueba", 0, p, bc);
       
        System.out.println(p.toString());
        System.out.println(bc.toString());
        System.out.println(m.toString());
    }
    
}
