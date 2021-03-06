package br.com.itProdigium.view;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.itProdigium.singleton.EntityManagerFactorySingleton;
import br.com.itProdigium.dao.CoordenadasDao;
import br.com.itProdigium.dao.UsuarioDao;
import br.com.itProdigium.dao.ViagemDao;
import br.com.itProdigium.dao.impl.CoordenadasDaoImpl;
import br.com.itProdigium.dao.impl.UsuarioDaoImpl;
import br.com.itProdigium.dao.impl.ViagemDaoImpl;
import br.com.itProdigium.entity.Coordenadas;
import br.com.itProdigium.entity.Usuario;
import br.com.itProdigium.entity.Viagem;
import br.com.itProdigium.exception.CommitException;

public class Teste {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		
		UsuarioDao userDao = new UsuarioDaoImpl(em);
		CoordenadasDao coordDao = new CoordenadasDaoImpl(em);
		ViagemDao viagemDao = new ViagemDaoImpl(em);
		
		
		Usuario user = new Usuario("Carlos Henrique", "CarlosHenrique@fiap.com", "119886406", "senhaB0a");
		Usuario user2 = new Usuario("Lucas Abreu", "LucasAbreu@gmail.com", "119886406", "senhaB0a");
		Usuario user3 = new Usuario("NathaliaManso", "NathaliaManso@gmail.com", "119886406", "senhaB0a");
		
		Coordenadas coord = new Coordenadas("81484959412", "464864561815");
		Coordenadas coord2 = new Coordenadas("814567512", "46484554815");
		Coordenadas coord3 = new Coordenadas("91484959412", "6548661815");
		
		List<Coordenadas> listCoordenadas = new ArrayList<Coordenadas>();
		
		Viagem viagem = new Viagem(200, new GregorianCalendar(2021, Calendar.APRIL, 12), listCoordenadas, user);
		
		try {
			userDao.create(user);
			userDao.create(user2);
			userDao.create(user3);
			coordDao.create(coord3);
			coordDao.create(coord2);
			coordDao.create(coord);
			viagemDao.create(viagem);
			userDao.commit();
			coordDao.commit();
			viagemDao.commit();
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		EntityManagerFactorySingleton.getInstance().close();
	}
}
