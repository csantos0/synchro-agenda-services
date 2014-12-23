package br.com.synchro.domain.util;

import java.io.Serializable;

/**
 * Parameter.java
 * Criado em Aug 30, 2010
 * @author Ciro S. Santos
 * @version 1.0
 * 
 * Responsavel por fornecer os parametros a serem inseridos nas queries genericas da aplicacao.
 */
@SuppressWarnings("serial")
public class Parameter implements Serializable{
	
	private String name;
	
	private Object value;
	
	public Parameter(){		
	}

	public Parameter(String name, Object value) {		
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}	
}
