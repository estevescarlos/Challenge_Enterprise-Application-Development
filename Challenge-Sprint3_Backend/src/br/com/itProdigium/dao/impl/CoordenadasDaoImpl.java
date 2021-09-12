package br.com.itProdigium.dao.impl;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.CoordenadasDao;
import br.com.itProdigium.entity.Coordenadas;

public class CoordenadasDaoImpl extends GenericDaoImpl<Coordenadas, Integer> implements CoordenadasDao {

	public CoordenadasDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
