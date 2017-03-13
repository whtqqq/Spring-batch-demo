package jp.co.misumi.exception;

public class BatchSkipException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BatchSkipException(String message) {
        super(message);
    }
}