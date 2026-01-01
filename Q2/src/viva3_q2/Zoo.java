package viva3_q2;

public class Zoo {
    private Creature[] creatures;
    private int count;
    
    public Zoo(int size){
        creatures = new Creature [size];
        count = 0;
    }
    
    //add new creatures
    public void addCreature(String species, double magicPower, String habitat){
        if (count >= creatures.length){
            System.out.println("Zoo is full! Cannot add more creatures.");
            System.out.println();
            return;
        }
        else{
            creatures[count] = new Creature(species, magicPower, habitat);
            System.out.println(species + " added to zoo.");
            count++;
        }
    }
    
    //feed creature
    public void feedCreature(String species, double foodAmount){
        for (int i=0; i<count; i++){
            if(creatures[i].getSpecies().equalsIgnoreCase(species)){
                creatures[i].feed(foodAmount);
                return;
            }
        }
    }
    
    //display all creatures
    public void displayAllCreatures(){
        for (int i=0; i<count; i++){
            creatures[i].displayInfo();
        }
    }
}
