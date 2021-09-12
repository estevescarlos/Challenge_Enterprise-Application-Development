package br.com.itProdigium.dao;

import br.com.itProdigium.exception.CommitException;
import br.com.itProdigium.exception.EntityNotFoundException;

public interface GenericDao<E, K> {
	
	void create (E entidade);
	
	E search(K id) throws EntityNotFoundException;
	
	void update (E entidade);
	
	void delete(K id) throws EntityNotFoundException;
	
	void commit() throws CommitException;
}
