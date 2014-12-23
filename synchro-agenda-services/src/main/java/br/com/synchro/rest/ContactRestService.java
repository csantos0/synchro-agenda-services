package br.com.synchro.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.synchro.domain.Contact;
import br.com.synchro.domain.dto.ContactDTO;
import br.com.synchro.exception.CustomNotFoundException;
import br.com.synchro.exception.ServiceException;
import br.com.synchro.service.ContactService;
import br.com.synchro.util.StringUtil;

@Component
@Path("/contact-service")
public class ContactRestService {

    @Autowired
    private ContactService contactService;

    private static Logger logger = Logger.getLogger(ContactRestService.class);

    @POST
    @Path("/post")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response addContact(final Contact contact) {
	String res = "";
	try {
	    res = this.contactService.persist(contact);
	    return Response.status(200).entity(res).build();
	} catch (final ServiceException ex) {
	    res = "Message: " + ex.getMessage() + "|Stack: " + ex.getStack();
	    logger.error(res);
	    throw new CustomNotFoundException(res);
	} catch (final Exception ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res + " : " + StringUtil.getStackTrace(ex));
	    throw new CustomNotFoundException(res);
	}
    }

    @GET
    @Path("/find/{id}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Contact findById(@PathParam("id") final String id) {
	String res = "";
	try {
	    return this.contactService.loadById(id);
	} catch (final ServiceException ex) {
	    res = "Message: " + ex.getMessage() + "|Stack: " + ex.getStack();
	    logger.error(res);
	    throw new CustomNotFoundException(res);
	} catch (final Exception ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res + " : " + StringUtil.getStackTrace(ex));
	    throw new CustomNotFoundException(res);
	}
    }

    /**
     * @return
     */
    @GET
    @Path("/get-all")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<ContactDTO> getContacts() {
	String res = "";
	try {
	    return this.contactService.loadAll();
	} catch (final ServiceException ex) {
	    res = "Message: " + ex.getMessage() + "|Stack: " + ex.getStack();
	    logger.error(res);
	    throw new CustomNotFoundException(res);
	} catch (final Exception ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res + " : " + StringUtil.getStackTrace(ex));
	    throw new CustomNotFoundException(res);
	}
    }

    @GET
    @Path("/get-by-username/{username}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<ContactDTO> getContactsByUsername(@PathParam("username") final String username) {
	String res = "";
	try {
	    return this.contactService.findContactsByUsername(username);
	} catch (final ServiceException ex) {
	    res = "Message: " + ex.getMessage() + "|Stack: " + ex.getStack();
	    logger.error(res);
	    throw new CustomNotFoundException(res);
	} catch (final Exception ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res + " : " + StringUtil.getStackTrace(ex));
	    throw new CustomNotFoundException(res);
	}
    }

    @DELETE
    @Path("/delete/{id}")
    public Response removeContact(@PathParam("id") final String id) {
	String res = "";
	try {
	    res = this.contactService.delete(id);
	    return Response.status(200).entity(res).build();
	} catch (final ServiceException ex) {
	    res = "Message: " + ex.getMessage() + "|Stack: " + ex.getStack();
	    logger.error(res);
	    throw new CustomNotFoundException(res);
	} catch (final Exception ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res + " : " + StringUtil.getStackTrace(ex));
	    throw new CustomNotFoundException(res);
	}
    }

    @GET
    @Path("/search-by-name/{username}/{name}")
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<ContactDTO> searchContactByName(@PathParam("username") final String username, @PathParam("name") final String name) {
	String res = "";
	try {
	    return this.contactService.searchByName(name, username);
	} catch (final ServiceException ex) {
	    res = "Message: " + ex.getMessage() + "|Stack: " + ex.getStack();
	    logger.error(res);
	    throw new CustomNotFoundException(res);
	} catch (final Exception ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res + " : " + StringUtil.getStackTrace(ex));
	    throw new CustomNotFoundException(res);
	}
    }

    @PUT
    @Path("/put")
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public Response updateContact(final Contact contact) {
	String res = "";
	try {
	    res = this.contactService.update(contact);
	    return Response.status(200).entity(res).build();
	} catch (final ServiceException ex) {
	    res = "Message: " + ex.getMessage() + "|Stack: " + ex.getStack();
	    logger.error(res);
	    throw new CustomNotFoundException(res);
	} catch (final Exception ex) {
	    res = "Message: " + ex.getMessage();
	    logger.error(res + " : " + StringUtil.getStackTrace(ex));
	    throw new CustomNotFoundException(res);
	}
    }
}
