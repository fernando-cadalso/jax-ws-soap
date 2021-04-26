package br.com.caelum.estoque.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.ResponseWrapper;

import br.com.caelum.estoque.modelo.item.Filtro;
import br.com.caelum.estoque.modelo.item.Filtros;
import br.com.caelum.estoque.modelo.item.Item;
import br.com.caelum.estoque.modelo.item.ItemDao;
import br.com.caelum.estoque.modelo.item.ItemValidador;
import br.com.caelum.estoque.modelo.item.ListaItens;
import br.com.caelum.estoque.modelo.usuario.AutorizacaoException;
import br.com.caelum.estoque.modelo.usuario.TokenDao;
import br.com.caelum.estoque.modelo.usuario.TokenUsuario;

/*
 * Define essa classe como um Web service SOAP,
 * que responde requisições HTTP
 */
@WebService
public class EstoqueWS {

	/*
	 * Injeta a dependência para acesso a persistência dos itens do estoque
	 */
	private ItemDao dao = new ItemDao();

	/*
	 * Define um nome para o método no contrato WSDL
	 */
	@WebMethod(operationName = "TodosOsItens")
	/*
	 * Define um nome para a tag XML que embrulha cada item retornado pelo serviço.
	 */
	@WebResult(name = "itens")
	/*
	 * Define um nome para o prefixo do namespace na resposta do serviço. 
	 */
	@ResponseWrapper(localName = "itens")
	public ListaItens getItens(@WebParam(name = "filtros") Filtros filtros) {
		/*
		 * A anotação @WebParam renderiza o patrâmetro com o nome configurado
		 * no atributo nome e embrulha, wrapper, os filtros exibidos na requisição.
		 */
		System.out.println("Chamei ListaItens()");
		List<Filtro> lista = filtros.getLista();
		List<Item> itensResultado = dao.todosItens(lista);
		/*
		 * Devolvo uma instância da ListaItens que personaliza o embrulho de cada item
		 * retornado.
		 */
		return new ListaItens(itensResultado);
	}
	/*
	 * Define um nome para o método no contrato WSDL
	 */
	@WebMethod(operationName = "CadastrarItem")
	/*
	 * Define um nome para tag XML que embrulha o item retornado pelo serviço
	 * após o cadastro.
	 */
	@WebResult(name = "item")
	public Item cadastrarItem(@WebParam(name = "tokenUsuario", header = true) TokenUsuario token, 
			@WebParam(name = "item") Item item) throws AutorizacaoException {
		
		System.out.println("Cadastrando o item " + item);
		/*
		 * Verifica se o token recebido na requisição é válido.
		 */
		if (!new TokenDao().ehValido(token)) {
			throw new AutorizacaoException("Autorização falhou.");
		}
		/*
		 * Valida o item recebido na mensagem da requisição.
		 */
		new ItemValidador(item).validate();
		
		dao.cadastrar(item);
		return item;
	}

}
