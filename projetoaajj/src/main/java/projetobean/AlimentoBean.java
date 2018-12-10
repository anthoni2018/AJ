package projetobean;

import java.io.Serializable;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projetoDao.DaoAli;
import projetoEntidades.Alimento;
import projetoServicos.PersistenciaDacException;

@SessionScoped
@Named
public class AlimentoBean implements Serializable{
	
	@Inject
	private DaoAli dao;

	private Alimento alimento;
	private Collection<Alimento> alimentos;
	
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

	public void removerAlimento(Alimento idAlimento) throws PersistenciaDacException {
		dao.delete(idAlimento);
	}

	@PostConstruct
	public void init() throws PersistenciaDacException {
		alimento = new Alimento();
		alimentos = getDao().getAll();
	}
	
	public DaoAli getDao() {
		return dao;
	}
	
	public void setDao(DaoAli dao) {
		this.dao = dao;
	}

	public Collection<Alimento> getAlimentos() {
		return alimentos;
	}

	public void setAlimentos(Collection<Alimento> alimentos) {
		this.alimentos = alimentos;
	}
	
}
