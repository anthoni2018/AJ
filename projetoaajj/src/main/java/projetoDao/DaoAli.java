package projetoDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import projetoEntidades.Alimento;
import projetoServicos.PersistenciaDacException;

public class DaoAli {
	
	private static  EntityManager manager;
	private EntityManagerFactory factory;

	public DaoAli() {
		factory = Persistence.createEntityManagerFactory("banco");
		
	}

	public void save(Alimento alimento) throws PersistenciaDacException {
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(alimento);
		manager.getTransaction().commit();
	}

	public void update(Alimento alimento) throws PersistenciaDacException {
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.merge(alimento);
		manager.getTransaction().commit();
	}

	public void delete(int id) throws PersistenciaDacException {
		manager = factory.createEntityManager();
		manager.getTransaction().begin();
		Alimento alimento = manager.find(Alimento.class, id);
		manager.remove(alimento);
		manager.getTransaction().commit();
	}

	public Alimento getByID(int idAlimento) throws PersistenciaDacException {
		manager = factory.createEntityManager();
		return manager.find(Alimento.class, idAlimento);
	}

	public List<Alimento> getAll() throws PersistenciaDacException {
		manager = factory.createEntityManager();
		Query query = manager.createQuery("from Alimento");
		return query.getResultList();
	}
	
}

