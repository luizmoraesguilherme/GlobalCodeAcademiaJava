
public class SaldoInsuficienteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaldoInsuficienteException(String e) {
		super(e);
		this.print();
	}

	public void print() {
		System.out.println("ERROUUUUU");
		
	}

}
