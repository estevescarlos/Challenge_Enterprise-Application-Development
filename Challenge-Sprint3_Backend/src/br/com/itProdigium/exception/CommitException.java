package br.com.itProdigium.exception;

public class CommitException extends Exception {

	private static final long serialVersionUID = 1L;


	public CommitException() {
		super("N?o foi poss?vel realizar o commit.");
	}
	
	public CommitException(String message) {
		super(message);
	}
}
