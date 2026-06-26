import java.util.Arrays;
import java.util.List;

public class DeusiBhailo extends FestivalActivity {
    List<String> plannedRoutes;
    int numberOfPerformers;

    public DeusiBhailo(double estimatedCost, List<String> plannedRoutes, int numberOfPerformers) {
        super("Deusi Bhailo Program", estimatedCost);
        this.plannedRoutes = plannedRoutes;
        this.numberOfPerformers = numberOfPerformers;
    }

    @Override
    public void planActivity() throws FestivalPlanningException {
        if (plannedRoutes.isEmpty()) {
            throw new NoRouteException("No routes planned for Deusi Bhailo! Are we just singing in the living room?");
        }
        if (numberOfPerformers < 3) {
            throw new FestivalPlanningException("Need at least 3 performers for a proper Deusi Bhailo!");
        }
        System.out.println("Deusi Bhailo program with " + numberOfPerformers + " performers planned for " + plannedRoutes.size() + " routes!");
    }

    public static void main(String[] args) {
        DeusiBhailo valid = new DeusiBhailo(15000, Arrays.asList("Baneshwor", "Koteshwor", "Tinkune"), 5);
        DeusiBhailo noRoutes = new DeusiBhailo(10000, Arrays.asList(), 4);
        DeusiBhailo fewPerformers = new DeusiBhailo(8000, Arrays.asList("Lazimpat"), 2);

        DeusiBhailo[] events = {valid, noRoutes, fewPerformers};

        for (DeusiBhailo event : events) {
            try {
                event.planActivity();
            } catch (NoRouteException e) {
                System.out.println("Route Issue: " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("Planning Issue: " + e.getMessage());
            }
        }
    }
}
