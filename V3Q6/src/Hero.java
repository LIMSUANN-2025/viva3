public class Hero {
    private final String name;
    private final String element; // "Water", "Fire", "Earth", "Light", "Dark"
    private final double hp;
    private final double attack;

    public Hero(String name, String element, double hp, double attack) {
        this.name = name;
        this.element = normalize(element);
        this.hp = hp;
        this.attack = attack;
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
    public double getHp() { return hp; }
    public double getAttack() { return attack; }

    // Damage = Attack * Dominance multiplier * Runestone multiplier - Defense; floor at 1
    public double calculateDamage(Villain enemy, int rsMultiplier) {
        double dominance = ElementUtil.getDominanceMultiplier(this.element, enemy.getElement());
        double raw = attack * dominance * rsMultiplier - enemy.getDefense();
        return raw < 1 ? 1 : raw;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "Element: " + element + "\n" +
                "HP: " + hp + "\n" +
                "Attack: " + attack + "\n";
    }
}