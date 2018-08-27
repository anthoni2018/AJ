package projetoServicos;

import java.util.List;

import projetoDao.DaoAli;
import projetoEntidades.Alimento;

public class ServicesAli {
	
	private DaoAli Dao = new DaoAli();
	
	public void save(Alimento ali) throws ServiceDacException {
		try {
			Dao.save(ali);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public void update(Alimento ali) throws ServiceDacException {
		
		try {
			Dao.update(ali);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public void delete(Alimento ali) throws ServiceDacException {
		try {
			Dao.delete(ali);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public Alimento getByID(int aliId) throws ServiceDacException {
		try {
			return Dao.getByID(aliId);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public List <Alimento> getAll() throws ServiceDacException {
		try {
			return Dao.getAll();
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}


}
