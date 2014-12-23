package br.com.synchro.dao;

import java.io.Serializable;
import java.util.List;

import br.com.synchro.domain.util.Parameter;
import br.com.synchro.exception.DaoException;

/** 
 * GenericDao.java
 * Criado em Sep 20, 2014
 * @author Ciro S. Santos
 * @version 1.0
 *
 * Interface generica que fornece metodos genericos para persistencia
 *
 * @param <T> Parametro de tipo para representar a classe de entidade a ser persistida
 * @param <ID> Parametro de tipo para representar o id do objeto a ser persistido
 */
public interface GenericDao<T, ID extends Serializable> {	
   
	/**
    * Persiste uma entidade no banco de dados
    *   
    * @param entity entidade a ser persistida
    * @throws DaoException Excecao lancada se ocorrer algum problema
    */
	public void persist(T entity) throws DaoException;

	/**
	 * Atualiza uma entidade no banco de dados 
	 * 
     * @param id id da entidade a ser persistida
     * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	public void update(T entity) throws DaoException;

	/**
	 * Remove uma entidade no banco de dados
	 * 
     * @param id id da entidade a ser persistida
     * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	public void delete(ID id) throws DaoException;
	
	/**
	 * Busca uma entidade no banco de dados filtrando pelo id
	 * 
	 * @param id id da entidade para busca
	 * @return retorna a entidade encontrada
	 * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	public T loadById(ID id) throws DaoException;

	/**
	 * Busca todas as entidades no banco de dados
	 * @return retorna a lista de entidades
	 * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	public List<T> loadAll() throws DaoException;
	
	/**
	 * Executa uma query HQL passada como parametro. 
	 * 
	 * @param hql query a ser executada	 
	 * @param parameters lista de parametros a ser usado pela query
	 * @return lista do tipo passado como parametro
	 * @throws DaoException Excecao lancada se ocorrer algum problema
	 */
	public List<T> executeHqlQuery(String hql, List<Parameter> parameters) throws DaoException;
}