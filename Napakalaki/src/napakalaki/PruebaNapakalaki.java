/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;

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
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        Prize prize = new Prize(3,2);
        monstruos.add(new Monster("El rey de rosado", 11,prize, badConsequence));
      
        badConsequence=new BadConsequence("Pierdes tu armadura visible y otra oculta", 1, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize= new Prize(2, 1);
        monstruos.add(new Monster("3 Byakhees de la biodanza", 8, prize, badConsequence) );
    
        badConsequence=new BadConsequence("EL primordial bostezo contagioso. Pierdes el calzado visible", 1, new ArrayList(Arrays.asList(TreasureKind.SHOES)),null);
        prize=new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich",2,prize, badConsequence));
        
        badConsequence=new BadConsequence("Pierdes todos tus tesoros visibles", 1, 5, 0);
        prize=new Prize(3, 1);
        monstruos.add(new Monster("El gorrón en el umbral",13,prize, badConsequence));
        
        badConsequence=new BadConsequence("Sientes bichos bajo la ropa. Pierdes la armadura visibles", 1, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), null);
        prize=new Prize(1, 1);
        monstruos.add(new Monster("Necrófago", 13, prize, badConsequence));
        
        badConsequence=new BadConsequence("Toses los pulmones y perdes 2 niveles", 2, 0, 0);
        prize=new Prize(1, 1);
        monstruos.add(new Monster("Fletcher", 2, prize, badConsequence));
        
        badConsequence=new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize=new Prize(2, 1);
        monstruos.add(new Monster("Semillas de Cthulhu", 4, prize, badConsequence));
        
        badConsequence=new BadConsequence("Da mucho asquito.Pierdes 3 niveles", 3, 0, 0);
        prize=new Prize(2, 1);
        monstruos.add(new Monster("Pollipolipo volante", 3, prize, badConsequence));
        
    
    
    
    }
}
