package webtester.exception;

public class WebtesterApplicationException extends RuntimeException {

	private static final long serialVersionUID = 7691404181785512527L;

	
	public WebtesterApplicationException(String message) {
		super(message);
	}

	public WebtesterApplicationException(Throwable cause) {
		super(cause);
	}

	public WebtesterApplicationException(String message, Throwable cause) {
		super(message, cause);
	}



}
