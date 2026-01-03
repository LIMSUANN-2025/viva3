package viva3_q3;

public class Adopter {
    private String adopterName;
    private String preferredSpecies;
    private String preferredAgeRange;

    public Adopter(String adopterName, String preferredSpecies, String preferredAgeRange) {
        this.adopterName = adopterName;
        this.preferredSpecies = preferredSpecies;
        this.preferredAgeRange = preferredAgeRange;
    }

    //Getters
    public String getAdopterName(){return adopterName;}
    public String getPreferredSpecies(){return preferredSpecies;}
    public String getPreferredAgeRange(){return preferredAgeRange;}

    public void viewMatchingPets(PetAdoptionCenter center) {
        String[] range = preferredAgeRange.split("-");
        int minAge = Integer.parseInt(range[0]);
        int maxAge = Integer.parseInt(range[1]);
        boolean found = false;

        for (Pet pet : center.getAllPets()) {
            if (!pet.getIsAdopted() && pet.getSpecies().equalsIgnoreCase(preferredSpecies) && pet.getAge() >= minAge && pet.getAge() <= maxAge) {
                System.out.println("Matching pets for" + adopterName + ":");
                System.out.println(pet.getDetails());
            }
        }
        if (!found) {
            System.out.println("No matching pets found.");
        }
    }
}


