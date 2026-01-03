import java.util.Scanner;

public class TOSTest {
    /*
    public static void main(String[] args) {
        // Team exactly as in sample output
        Hero[] heroes = {
                new Hero("Nathaniel", "Light", 37, 24),
                new Hero("Skuld", "Fire", 66, 16),
                new Hero("Molly", "Water", 45, 20),
                new Hero("Poseidon", "Water", 58, 19)
        };

        // Villain exactly as in sample output
        Villain giemsa = new Villain("Giemsa", "Water", 100, 150, 15, 2);

        Team team = new Team(heroes);
        team.formTeamFixed(); // use the exact 4 heroes above

        Game game = new Game();
        game.battle(team, giemsa);
     */



        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            // === Input heroes ===
            System.out.println("How many heroes do you want in your team?");
            int nHeroes = sc.nextInt();
            sc.nextLine(); // clear buffer

            Hero[] heroes = new Hero[nHeroes];
            for (int i = 0; i < nHeroes; i++) {
                System.out.println("\nEnter details for Hero " + (i+1) + ":");
                System.out.print("Name: ");
                String hName = sc.nextLine();
                System.out.print("Element (Water/Fire/Earth/Light/Dark): ");
                String hElement = sc.nextLine();
                System.out.print("HP: ");
                double hHp = sc.nextDouble();
                System.out.print("Attack: ");
                double hAtk = sc.nextDouble();
                sc.nextLine(); // clear buffer
                heroes[i] = new Hero(hName, hElement, hHp, hAtk);
            }

            // === Input villain ===
            System.out.println("\nEnter details for Villain:");
            System.out.print("Name: ");
            String vName = sc.nextLine();
            System.out.print("Element (Water/Fire/Earth/Light/Dark): ");
            String vElement = sc.nextLine();
            System.out.print("Max HP: ");
            double vHp = sc.nextDouble();
            System.out.print("Attack: ");
            double vAtk = sc.nextDouble();
            System.out.print("Defense: ");
            double vDef = sc.nextDouble();
            System.out.print("Initial CD: ");
            int vCd = sc.nextInt();

            Villain villain = new Villain(vName, vElement, vHp, vAtk, vDef, vCd);

            // === Form team and battle ===
            Team team = new Team(heroes);
            team.formTeamFixed(); // use exactly the heroes you entered

            Game game = new Game();
            game.battle(team, villain);

            sc.close();
        }
    }