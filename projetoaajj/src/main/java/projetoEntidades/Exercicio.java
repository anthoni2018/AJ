package projetoEntidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "exercicio")
public class Exercicio {

	@Id
	@Column(name = "id_exer")
	private Integer idExercicio;

	private String tipo;
	private Integer tempo;
	private String caloriasPerdidas;
	private String nivelExercicio;

	public String getNivelExercicio() {
		return nivelExercicio;
	}

	public void setNivelExercicio(String nivelExercicio) {
		this.nivelExercicio = nivelExercicio;
	}

	public Integer getIdExercicio() {
		return idExercicio;
	}

	public void setIdExercicio(Integer idExercicio) {
		this.idExercicio = idExercicio;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getTempo() {
		return tempo;
	}

	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}

	public String getCaloriasPerdidas() {
		return caloriasPerdidas;
	}

	public void setCaloriasPerdidas(String caloriasPerdidas) {
		this.caloriasPerdidas = caloriasPerdidas;
	}

	@Override
	public String toString() {
		return "Exercicio [idExercicio=" + idExercicio + ", tipo=" + tipo + ", tempo=" + tempo + ", caloriasPerdidas="
				+ caloriasPerdidas + ", nivelExercicio=" + nivelExercicio + "]";
	}

}
