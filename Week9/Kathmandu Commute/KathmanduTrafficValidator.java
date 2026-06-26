public class KathmanduTrafficValidator implements RouteValidator {

    @SuppressWarnings("override")
    public boolean isValidCommuteRoute(String origin, String destination, double distanceKm)
            throws InvalidRouteException {

        if (origin.equalsIgnoreCase(destination)) {
            throw new InvalidRouteException(
                    "Origin and destination cannot be the same! Are you just spinning in circles, Damodar?");
        }

        if (distanceKm < 0.1 || distanceKm > 30) {
            throw new InvalidRouteException(
                    "Distance " + distanceKm + " km is unrealistic for Kathmandu commute!");
        }

        return true;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        KathmanduTrafficValidator validator = new KathmanduTrafficValidator();

        String[][] routes = {
                {"Thamel", "Thamel"},
                {"Baneshwor", "Patan"},
                {"Chabahil", "Budhanilkantha"},
                {"Koteshwor", "Bhaktapur"}
        };

        double[] distances = {5.0, 4.5, 0.05, 35.0};

        for (int i = 0; i < routes.length; i++) {
            try {
                boolean valid = validator.isValidCommuteRoute(
                        routes[i][0],
                        routes[i][1],
                        distances[i]);

                if (valid) {
                    System.out.println("Route from " + routes[i][0] +
                            " to " + routes[i][1] + " is valid.");
                }

            } catch (InvalidRouteException e) {
                System.out.println("Invalid Route Error: " + e.getMessage());
            }
        }
    }
}