package br.com.itProdigium.dao.impl;

import javax.persistence.EntityManager;

import br.com.itProdigium.dao.UsuarioDao;
import br.com.itProdigium.entity.Usuario;

public class UsuarioDaoImpl extends GenericDaoImpl<Usuario, Integer> implements UsuarioDao{

	public UsuarioDaoImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}



}
