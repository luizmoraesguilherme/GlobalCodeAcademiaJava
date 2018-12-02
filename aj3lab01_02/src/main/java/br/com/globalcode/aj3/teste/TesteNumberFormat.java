/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 */
package br.com.globalcode.aj3.teste;

import java.text.NumberFormat;
import java.util.Locale;

import br.com.globalcode.aj3.banking.Investimento;
import br.com.globalcode.aj3.banking.impostos.Tributavel;

public class TesteNumberFormat {

	public static void main(String[] args) {

		if (args.length != 3) {
			System.out.println("Forma de utilizacao:");
			System.out.println("TesteInvestimento <valor aplicado> <taxa de rendimento mensal> <meses para aplicacao>");
			System.out.println("ex.: 1300.00 0.016 12");
			return;
		}

		double valorAplicado = Double.parseDouble(args[0]);
		double rendimentoMensal = Double.parseDouble(args[1]);
		int meses = Integer.parseInt(args[2]);

		Investimento investimento = new Investimento(valorAplicado,
				rendimentoMensal, meses);

		// a) Defina um objeto formatador para a moeda brasileira.
		NumberFormat formatador = NumberFormat.getCurrencyInstance( new Locale("pt", "BR"));
		
		
		System.out.println("Resultados:\n");

		// b) Aplique o formatador na impressao dos valores a seguir.
		
//		System.out.printf("Rendimento Bruto -> %.2f \n Rendimento Liquido -> %.2f \n %s  ->  %.2f",
//				formatador.format(investimento.getRendimentoBruto()),
//				formatador.format(investimento.getRendimentoLiquido(),
//				formatador.format(investimento.getRendimentoLiquido()),
//				formatador.format(investimento.getNomeImposto()),
//				formatador.format(investimento.calcularImpostos() ));
		System.out.println("Rendimento Bruto -> "
				+ formatador.format(investimento.getRendimentoBruto()));
		
		System.out.println("Rendimento Liquido -> "
				+ formatador.format(investimento.getRendimentoLiquido()));
		
		System.out.println(investimento.getNomeImposto() + " -> "
				+ formatador.format(investimento.calcularImpostos()));
	}
}
