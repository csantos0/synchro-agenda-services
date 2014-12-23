package br.com.synchro.exception;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.sun.jersey.api.Responses;

/**
 * 
 * CustomNotFoundException.java
 * Criado em Sep 22, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
@SuppressWarnings("serial")
public class CustomNotFoundException extends WebApplicationException {
	 
	  /**
	  * Create a HTTP 500 exception.
	  */
	  public CustomNotFoundException() {
	    super(Responses.notFound().build());
	  }
	 
	  /**
	  * Create a HTTP 500 exception.
	  * @param message the String that is the entity of the 500 response.
	  */
	  public CustomNotFoundException(String message) {
	    super(Response.status(500).
	    entity(message).type("text/plain").build());
	  }
	}

