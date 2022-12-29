package br.com.projectsmanagement.exception;

public class NotFinalizedException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NotFinalizedException(String message) {
		super(message);
	}
}
