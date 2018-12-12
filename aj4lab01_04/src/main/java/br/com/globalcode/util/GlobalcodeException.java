/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 */

package br.com.globalcode.util;

public class GlobalcodeException extends Exception {

	public GlobalcodeException(String mensagem, Exception e) {
		super(mensagem, e);
	}

	public GlobalcodeException(String mensagem) {
		super(mensagem);
	}
}
