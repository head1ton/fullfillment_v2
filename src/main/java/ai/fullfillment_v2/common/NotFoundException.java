package ai.fullfillment_v2.common;

public class NotFoundException extends RuntimeException {

    public NotFoundException(final String message) {
        super(message);
    }
}
