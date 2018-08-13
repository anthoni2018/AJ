package projetoServicos;

import java.util.List;

import projetoDao.DaoExer;
import projetoEntidades.Exercicio;

public class ServicesExer {
	
	private DaoExer Dao = new DaoExer();
	
	public void save(Exercicio exer) throws ServiceDacException {
		try {
			Dao.save(exer);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public void update(Exercicio exer) throws ServiceDacException {
		
		try {
			Dao.update(exer);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public void delete(Exercicio exer) throws ServiceDacException {
		try {
			Dao.delete(exer.getIdExercicio());
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public Exercicio getByID(int exerId) throws ServiceDacException {
		try {
			return Dao.getByID(exerId);
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}

	public List <Exercicio> getAll() throws ServiceDacException {
		try {
			return Dao.getAll();
		} catch (PersistenciaDacException e) {
			throw new ServiceDacException();
		}
	}
}
