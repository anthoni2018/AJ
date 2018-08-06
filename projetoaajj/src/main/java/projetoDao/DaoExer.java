package projetoDao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import projetoEntidades.Exercicio;
import projetoServicos.PersistenciaDacException;

public class DaoExer {
	
	private static  EntityManager manager;
	
	public DaoExer() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
		manager = factory.createEntityManager();
	}

	public void save(Exercicio exercicio) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.persist(exercicio);
		manager.getTransaction().commit();
	}

	public void update(Exercicio exercicio) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.merge(exercicio);
		manager.getTransaction().commit();
	}

	public void delete(int id) throws PersistenciaDacException {
		manager.getTransaction().begin();
		Exercicio exercicio = manager.find(Exercicio.class, id);
		manager.remove(exercicio);
		manager.getTransaction().commit();
	}

	public Exercicio getByID(int idExercicio) throws PersistenciaDacException {
		return manager.find(Exercicio.class, idExercicio);
	}

	public List<Exercicio> getAll() throws PersistenciaDacException {
		Query query = manager.createQuery("from Exercicio");
		return query.getResultList();
	}
	
}
