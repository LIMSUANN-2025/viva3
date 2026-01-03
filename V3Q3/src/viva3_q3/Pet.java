package viva3_q3;

public class Pet {

    private String name;
    private String species;
    private String breed;
    private int age;
    private String healthRecord;
    private boolean isAdopted;
    private String adopterName;

    //Constructor (What should this object look like immediately after creation?)
    public Pet (String name, String species, String breed, int age, String healthRecord) {
        this.name = name;
        this.species = species;
        this.breed = breed;
        this.age = age;
        this.healthRecord = healthRecord;
        this.isAdopted = false;
        this.adopterName = null;
    }
    //to adopt a pet
    public void adopt(String adopterName){
        this.isAdopted = true;
        this.adopterName = adopterName;
    }

    //to get pet details
    public String getDetails(){
        return "Name: " + name +
                "\nSpecies: " + species +
                "\nBreed: " + breed +
                "\nAge: " + age +
                "\nHealth Record: " + healthRecord +
                "\nAdpoted: " + isAdopted +
                "\nAdopter Name: " + adopterName;
    }
    //Getters
    public String getName(){return name;}
    public String getSpecies(){return species;}
    public String getBreed(){return breed;}
    public int getAge(){return age;}
    public String getHealthRecord(){return healthRecord;}
    public boolean getIsAdopted(){return isAdopted;}
    public String getAdopterName(){return adopterName;}
}
