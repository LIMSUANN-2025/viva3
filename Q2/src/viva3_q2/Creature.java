package viva3_q2;
//this class represent a single creature

public class Creature {
    private String species;
    private double magicPower;
    private String habitat;
    
    public Creature(String species, double magicPower, String habitat){
        this.species = species;
        this.magicPower = magicPower;
        this.habitat = habitat;
    }
    
    public String getSpecies(){
        return species;
    }
    
    public double getMagicPower(){
        return magicPower;
    }
    
    public void feed(double foodAmount){
        magicPower += foodAmount;
        System.out.println(species + "'s magic power increased to " + magicPower);
        System.out.println();
    }
    
    public void displayInfo(){
        System.out.println("Species: " + species);
        System.out.println("Magic Power: " + magicPower);
        System.out.println("Habitat: " + habitat);
        System.out.println();
    }
}
