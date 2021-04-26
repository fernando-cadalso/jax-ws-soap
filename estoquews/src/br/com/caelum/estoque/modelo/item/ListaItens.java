package br.com.caelum.estoque.modelo.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
 * Anotação para o JAX-B serializar ou desserializar
 * essa classe entre conteúdo XML e objeto Java.
 */
@XmlRootElement
/*
 * Anotação para incluir todos os atributos
 * na serialização ou desserialização.
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListaItens {

	/*
	 * Configura cada item da lista como um elemento
	 * da serialização XML para ser apresentado
	 * dentro da tag items na respota XML.
	 */
	@XmlElement(name = "item")
	private List<Item> itens;

	public ListaItens(List<Item> itens) {
		this.itens = itens;
	}

	ListaItens() {
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
}
