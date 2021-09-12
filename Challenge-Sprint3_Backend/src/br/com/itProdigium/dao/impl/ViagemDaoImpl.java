package br.com.itProdigium.dao.impl;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.ViagemDao;
import br.com.itProdigium.entity.Viagem;

public class ViagemDaoImpl extends GenericDaoImpl<Viagem, Integer> implements ViagemDao{

	public ViagemDaoImpl(EntityManager em) {
		super(em);
	}

}
