package projetoDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import projetoEntidades.Usuario;
import projetoServicos.PersistenciaDacException;

public class DaoUsu {
	
	private static AtomicInteger ID = new AtomicInteger();
	
	private static Map<Integer,Usuario> REPOSITORY = new ConcurrentHashMap<Integer, Usuario>();

	public void save(Usuario Usuario) throws PersistenciaDacException {
		Usuario.setIdUsuario(ID.getAndIncrement());
		REPOSITORY.put(Usuario.getIdUsuario(), Usuario);
	}

	public void update(Usuario Usuario) throws PersistenciaDacException {
		REPOSITORY.put(Usuario.getIdUsuario(), Usuario);
	}

	public void delete(Usuario Usuario) throws PersistenciaDacException {
		REPOSITORY.remove(Usuario.getIdUsuario());
	}

	public Usuario getByID(int idUsuario) throws PersistenciaDacException {
		return REPOSITORY.get(idUsuario);
	}

	public List<Usuario> getAll() throws PersistenciaDacException {
		return new ArrayList<Usuario>(REPOSITORY.values());
	}
	
}



