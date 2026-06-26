import java.util.Arrays;
import java.util.List;

public class DashainFestivalPlanner {

    public static void executeFestivalPlan(List<FestivalActivity> activities) {
        for (FestivalActivity activity : activities) {
            activity.displayOverview();
            try {
                activity.planActivity();
            } catch (BudgetExceededException e) {
                System.out.println("Planning Warning (Budget): " + e.getMessage());
            } catch (NoRouteException e) {
                System.out.println("Planning Warning (Routes): " + e.getMessage());
            } catch (FestivalPlanningException e) {
                System.out.println("General Planning Error: " + e.getMessage());
            } finally {
                System.out.println("Activity planning attempt for " + activity.activityName + " completed.");
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        List<FestivalActivity> activities = Arrays.asList(
            new TikaCeremony(30000, 20, "Hajurba"),
            new TikaCeremony(20000, 2, "Hajurba"),
            new TikaCeremony(80000, 15, "Hajurba"),
            new DeusiBhailo(15000, Arrays.asList("Baneshwor", "Koteshwor", "Tinkune"), 6),
            new DeusiBhailo(10000, Arrays.asList(), 4),
            new DeusiBhailo(8000, Arrays.asList("Lazimpat"), 1)
        );

        executeFestivalPlan(activities);
    }
}
