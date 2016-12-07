/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Charlie
 */
public class CardDealer {

    private static final CardDealer instance = new CardDealer();
    private ArrayList<Monster> unusedMonsters = new ArrayList();
    private ArrayList<Monster> usedMonsters = new ArrayList();
    private ArrayList<Treasure> unusedTreasures = new ArrayList();
    private ArrayList<Cultist> unusedCultist = new ArrayList();
    private ArrayList<Treasure> usedTreasures = new ArrayList();
    
    
    private CardDealer(){
        
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
    private void initTreasureCardDeck(){
        unusedTreasures.add(new Treasure("¡Si mi amo!", 4, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Botas de investigacion", 3, TreasureKind.SHOES));
        unusedTreasures.add(new Treasure("Capucha de Cthulhu", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("A prueba de babas", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Botas de lluvia acida", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Casco minero", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Ametralladora ACME", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Camiseta de la ETSIIT", 1, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Fez alopodo", 3, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Hacha prehistorica", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla", 4, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Gaita", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Insecticida", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Escopeta de 3 cañones", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Garabato mistico", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("La rebeca metalica", 2, TreasureKind.ARMOR));
        unusedTreasures.add(new Treasure("Lanzallamas", 4, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrocomicon", 1, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necronomicon", 5, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Linterna a 2 manos", 3, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Necrognomicon", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necrotelecom", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Mazo de los antiguos", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Necroplayboycon", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Porra preternatural", 2, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Shogulador", 1, TreasureKind.BOTHHANDS));
        unusedTreasures.add(new Treasure("Varita de atizamiento", 3, TreasureKind.ONEHAND));
        unusedTreasures.add(new Treasure("Tentaculo de pega", 2, TreasureKind.HELMET));
        unusedTreasures.add(new Treasure("Zapato deja-amigos", 1, TreasureKind.SHOES));    
    }
    
    private void initMonsterCardDeck(){
        BadConsequence badConsequence = new BadConsequence("Pierdes 5 niveles y 3 tesoros visibles", 5, 3, 0);
        Prize prize = new Prize(3,2);
        unusedMonsters.add(new Monster("El rey de rosado", 11,prize, badConsequence));

        badConsequence=new BadConsequence("Pierdes tu armadura visible y otra oculta", 1, 
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)),
                new ArrayList(Arrays.asList(TreasureKind.ARMOR)));
        prize= new Prize(2, 1);
        unusedMonsters.add(new Monster("3 Byakhees de la biodanza", 8, prize, badConsequence) );

        badConsequence = new BadConsequence("Embobados con el lindo primigenio te descartas de tu casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1,1);
        unusedMonsters.add(new Monster("Tenochtitlan",2,prize, badConsequence));
        
        badConsequence = new BadConsequence("Te atrapan para llevarte de fiesta y te dejan caer en mitad del vuelo. Descarta 1 mano visible y 1 mano oculta", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList(TreasureKind.ONEHAND)));
        prize = new Prize(4,1);
        unusedMonsters.add(new Monster("Demonios de Magaluf", 2, prize, badConsequence));
        
        badConsequence = new BadConsequence("Pierdes la armadura visible", 0, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("H.P. Munchcraft", 6, prize, badConsequence));
        
        badConsequence = new BadConsequence("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto", true);
        prize = new Prize(2,1);
        unusedMonsters.add(new Monster("Los hondos", 8, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te intentas escaquear. Pierdes una mano visible", 0, new ArrayList(Arrays.asList(TreasureKind.ONEHAND)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Dameargo", 1, prize, badConsequence));
        
        badConsequence = new BadConsequence("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 14, prize, badConsequence));
        
        badConsequence = new BadConsequence("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visibles", 2, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList()));
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Roboggoth", 8, prize, badConsequence));
        
        badConsequence = new BadConsequence("La familia te atrapa. Estás muerto", true);
        prize = new Prize(3, 1);
        unusedMonsters.add(new Monster("Familia feliz", 1, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te asusta en la noche. Pierdes un casco visible", 0, new ArrayList(Arrays.asList(TreasureKind.HELMET)), new ArrayList(Arrays.asList()));
        prize = new Prize(1, 1);
        unusedMonsters.add(new Monster("El espía sordo", 5, prize, badConsequence));
        
        badConsequence =  new BadConsequence("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Tongue", 19, prize, badConsequence));
        
        badConsequence = new BadConsequence("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, new ArrayList(Arrays.asList(TreasureKind.BOTHHANDS)), new ArrayList(Arrays.asList())); //Preguntar por los tesoros
        prize = new Prize(2, 1);
        unusedMonsters.add(new Monster("Bicéfalo", 21, prize, badConsequence));
        
        badConsequence=new BadConsequence("EL primordial bostezo contagioso. Pierdes el calzado visible", 1, new ArrayList(Arrays.asList(TreasureKind.SHOES)),new ArrayList(Arrays.asList()));
        prize=new Prize(1, 1);
        unusedMonsters.add(new Monster("El sopor de Dunwich",2,prize, badConsequence));
        
        badConsequence=new BadConsequence("Pierdes todos tus tesoros visibles", 1, 5, 0);
        prize=new Prize(3, 1);
        unusedMonsters.add(new Monster("El gorrón en el umbral",13,prize, badConsequence));
        
        badConsequence=new BadConsequence("Sientes bichos bajo la ropa. Pierdes la armadura visibles", 1, new ArrayList(Arrays.asList(TreasureKind.ARMOR)), new ArrayList(Arrays.asList()));
        prize=new Prize(1, 1);
        unusedMonsters.add(new Monster("Necrófago", 13, prize, badConsequence));
        
        badConsequence=new BadConsequence("Toses los pulmones y perdes 2 niveles", 2, 0, 0);
        prize=new Prize(1, 1);
        unusedMonsters.add(new Monster("Fletcher", 2, prize, badConsequence));
        
        badConsequence=new BadConsequence("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        prize=new Prize(2, 1);
        unusedMonsters.add(new Monster("Semillas de Cthulhu", 4, prize, badConsequence));
        
        badConsequence=new BadConsequence("Da mucho asquito.Pierdes 3 niveles", 3, 0, 0);
        prize=new Prize(2, 1);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, prize, badConsequence));
    }
    
    private void initCultistCardDeck(){}
    
    private void shuffleTreasures(){
        final int NUM_TESOROS=unusedTreasures.size();        
        Random r = new Random();
        int segunda;
        Treasure temp;

        for(int primera=0;primera<unusedTreasures.size();primera++){
            
            segunda=r.nextInt(NUM_TESOROS);
            temp=unusedTreasures.get(primera);
            unusedTreasures.set(primera, unusedTreasures.get(segunda));
            unusedTreasures.set(segunda, temp);
            
            
        }  
    }
    
    private void shuffleMonster(){
        final int NUM_MONSTRUOS=unusedMonsters.size();        
        Random r = new Random();
        int segunda;
        Monster temp;

        for(int primera=0;primera<unusedMonsters.size();primera++){
            
            segunda=r.nextInt(NUM_MONSTRUOS);
            temp=unusedMonsters.get(primera);
            unusedMonsters.set(primera, unusedMonsters.get(segunda));
            unusedMonsters.set(segunda, temp);
            
            
        }
    }
    private void shuffleCultist(){
        final int NUM_CULTIST=unusedCultist.size();        
        Random r = new Random();
        int segunda;
        Cultist temp;

        for(int primera=0;primera<unusedCultist.size();primera++){
            
            segunda=r.nextInt(NUM_CULTIST);
            temp=unusedCultist.get(primera);
            unusedCultist.set(primera, unusedCultist.get(segunda));
            unusedCultist.set(segunda, temp);
            
            
        }
    }
    
    public Treasure nextTreasure(){
        Treasure retorno;
        if(unusedTreasures.isEmpty()){
            unusedTreasures=usedTreasures;
            shuffleTreasures();
            usedTreasures.clear();
            retorno=unusedTreasures.remove(0);
        }else{
            retorno=unusedTreasures.remove(0);
        }
        return retorno;
    }
    
    public Monster nextMonster(){
        Monster retorno;
        if(unusedMonsters.isEmpty()){
            unusedMonsters=usedMonsters;
            shuffleMonster();
            usedMonsters.clear();
            retorno=unusedMonsters.remove(0);
        }else{
            retorno=unusedMonsters.remove(0);
        }
        return retorno;
    }
    
    public Cultist nextCultist(){
        return unusedCultist.remove(0);
    }
    
    public void giveTreasureBack(Treasure t){
        usedTreasures.add(t);
    }
    
    public void giveMonsterBack(Monster m){
        usedMonsters.add(m);
    }
    
    public void initCards(){
        initTreasureCardDeck();
        initMonsterCardDeck();
        shuffleTreasures();
        shuffleMonster();
    }
}
