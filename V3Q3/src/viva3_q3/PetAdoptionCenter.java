package viva3_q3;

import java.util.ArrayList;

public class PetAdoptionCenter {
    private ArrayList<Pet> pets;

    //Constructor
    public PetAdoptionCenter(){
        pets = new ArrayList<>(); //Initializes "pets" list as empty (new ArrayList<>())
    }

    //add new pet to system
    public void addPet(Pet pet){
        pets.add(pet);
    }

    //For Adopter to look through the pets
    public ArrayList<Pet> getAllPets(){
        return pets;
    }

    //get pet by name (Search function)
    public Pet getPetByName(String name){
        for (Pet p : pets){
            if (p.getName().equalsIgnoreCase(name)){
                return p;
            }
        } return null;
    }

    //view available pets
    public void viewAvailablePets() {
        System.out.println("----Available Pets----");
        for (Pet p : pets){
            if (p.getIsAdopted() == false){
                System.out.println(p.getDetails());
            }
            System.out.println();
        }
    }

    //adopt pet
    public void adoptPet(Pet pet,Adopter adopter) {
        if (pet !=null && !pet.getIsAdopted()){
            pet.adopt(adopter.getAdopterName());
            System.out.println(pet.getAdopterName() + " adopted " + pet.getName());
        }else {
            System.out.println("Pet not available for adoption");
        }
    }
}
