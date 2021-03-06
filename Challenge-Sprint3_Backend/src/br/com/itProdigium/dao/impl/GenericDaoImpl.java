package br.com.itProdigium.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.GenericDao;
import br.com.itProdigium.exception.CommitException;
import br.com.itProdigium.exception.EntityNotFoundException;

public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {
	
	private EntityManager em;
	
	private Class<E> classe;
	
	@SuppressWarnings("all")
	public GenericDaoImpl(EntityManager em) {
		this.em = em;
		this.classe = (Class<E>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@Override
	public void create(E entidade) {
		em.persist(entidade);
	}
	
	@Override
	public E search (K id) throws EntityNotFoundException{
		E entidade = em.find(classe, id);
		if(entidade == null)
			throw new EntityNotFoundException();
		return entidade;
	}
	
	@Override
	public void delete(K id) throws EntityNotFoundException{
		E entidade = search(id);
		em.remove(entidade);
	}
	
	@Override
	public void commit() throws CommitException {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		} catch(Exception e) {
			em.getTransaction().rollback();
			throw new CommitException();
		}
	}
	
	@Override
	public void update(E entidade) {
		em.merge(entidade);
	}

}
