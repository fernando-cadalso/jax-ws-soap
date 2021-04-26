package br.com.caelum.estoque.ws;

import javax.xml.ws.Endpoint;

public class PublicaEstoqueWS {

	public static void main(String[] args) {

		/*
		 * Instancia uma implementação do web service estoque.
		 */
		EstoqueWS implementaWS = new EstoqueWS();
		/*
		 * Define a URL que o web service vai responder
		 */
		String URL = "http://localhost:8080/estoquews";
		System.out.println("Estoque rodando em " + URL);
		/*
		 * Publica o endpoint associando a instância do WS
		 * com a URL configurada.
		 */
		Endpoint.publish(URL, implementaWS);
		
	}

}
