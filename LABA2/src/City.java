import java.util.HashMap;
import java.util.Map;

public class City {
    private String name;
    private Map<City, Integer> routes;

    public City(String name) {
        this.name = name;
        this.routes = new HashMap<>();
    }

    private String getName() {
        return name;
    }

    void addRoute(City destination, int cost) {
        this.routes.put(destination, cost);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (");
        boolean first = true;
        for (Map.Entry<City, Integer> entry : routes.entrySet()) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(entry.getKey().getName()).append(":").append(entry.getValue());
            first = false;
        }
        sb.append(")");
        return sb.toString();
    }
}
