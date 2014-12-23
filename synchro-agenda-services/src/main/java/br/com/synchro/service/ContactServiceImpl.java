package br.com.synchro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.synchro.dao.impl.ContactDao;
import br.com.synchro.domain.Contact;
import br.com.synchro.domain.dto.ContactDTO;
import br.com.synchro.domain.dto.DTOConverter;
import br.com.synchro.enums.EnumOutput;
import br.com.synchro.exception.DaoException;
import br.com.synchro.exception.ServiceException;
/**
 * 
 * ContactServiceImpl.java
 * Criado em Sep 21, 2014
 * @author Ciro S. Santos
 * @version 1.0
 */
@Service
public class ContactServiceImpl implements ContactService{
	
	@Autowired
	private ContactDao contactDao;

	@Override
	public String persist(Contact entity) throws ServiceException {
		try{
			this.contactDao.persist(entity);
			return EnumOutput.SUCCESS_ADD.getValue();
		}catch (DaoException ex) {
			throw new ServiceException(ex.getMethodName(), ex.getMessage(), ex.getStack());
		}		
	}

	@Override
	public String update(Contact entity) throws ServiceException {
		try{
			this.contactDao.update(entity);
			return EnumOutput.SUCCESS_UPDATE.getValue();
		}catch (DaoException ex) {
			throw new ServiceException(ex.getMethodName(), ex.getMessage(), ex.getStack());
		}				
	}

	@Override
	public String delete(String id) throws ServiceException {
		try{
			this.contactDao.delete(Long.valueOf(id));
			return EnumOutput.SUCCESS_DELETE.getValue();
		}catch (DaoException ex) {
			throw new ServiceException(ex.getMethodName(), ex.getMessage(), ex.getStack());
		}
	}

	@Override
	public Contact loadById(String id) throws ServiceException {
		try{
			return this.contactDao.loadById(Long.valueOf(id));
		}catch (DaoException ex) {
			throw new ServiceException(ex.getMethodName(), ex.getMessage(), ex.getStack());
		}
	}
	
	@Override
	public List<ContactDTO> searchByName(String name, String username) throws ServiceException {
		try{
			List<Contact> list = this.contactDao.searchContactsByName(name, username);
			return DTOConverter.convertToList(list);
		}catch (DaoException ex) {
			throw new ServiceException(ex.getMethodName(), ex.getMessage(), ex.getStack());
		}
	}

	@Override
	public List<ContactDTO> loadAll() throws ServiceException {
		try{			
			List<Contact> list = this.contactDao.loadAll();			
			return DTOConverter.convertToList(list);
		}catch (DaoException ex) {
			throw new ServiceException(ex.getMethodName(), ex.getMessage(), ex.getStack());
		}
	}
	
	public List<ContactDTO> findContactsByUsername(String username) throws ServiceException{
		try{
			List<Contact> list = this.contactDao.findContactsByUsername(username);
			return DTOConverter.convertToList(list);		
		}catch (DaoException ex) {
			throw new ServiceException(ex.getMethodName(), ex.getMessage(), ex.getStack());
		}
	}
}
