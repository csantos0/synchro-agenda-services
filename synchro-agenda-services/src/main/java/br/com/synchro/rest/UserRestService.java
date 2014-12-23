package br.com.synchro.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.synchro.domain.User;
import br.com.synchro.exception.CustomNotFoundException;
import br.com.synchro.exception.ServiceException;
import br.com.synchro.service.UserService;
import br.com.synchro.util.StringUtil;

/**
 * 
 * UserRestService.java
 * Criado em Sep 24, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
@Component
@Path("/user-service")
public class UserRestService {

	@Autowired
	private UserService userService;
	
	private static Logger logger = Logger.getLogger(UserRestService.class);
	
	@POST
	@Path("/post")
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})	
	public Response addContact(User user){
		String res = "";
		try {
			user.setId(null);
			res = this.userService.persist(user);
			return Response.status(200).entity(res).build();
		} catch (ServiceException ex) {
			res = "Message: " + ex.getMessage() + "|Stack: " + ex.getStack();
			logger.error(res);
			throw new CustomNotFoundException(res);
		} catch(Exception ex){
			res =  "Message: " + ex.getMessage();
			logger.error(res + " : " + StringUtil.getStackTrace(ex));
			throw new CustomNotFoundException(res);
		}
	}
	
	@GET
	@Path("/find-user/{username}")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public User findUserByUsername(@PathParam("username")String username){
		String res="";
		try {			
			User user = this.userService.findUserByUsername(username);
			if(user == null){
				user = new User();
				user.setId(0);
				return user;
			}else{
				return this.userService.findUserByUsername(username);
			}
			
		} catch(Exception ex){
			res =  "Message: " + ex.getMessage();
			logger.error(res + " : " + StringUtil.getStackTrace(ex));
			throw new CustomNotFoundException(res);
		}	
	}
}
