package br.com.flavianeris.recrutamento.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.flavianeris.recrutamento.services.exceptions.DatabaseException;
import br.com.flavianeris.recrutamento.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
		String error = "Recurso não encontrado";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError stError = new StandardError(Instant.now(), status.value(),e.getMessage(), 
												  error, request.getRequestURI());
		return ResponseEntity.status(status).body(stError);
	}
	
//	@ExceptionHandler(DatabaseException.class)
//	public ResponseEntity<StandardError> database(ResourceNotFoundException e, HttpServletRequest request){
//		String error = "Erro no banco de dados";
//		HttpStatus status = HttpStatus.BAD_REQUEST;
//		StandardError stError = new StandardError(Instant.now(), status.value(),e.getMessage(), 
//												  error, request.getRequestURI());
//		return ResponseEntity.status(status).body(stError);
//	}
}
