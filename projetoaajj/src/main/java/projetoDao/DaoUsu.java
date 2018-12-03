package projetoDao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import projetoEntidades.Usuario;
import projetoServicos.PersistenciaDacException;
import util.TransacionalCDI;

@ApplicationScoped
public class DaoUsu {
	
	@Inject
	private EntityManager manager;

	@TransacionalCDI
	public void save(Usuario usuario) throws PersistenciaDacException {
		manager.persist(usuario);
	}

	@TransacionalCDI
	public void update(Usuario usuario) throws PersistenciaDacException {
		manager.persist(usuario);
	}

	@TransacionalCDI
	public void delete(Usuario usu) throws PersistenciaDacException {
		Usuario usuario = manager.find(Usuario.class, usu.getIdUsuario());
	}

	public Usuario getByID(int idUsuario) throws PersistenciaDacException {
		return manager.find(Usuario.class, idUsuario);
	}

	public List<Usuario> getAll() throws PersistenciaDacException {
		Query query = manager.createQuery("from Usuario");
		return query.getResultList();
	}
	
}



