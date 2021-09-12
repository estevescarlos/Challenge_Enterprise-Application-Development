package br.com.itProdigium.exception;

public class EntityNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException() {
		super("Entidade n�o localizada.");
	}
	
	public EntityNotFoundException(String message) {
		super(message);
	}
}
