import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Team {
    private final List<Hero> deck;
    private final List<Hero> heroList;
    private double hp;
    private final Random rng;

    public Team(Hero[] heroes) {
        this.deck = new ArrayList<>();
        Collections.addAll(this.deck, heroes);
        this.heroList = new ArrayList<>();
        this.hp = 0;
        this.rng = new Random();
    }

    public List<Hero> getHeroList() { return Collections.unmodifiableList(heroList); }
    public double getHp() { return hp; }

    // Random team of 4 from deck
    public void formTeam() {
        heroList.clear();
        if (deck.size() < 4) throw new IllegalStateException("Deck must have at least 4 heroes.");
        List<Hero> shuffled = new ArrayList<>(deck);
        Collections.shuffle(shuffled, rng);
        for (int i = 0; i < 4; i++) heroList.add(shuffled.get(i));
        recalcHp();
    }

    // Fixed team: use exactly the heroes passed in the constructor (order preserved)
    public void formTeamFixed() {
        heroList.clear();
        heroList.addAll(deck);
        recalcHp();
    }

    private void recalcHp() {
        hp = 0;
        for (Hero h : heroList) hp += h.getHp();
    }

    public void getDamaged(double damage) {
        if (damage < 0) damage = 0;
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public void resetTeamHp() {
        recalcHp();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Team's HP: " + hp + "\n\n");
        for (int i = 0; i < heroList.size(); i++) {
            sb.append("Hero ").append(i + 1).append("\n");
            sb.append(heroList.get(i).toString()).append("\n");
        }
        return sb.toString();
    }
}