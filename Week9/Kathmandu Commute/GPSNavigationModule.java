public class GPSNavigationModule implements NavigationService {

    @Override
    public void navigate(String startPoint, String endPoint, RouteValidator validator) throws NavigationFailedException {
        System.out.println("Attempting to navigate from " + startPoint + " to " + endPoint + "...");

        if (startPoint.equalsIgnoreCase("Kalanki")) {
            throw new NavigationFailedException("GPS signal lost near Kalanki! Welcome to Kathmandu traffic!");
        }

        try {
            validator.isValidCommuteRoute(startPoint, endPoint, simulatedDistance(startPoint, endPoint));
        } catch (InvalidRouteException e) {
            throw new NavigationFailedException("Route validation failed!", e);
        }

        System.out.println("Navigation successful! Estimated time: 20 minutes (or 2 hours depending on traffic).");
    }

    private double simulatedDistance(String start, String end) {
        return 5.0;
    }

    public static void main(String[] args) {
        GPSNavigationModule gps = new GPSNavigationModule();
        KathmanduTrafficValidator validator = new KathmanduTrafficValidator();

        String[][] routes = {
            {"Thamel", "Patan"},
            {"Thamel", "Thamel"},
            {"Kalanki", "Balaju"}
        };

        for (String[] route : routes) {
            try {
                gps.navigate(route[0], route[1], validator);
            } catch (NavigationFailedException e) {
                System.out.println("Navigation Error: " + e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("Caused by: " + e.getCause().getMessage());
                }
            }
        }
    }
}
