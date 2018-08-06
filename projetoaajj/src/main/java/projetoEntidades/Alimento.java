package projetoEntidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alimento")
public class Alimento {

	@Id
	@Column(name = "id_ali")
	private Integer idAlimento;

	private int caloria;
	private String nome;
	private int peso;

	public Integer getIdAlimento() {
		return idAlimento;
	}

	public void setIdAlimento(Integer idAlimento) {
		this.idAlimento = idAlimento;
	}

	public int getCaloria() {
		return caloria;
	}

	public void setCaloria(int caloria) {
		this.caloria = caloria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	@Override
	public String toString() {
		return "Alimento [idAlimento=" + idAlimento + ", caloria=" + caloria + ", nome=" + nome + ", peso=" + peso
				+ "]";
	}
}
