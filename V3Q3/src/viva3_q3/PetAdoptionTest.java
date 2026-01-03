package viva3_q3;

public class PetAdoptionTest {
    public static void main(String[] args) {
        PetAdoptionCenter center = new PetAdoptionCenter();

        //Adding pets to the center
        center.addPet(new Pet("Whiskers", "Cat", "Siamese", 2, "Vaccinated"));
        center.addPet(new Pet("Buddy", "Dog", "Labrador", 3, "Healthy"));
        center.addPet(new Pet("Spike", "Parrot", "Macaw", 4, "Needs checkup"));

        //Viewing available pets
        center.viewAvailablePets();

        //Adopter matching and adoption process
        Adopter adp1 = new Adopter("John", "Dog", "1-4");
        adp1.viewMatchingPets(center);

        System.out.println("\n----Adoption process----");
        center.adoptPet(center.getPetByName("Buddy"), adp1);

        System.out.println("\nAvailable pets after adoption:");
        center.viewAvailablePets();
    }
}

/*Ques:
1. Why viewAvailablePets() is empty while viewMatchingPets(center) has center in bracket?
The viewAvailablePets() method is inside the same class as the obj PetAdoptionCenter
while viewMatchingPets() method is inside Adopter class, so need to add center
 */

