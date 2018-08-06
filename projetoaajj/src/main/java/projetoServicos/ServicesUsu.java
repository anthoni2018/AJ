package projetoServicos;

import java.io.Serializable;
import java.util.List;

import projetoDao.DaoUsu;
import projetoEntidades.Usuario;

public class ServicesUsu implements Serializable {
	
	private static final long serialVersionUID = -7803325791425670859L;
	
	private DaoUsu Dao = new DaoUsu();
	
	public void save(Usuario user) throws ServiceDacException {
		try {
			Dao.save(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public void update(Usuario user) throws ServiceDacException {
		
		try {
			Dao.update(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public void delete(Usuario user) throws ServiceDacException {
		try {
			Dao.delete(user);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public Usuario getByID(int userId) throws ServiceDacException {
		try {
			return Dao.getByID(userId);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public List <Usuario> getAll() throws ServiceDacException {
		try {
			return Dao.getAll();
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}


}
