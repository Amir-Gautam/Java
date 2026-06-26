public interface NavigationService<RouteValidator> {

    void navigate(String startPoint,
                  String endPoint,
                  RouteValidator validator)
            throws NavigationFailedException;
}