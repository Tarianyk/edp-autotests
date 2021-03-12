package edp.core.exceptions;

public class CustomResourceIsNotFoundException extends RuntimeException {
    public CustomResourceIsNotFoundException() {
        super();
    }

    public CustomResourceIsNotFoundException(String message) {
        super(message);
    }

    public CustomResourceIsNotFoundException(Throwable exception) {
        super(exception);
    }

    public CustomResourceIsNotFoundException(String message, Throwable exception) {
        super(message, exception);
    }
}
