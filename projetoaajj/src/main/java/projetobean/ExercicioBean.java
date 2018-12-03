package projetobean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import projetoDao.DaoExer;
import projetoEntidades.Exercicio;
import projetoServicos.PersistenciaDacException;

@ViewScoped
@Named
public class ExercicioBean implements Serializable{
	
	@Inject
	private DaoExer dao;

	private Exercicio exercicio;
	private String exercicioBusca;
	private List<Exercicio> exercicios;
	
	@PostConstruct
	public void init() {
		exercicio = new Exercicio();
		try {
			setExercicios(dao.getAll());
		} catch (PersistenciaDacException e) {
			e.printStackTrace();
		}
	}

	public List<Exercicio> getExercicios() {
		return exercicios;
	}
	
	public void setExercicios(List<Exercicio> exercicios) {
		this.exercicios = exercicios;
	}
	
	public Exercicio getExercicio() {
		return exercicio;
	}

	public void setExercicio(Exercicio exercicio) {
		this.exercicio = exercicio;
	}

	public String getExercicioBusca() {
		return exercicioBusca;
	}

	public void setExercicioBusca(String exercicioBusca) {
		this.exercicioBusca = exercicioBusca;
	}

	public void adicionarExercicio() throws PersistenciaDacException{
		Exercicio exercicio2 = dao.getByID(exercicio.getIdExercicio());
		if (exercicio2 == null) {
			dao.save(exercicio);

		} else {
			exercicio2.setTipo(exercicio.getTipo());
			exercicio2.setTempo(exercicio.getTempo());
			exercicio2.setCaloriasPerdidas(exercicio.getCaloriasPerdidas());
			exercicio2.setIdExercicio(exercicio.getIdExercicio());
			dao.update(exercicio2);
		}
		exercicio = new Exercicio();
	}

	public void removerExercicio(Integer idExercicio) throws PersistenciaDacException{
		Exercicio exercicio2 = dao.getByID(idExercicio);
		dao.delete(exercicio2);
	}

	public ExercicioBean() {
		exercicio = new Exercicio();
		dao = new DaoExer();
	}
}
