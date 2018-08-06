package projetobean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import projetoDao.DaoAli;
import projetoEntidades.Alimento;
import projetoServicos.PersistenciaDacException;

@ManagedBean
@ApplicationScoped
public class AlimentoBean {

	private DaoAli dao;

	private Alimento alimento;
	private String alimentoBusca;

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public String getAlimentoBusca() {
		return alimentoBusca;
	}

	public void setAlimentoBusca(String alimentoBusca) {
		this.alimentoBusca = alimentoBusca;
	}

	public void adicionarAlimento() throws PersistenciaDacException {
		Alimento alimento2 = dao.getByID(alimento.getIdAlimento());
		if (alimento2 == null) {
			dao.save(alimento);
		} else {
			alimento2.setCaloria(alimento.getCaloria());
			alimento2.setNome(alimento.getNome());
			alimento2.setPeso(alimento.getPeso());
			alimento2.setIdAlimento(alimento.getIdAlimento());
			dao.update(alimento2);
		}
		alimento = new Alimento();
	}

	public void removerAlimento(Integer idAlimento) throws PersistenciaDacException {
		dao.delete(idAlimento);
	}

	public AlimentoBean() {
		alimento = new Alimento();
		dao = new DaoAli();
	}
}
