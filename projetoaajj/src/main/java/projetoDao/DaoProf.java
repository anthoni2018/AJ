package projetoDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import projetoEntidades.Professor;
import projetoServicos.PersistenciaDacException;

public class DaoProf {
	
	private static  EntityManager manager;
	
	public DaoProf() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("banco");
		manager = factory.createEntityManager();
	}

	public void save(Professor professor) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.persist(professor);
		manager.getTransaction().commit();
	}

	public void update(Professor professor) throws PersistenciaDacException {
		manager.getTransaction().begin();
		manager.merge(professor);
		manager.getTransaction().commit();
	}

	public void delete(Professor id) throws PersistenciaDacException {
		manager.getTransaction().begin();
		Professor professor = manager.find(Professor.class, id);
		manager.remove(professor);
		manager.getTransaction().commit();
	}

	public Professor getByID(int idProfessor) throws PersistenciaDacException {
		return manager.find(Professor.class, idProfessor);
	}

	public List<Professor> getAll() throws PersistenciaDacException {
		Query query = manager.createQuery("from Professor");
		return query.getResultList();
	}
	
}

