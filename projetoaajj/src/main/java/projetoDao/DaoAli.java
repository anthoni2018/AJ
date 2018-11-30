package projetoDao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoEntidades.Alimento;
import projetoServicos.PersistenciaDacException;
import util.TransacionalCDI;

@ApplicationScoped
public class DaoAli {
	
	public DaoAli() {
		System.out.println("DaoAli.DaoAli()******************");
	}
	
	@Inject
	private EntityManager manager;

	@TransacionalCDI
	public void save(Alimento alimento) throws PersistenciaDacException {
		manager.persist(alimento);
	}
	
	@TransacionalCDI
	public void update(Alimento alimento) throws PersistenciaDacException {
		manager.merge(alimento);
		
	}
	
	@TransacionalCDI
	public void delete(Alimento ali) throws PersistenciaDacException {
		Alimento alimento = manager.find(Alimento.class, ali.getIdAlimento());
		
	}
	
	public Alimento getByID(int idAlimento) throws PersistenciaDacException {
		return manager.find(Alimento.class, idAlimento);
	}
	
	public List<Alimento> getAll() throws PersistenciaDacException {
		Query query = manager.createQuery("from Alimento");
		return query.getResultList();
	}
	
}

