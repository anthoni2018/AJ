package projetoServicos;

import java.io.Serializable;
import java.util.List;

import projetoDao.DaoProf;
import projetoEntidades.Professor;

public class ServicesProf implements Serializable {
	
	private static final long serialVersionUID = -7803325791425670859L;
	
	private DaoProf Dao = new DaoProf();
	
	public void save(Professor prof) throws ServiceDacException {
		try {
			Dao.save(prof);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public void update(Professor prof) throws ServiceDacException {
		
		try {
			Dao.update(prof);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public void delete(Professor prof) throws ServiceDacException {
		try {
			Dao.delete(prof);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public Professor getByID(int profId) throws ServiceDacException {
		try {
			return Dao.getByID(profId);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public List <Professor> getAll() throws ServiceDacException {
		try {
			return Dao.getAll();
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

}
