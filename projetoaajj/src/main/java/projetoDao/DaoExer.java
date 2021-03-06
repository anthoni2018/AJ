package projetoDao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoEntidades.Exercicio;
import projetoServicos.PersistenciaDacException;
import util.TransacionalCDI;

@ApplicationScoped
public class DaoExer {
	
	@Inject
	private EntityManager manager;

	@TransacionalCDI
	public void save(Exercicio exercicio) throws PersistenciaDacException {
		manager.persist(exercicio);
	}

	@TransacionalCDI
	public void update(Exercicio exercicio) throws PersistenciaDacException {
		manager.merge(exercicio);
	}

	@TransacionalCDI
	public void delete(Exercicio exer) throws PersistenciaDacException {
		Exercicio exercicio = manager.find(Exercicio.class, exer.getIdExercicio());
	}
	
	public Exercicio getByID(int idExercicio) throws PersistenciaDacException {
		return manager.find(Exercicio.class, idExercicio);
	}

	public List<Exercicio> getAll() throws PersistenciaDacException {
		Query query = manager.createQuery("from Exercicio");
		return query.getResultList();
	}
	
}
