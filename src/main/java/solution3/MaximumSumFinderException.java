package solution3;

public class MaximumSumFinderException extends RuntimeException {

    public MaximumSumFinderException(String message) {
        super(message);
    }

    public MaximumSumFinderException(String message, Exception exception) {
        super(message,exception);
    }
}
