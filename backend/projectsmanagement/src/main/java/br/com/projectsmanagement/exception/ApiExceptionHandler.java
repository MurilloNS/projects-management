package br.com.projectsmanagement.exception;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {
	@ExceptionHandler(InvalidIdException.class)
	public ResponseEntity<StandardError> idNotFound(InvalidIdException e, HttpServletRequest request) {
		String error = "Id não encontrado!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(EmailExistException.class)
	public ResponseEntity<StandardError> AlreadyExist(EmailExistException e, HttpServletRequest request) {
		String error = "Esse item já está cadastrado!";
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(NotFinalizedException.class)
	public ResponseEntity<StandardError> NotFinalized(NotFinalizedException e, HttpServletRequest request) {
		String error = "Solicitação negada!";
		HttpStatus status = HttpStatus.METHOD_NOT_ALLOWED;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(EmailNotExistException.class)
	public ResponseEntity<StandardError> emailNotExist(EmailNotExistException e, HttpServletRequest request) {
		String error = "E-mail não encontrado!";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}