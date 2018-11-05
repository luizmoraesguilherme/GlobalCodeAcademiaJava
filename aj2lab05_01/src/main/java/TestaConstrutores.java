/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java 
 * 1) Construa um objeto da classe Conta com cada construtor e chame o metodo imprimeDados 
 * 2) Construa um objeto da classe Cliente e chame o metodo imprimeDados
 * 
 */
public class TestaConstrutores {

    public static void main(String[] args) {
    	Conta c = new Conta(2000, "432-4", "Mario Prata", "5432", 104);
    	c.imprimeDados();
    	Conta c2 = new Conta("5432-7", "luiz.moraes", "345", 101);
    	c2.imprimeDados();
//    	Conta c3 = new Conta("juca teles", "34535434");
//    	c2.imprimeDados();
    	
    }
}
