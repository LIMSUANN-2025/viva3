import java.util.HashMap;
import java.util.Map;

public final class ElementUtil {
    private ElementUtil() {}

    private static final String WATER = "Water";
    private static final String FIRE = "Fire";
    private static final String EARTH = "Earth";
    private static final String LIGHT = "Light";
    private static final String DARK = "Dark";

    private static final Map<String, Map<String, Double>> DOMINANCE = new HashMap<>();
    static {
        String[] elems = {WATER, FIRE, EARTH, LIGHT, DARK};
        for (String e1 : elems) {
            Map<String, Double> row = new HashMap<>();
            for (String e2 : elems) row.put(e2, 1.0); // neutral default
            DOMINANCE.put(e1, row);
        }
        // Water vs Fire strong, vs Earth weak
        DOMINANCE.get(WATER).put(FIRE, 1.5);
        DOMINANCE.get(WATER).put(EARTH, 0.5);

        // Fire vs Earth strong, vs Water weak
        DOMINANCE.get(FIRE).put(EARTH, 1.5);
        DOMINANCE.get(FIRE).put(WATER, 0.5);

        // Earth vs Water strong, vs Fire weak
        DOMINANCE.get(EARTH).put(WATER, 1.5);
        DOMINANCE.get(EARTH).put(FIRE, 0.5);

        // Light vs Dark strong; Dark vs Light strong
        DOMINANCE.get(LIGHT).put(DARK, 1.5);
        DOMINANCE.get(DARK).put(LIGHT, 1.5);
    }

    public static double getDominanceMultiplier(String heroElement, String enemyElement) {
        Map<String, Double> row = DOMINANCE.get(heroElement);
        if (row == null) return 1.0;
        return row.getOrDefault(enemyElement, 1.0);
    }

    public static String[] allElements() {
        return new String[]{WATER, FIRE, EARTH, LIGHT, DARK};
    }
}