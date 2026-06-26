import javax.management.InvalidApplicationException;

public interface RouteValidator {

    boolean isValidCommuteRoute(String origin,
                                String destination,
                                double distanceKm)
            throws InvalidApplicationException;
}