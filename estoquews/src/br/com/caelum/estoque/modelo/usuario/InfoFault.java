package br.com.caelum.estoque.modelo.usuario;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
/*
 * Serializa objeto para XML
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class InfoFault {

	private String string;
	private Date date;

	public InfoFault(String string, Date date) {
		this.string = string;
		this.date = date;
	}
	
	//Requisito para o JAX-B
	public InfoFault() {}
}
