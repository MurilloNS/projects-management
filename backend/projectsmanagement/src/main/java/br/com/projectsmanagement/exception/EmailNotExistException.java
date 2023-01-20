package br.com.projectsmanagement.exception;

public class EmailNotExistException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmailNotExistException(String message) {
		super(message);
	}
}