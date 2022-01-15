package asteroids.exception;


public class BadRequestException extends RuntimeException {

    public BadRequestException() {
        super();
    }

    public BadRequestException(String errorMessage) {
        super(errorMessage);
    }

    public BadRequestException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

}
