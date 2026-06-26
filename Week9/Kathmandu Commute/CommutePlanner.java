public class CommutePlanner {

    public static void planMyCommute(
            String origin,
            String destination,
            RouteValidator validator,
            NavigationService navigator) {

        System.out.println("Planning your commute from " + origin + " to " + destination + "...");

        try {
            navigator.navigate(origin, destination, validator);
        } catch (NavigationFailedException e) {
            Throwable cause = e.getCause();

            if (cause instanceof SameLocationException) {
                System.out.println("Cannot plan: You are already at your destination!");
            } else if (cause instanceof InvalidRouteException) {
                System.out.println("Cannot plan: Invalid route details - " + cause.getMessage());
            } else {
                System.out.println("Cannot plan: GPS issue - " + e.getMessage());
            }
        } finally {
            System.out.println("Commute planning for " + origin + " to " + destination + " completed.");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        KathmanduTrafficValidator validator = new KathmanduTrafficValidator();
        GPSNavigationModule navigator = new GPSNavigationModule();

        planMyCommute("Baneshwor", "Baneshwor", validator, navigator);
        planMyCommute("Thamel", "Patan", validator, navigator);
        planMyCommute("Kalanki", "Balaju", validator, navigator);
        planMyCommute("Chabahil", "Lalitpur", validator, navigator);
    }
}