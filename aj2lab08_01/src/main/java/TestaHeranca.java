/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Esta classe e responsavel pelo teste das Herancas desenvolvidas nas classes 
 *  Conta e ContaEspecial
 * 
 * Altere o metodo main fazendo com que sejam criadas 02 contas especiais e 01 conta poupanca. 
 * Realize 1 saque na 1a. conta especial cujo valor exceda o saldo mas nao ultrapasse o limite.
 * Realize 1 saque na 2a. conta especial cujo valor ultrapasse o saldo e o limite.
 * Realize 1 saque na conta poupanca que exceda o saldo.
 * Imprima os dados das contas para conferir se estao corretas.
 * 
 * Dica: Para obter a data do sistema e transformar em String: 
 *  String strData = new java.util.Date().toString();
 * 
 */
public class TestaHeranca {

    public static void main(String args[]) {
        Banco banco = new Banco("Globalcode Bank", 1000);
        Agencia ag1 = new Agencia("001", banco);
        
        Cliente cliente1 = new Cliente("Cliente 1", "1232323");
        Cliente cliente2 = new Cliente("Cliente 2", "987789");
        
        Conta conta = new Conta(500, "741852", cliente1, ag1); // conta comum
        conta.saque(560);
        conta.imprimeDados();
        System.out.println();
        
        ContaEspecial contaEsp1 = null; // 1a. conta especial
        
        ContaEspecial contaEsp2 = null; // 2a. conta especial
        
        ContaPoupanca contaPoup = null; // conta poupanca
        
        
        
    }
}
