import javax.management.InvalidApplicationException;

public class SameLocationException extends InvalidApplicationException {
    public SameLocationException(String message) {
        super(message);
    }
}
