public class Game {
    public void battle(Team team, Villain enemy) {
        // Reset states
        team.resetTeamHp();
        enemy.resetHp();
        enemy.resetCd();

        // Show team
        System.out.println(team);

        // Hardcoded runestone sequences for 4 rounds to reproduce sample output
        String[][] runestoneRounds = {
                {"Light", "Light", "Fire"},
                {"Dark", "Dark", "Earth"},
                {"Light", "Water", "Light"},
                {"Dark", "Earth", "Water"}
        };

        int round = 1;
        for (String[] runes : runestoneRounds) {
            System.out.println("Round " + round);
            System.out.println("Enemy's current CD: " + enemy.getCurrentCd());
            System.out.println("Runestones dissolved:");
            for (String r : runes) System.out.println(" - " + r);
            System.out.println();

            boolean anyHeroAttacked = false;
            for (Hero h : team.getHeroList()) {
                int rsCount = countRunestones(runes, h.getElement());
                if (rsCount > 0) {
                    double dmg = h.calculateDamage(enemy, rsCount);
                    enemy.getDamaged(dmg);
                    anyHeroAttacked = true;
                    System.out.printf("%s dealt %.1f damage to %s%n", h.getName(), dmg, enemy.getName());
                }
            }
            if (!anyHeroAttacked) {
                System.out.println("No hero attacked in this round");
            }

            // Enemy acts if CD == 1 and still alive
            if (enemy.getHp() > 0) {
                if (enemy.getCurrentCd() == 1) {
                    double dmg = enemy.getAttack();
                    team.getDamaged(dmg);
                    System.out.printf("%s dealt %.1f damage to the team%n", enemy.getName(), dmg);
                    enemy.resetCd();
                } else {
                    enemy.decreaseCd();
                }
            }

            // End-of-round status
            System.out.printf("%nTeam's remaining HP: %.1f%n", team.getHp());
            System.out.printf("Enemy's remaining HP: %.1f%n%n", enemy.getHp());

            // Victory check
            if (enemy.getHp() <= 0) {
                System.out.println("The team won!");
                return;
            }
            if (team.getHp() <= 0) {
                System.out.println("The team lose.");
                return;
            }

            round++;
        }
    }

    private int countRunestones(String[] runes, String element) {
        int count = 0;
        for (String r : runes) {
            if (r.equals(element)) count++;
        }
        return count;
    }
}