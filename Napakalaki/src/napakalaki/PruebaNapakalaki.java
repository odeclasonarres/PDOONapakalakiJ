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

        
        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        monstruos.add(new Monster("Tenochtitlan",2,prize, badConsequence));
        
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        monstruos.add(new Monster("Demonios de Magaluf", 2, prize, badConsequence));
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2,1);
        monstruos.add(new Monster("Los hondos", 8, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Dameargo", 1, prize, badConsequence));
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("Yskhtihyssg-Goth", 14, prize, badConsequence));
        
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Roboggoth", 8, prize, badConsequence));
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto", true);
        prize = new Prize(3, 1);
        monstruos.add(new Monster("Familia feliz", 1, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        monstruos.add(new Monster("El espía sordo", 5, prize, badConsequence));
        
        badConsequence =  new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Tongue", 19, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList())); //Preguntar por los tesoros
        prize = new Prize(2, 1);
        monstruos.add(new Monster("Bicéfalo", 21, prize, badConsequence));
        
        badConsequence=new BadConsequence("EL primordial bostezo contagioso. Pierdes el calzado visible", 1, new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList(Arrays.asList()));
        prize=new Prize(1, 1);
        monstruos.add(new Monster("El sopor de Dunwich",2,prize, badConsequence));
        
        badConsequence=new BadConsequence("Pierdes todos tus tesoros visibles", 1, 5, 0);
        prize=new Prize(3, 1);
        monstruos.add(new Monster("El gorrón en el umbral",13,prize, badConsequence));
        
        badConsequence=new BadConsequence("Sientes bichos bajo la ropa. Pierdes la armadura visibles", 1, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
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
  
        for (Monster m : monstruos) {
            System.out.println(m.toString());
        }
           
        
    }
}
