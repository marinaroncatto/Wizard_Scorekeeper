package entities.excepitions;

public class WizardException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public WizardException(String msg) {
		super(msg);
	}
	
}
