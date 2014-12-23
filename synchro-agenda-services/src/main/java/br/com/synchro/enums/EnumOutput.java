package br.com.synchro.enums;

/**
 * 
 * EnumOutput.java
 * Criado em Sep 22, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
public enum EnumOutput {
	
	SUCCESS_ADD(1,"SUCCESS_ADD"),
	SUCCESS_UPDATE(2,"SUCCESS_UPDATE"),
	SUCCESS_DELETE(3,"SUCCESS_DELETE");

	private Integer id;
	private String value;
	
	private EnumOutput(Integer id, String value) {
		this.id = id;
		this.value = value;
	}

	public Integer getId() {
		return id;
	}

	public String getValue() {
		return value;
	}	
}
