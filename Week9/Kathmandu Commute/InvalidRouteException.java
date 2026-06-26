public class InvalidRouteException extends Exception {
    public InvalidRouteException(String message) {
        super(message);
    }

    public InvalidRouteException(String message, Throwable cause) {
        super(message, cause);
    }
}
