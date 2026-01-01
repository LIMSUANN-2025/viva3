package viva3_q1;

public class Potion {
    private String ingredient;
    private double volume;
    
    public Potion(String ingredient, double volume){
        this.ingredient = ingredient;
        this.volume = volume; 
    }
    
    public String getIngredient(){
        return ingredient;
    }
    
    public double getVolume(){
        return volume;
    }
    
    public boolean consume(double amount){
        if(volume>=amount){
            volume-=amount;
            return true;        //successfully used
        }
        else{
            return false;       //not enough
        }
    }
    
}
