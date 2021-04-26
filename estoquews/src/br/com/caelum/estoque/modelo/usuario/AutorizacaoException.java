package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.ws.WebFault;

/*
 * Anotação para personalizar o wrapper da resposta 
 * para o cliente.
 */
@WebFault(name = "AutorizacaoFault", messageName = "AutorizacaoFault")
public class AutorizacaoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AutorizacaoException(String mensagem) {

		super(mensagem);
	}
	/*
	 * Método que exibe a informação do erro que chamou a exceção.
	 */
	public InfoFault getFaultInfo() {
		return new InfoFault("Token inválido!", new Date());
	}

}
