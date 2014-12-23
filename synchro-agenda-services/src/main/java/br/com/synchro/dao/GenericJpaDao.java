package br.com.synchro.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.synchro.domain.util.Parameter;
import br.com.synchro.exception.DaoException;
import br.com.synchro.util.StringUtil;

/** 
 * GenericJpaDao.java
 * Criado em Sep 20, 2014
 * @author Ciro S. Santos
 * @version 1.0
 *
 * Classe generica que fornece metodos genericos para persistencia usando JPA
 *
 * @param <T> Parametro de tipo para representar a classe de entidade a ser persistida
 * @param <ID> Parametro de tipo para representar o id do objeto a ser persistido
 */
@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
public abstract class GenericJpaDao<T, ID extends Serializable> implements GenericDao<T, ID> {
	
	private Class<T> persistentClass;
	
	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 * Construtor padrao que atribui o primeiro parametro de tipo ao objeto persistentClass
	 */
	@SuppressWarnings("unchecked")
	public GenericJpaDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}	

	/**
	 * Persiste uma entidade no banco de dados
     *   
     * @param entity entidade a ser persistida
	 * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	@Transactional(readOnly = false, rollbackFor = DaoException.class)
	public void persist(T entity)  throws DaoException{
		try{
			this.entityManager.persist(entity);
		}catch(PersistenceException ex){
			throw new DaoException(this.getClass().getName() + ".persist(T entity)", ex.getMessage(), StringUtil.getStackTrace(ex));
		}
	}

	/**
	 * Atualiza uma entidade no banco de dados 
	 * 
     * @param id id da entidade a ser persistida
     * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	public void update(T entity)  throws DaoException{
		try{			
			this.entityManager.merge(entity);
		}catch(PersistenceException ex){
			throw new DaoException(this.getClass().getName() + ".update(ID id)", ex.getMessage(), StringUtil.getStackTrace(ex));
		}
	}

	/**
	 * Remove uma entidade no banco de dados
	 * 
     * @param id id da entidade a ser persistida
     * @throws DaoException Excecao lancada se ocorrer algum problema
	 */	
	public void delete(ID id)  throws DaoException{
		try{			
			T ent = this.entityManager.find(persistentClass, id);
			this.entityManager.remove(ent);
		}catch(PersistenceException ex){
			throw new DaoException(this.getClass().getName() + ".delete(ID id)", ex.getMessage(), StringUtil.getStackTrace(ex));
		}
	}
	
	/**
	 * Busca uma entidade no banco de dados filtrando pelo id
	 * 
	 * @param id id da entidade para busca
	 * @return retorna a entidade encontrada
	 * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	public T loadById(ID id)  throws DaoException{
		try{
			return this.entityManager.find(persistentClass, id);
		}catch(PersistenceException ex){
			throw new DaoException(this.getClass().getName() + ".loadById(T entity)", ex.getMessage(), StringUtil.getStackTrace(ex));
		}
	}

	/**
	 * Busca todas as entidades no banco de dados
	 * @return retorna a lista de entidades
	 * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	@SuppressWarnings("unchecked")
	public List<T> loadAll()  throws DaoException{
		try{
			String query = "FROM " + persistentClass.getSimpleName();
			return this.entityManager.createQuery(query).getResultList();
		}catch(PersistenceException ex){
			throw new DaoException(this.getClass().getName() + ".loadAll()", ex.getMessage(), StringUtil.getStackTrace(ex));
		}
	}	
	
	/**
	 * Executa uma query HQL passada como parametro. 
	 * 
	 * @param hql query a ser executada	 
	 * @param parameters lista de parametros a ser usado pela query
	 * @return lista do tipo passado como parametro
	 * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<T> executeHqlQuery(String hql, List<Parameter> parameters) throws DaoException{		
		Query query = this.entityManager.createQuery(hql);		
		
		if(parameters != null && parameters.size() > 0){
			for (Parameter parameter : parameters) {
				query.setParameter(parameter.getName(), parameter.getValue());
			}
		}
		return query.getResultList();		
	}
	
	/**
	 * Getter para retornar o tipo passado como primeiro parametro de tipo
	 *  
	 * @return classe persistente
	 */
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
}
