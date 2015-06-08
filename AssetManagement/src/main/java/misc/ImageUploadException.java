package misc;

/**
 * Created by Adrian on 14-Sep-14.
 */
public class ImageUploadException extends RuntimeException {
	public ImageUploadException(String message) {
		super(message);
	}

	public ImageUploadException(String message, Throwable cause) {
		super(message, cause);
	}
}
