package br.com.globalcode.aj3.datas;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

// a) importacao de bibliotecas

/**
 * Classe que realiza a formatacao de datas
 * 
 * @author Globalcode
 */
public class FormataDatas {

	public static void main(String[] args) {

		// b) Criacao do objeto Calendar
		Calendar cal = Calendar.getInstance();

		// c) Alteracao dos dados do calendario para
		// 03 de março de 1997, as 18h57m0s
		cal.set(Calendar.DAY_OF_MONTH, 03);
		cal.set(Calendar.MONTH, 02);
		cal.set(Calendar.YEAR, 1997);
		cal.set(Calendar.HOUR, 18);
		cal.set(Calendar.MINUTE, 57);
		cal.set(Calendar.SECOND, 00);
		

		// d) Obtencao do Date a partir do Calendar
		Date data = cal.getTime();
		System.out.println("data: " + data);

		// e) Construcao do objeto para formatacao especifica
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MMM/yy HH mm ss");
		System.out.println("data formatada com SimpleDateFormat: "
				+ formatador.format(data));
		System.out.println("data atual formatada com SimpleDateFormat: "
				+ formatador.format(new Date()));

		// f) Construcao do objeto para formatacao padrao
		DateFormat formatador2 = new SimpleDateFormat("dd/MMM/yy HH mm ss");;
		System.out.println("data formatada com DateFormat: "
				+ formatador2.format(data));
		System.out.println("data atual formatada com DateFormat: "
				+ formatador.format(new Date()));

	}
}
