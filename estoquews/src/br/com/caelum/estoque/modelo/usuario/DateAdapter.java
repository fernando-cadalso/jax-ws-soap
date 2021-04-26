package br.com.caelum.estoque.modelo.usuario;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class DateAdapter extends XmlAdapter<String, Date> {

	/*
	 * Define uma string com o formato desejado para data.
	 */
	private String pattern = "dd/MM/yyyy";
	/*
	 * Recebe uma data no formato UTC e devolve no formato dd/MM/yyyy.
	 */
	@Override
	public String marshal(Date date) throws Exception {

		return new SimpleDateFormat(pattern).format(date);
	}
	/*
	 * Recebe uma data no formato dd/MM/yyy e devolve no formato UTC.
	 */
	@Override
	public Date unmarshal(String dateString) throws Exception {
		
		return new SimpleDateFormat(pattern).parse(dateString);
	}

}
