public class Villain {
    private final String name;
    private final String element;
    private final double maxHp;
    private final double attack;
    private final double defense;
    private final int initialCd;

    private double hp;
    private int currentCd;

    public Villain(String name, String element, double maxHp, double attack, double defense, int initialCd) {
        this.name = name;
        this.element = normalize(element);
        this.maxHp = maxHp;
        this.attack = attack;
        this.defense = defense;
        this.initialCd = Math.max(1, initialCd);
        resetHp();
        resetCd();
    }

    private String normalize(String e) {
        if (e == null) return "";
        String s = e.trim();
        if (s.equalsIgnoreCase("water")) return "Water";
        if (s.equalsIgnoreCase("fire")) return "Fire";
        if (s.equalsIgnoreCase("earth")) return "Earth";
        if (s.equalsIgnoreCase("light")) return "Light";
        if (s.equalsIgnoreCase("dark")) return "Dark";
        return s;
    }

    public String getName() { return name; }
    public String getElement() { return element; }
    public double getMaxHp() { return maxHp; }
    public double getHp() { return hp; }
    public double getAttack() { return attack; }
    public double getDefense() { return defense; }
    public int getInitialCd() { return initialCd; }
    public int getCurrentCd() { return currentCd; }

    public void getDamaged(double damage) {
        if (damage < 0) damage = 0;
        hp -= damage;
        if (hp < 0) hp = 0;
    }

    public void resetHp() { this.hp = this.maxHp; }
    public void decreaseCd() { if (currentCd > 1) currentCd--; else currentCd = 1; }
    public void resetCd() { this.currentCd = this.initialCd; }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Element: " + element + "\n" +
                "Max HP: " + maxHp + "\n" +
                "HP: " + hp + "\n" +
                "Attack: " + attack + "\n" +
                "Defense: " + defense + "\n" +
                "Initial CD: " + initialCd + "\n" +
                "Current CD: " + currentCd + "\n";
    }
}