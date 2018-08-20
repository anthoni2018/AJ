package projetoEntidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class Usuario implements Identificavel {

	@Id
	@Column(name = "id_usu")
	private Integer idUsuario;

	
	@GeneratedValue(generator="usuario_seq", strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="usuario_seq")
	private Long id;
	private int peso;
	private int idade;
	private String descricao;
	private String email;
	private String nome;
	private Date nascimento;
	private String username;
	private String password;
	private String grupo;
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGrupo() {
		return grupo;
	}
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", id=" + id + ", peso=" + peso + ", idade=" + idade + ", descricao="
				+ descricao + ", email=" + email + ", nome=" + nome + ", nascimento=" + nascimento + ", username="
				+ username + ", password=" + password + ", grupo=" + grupo + ", getIdUsuario()=" + getIdUsuario()
				+ ", getId()=" + getId() + ", getPeso()=" + getPeso() + ", getIdade()=" + getIdade()
				+ ", getDescricao()=" + getDescricao() + ", getEmail()=" + getEmail() + ", getNome()=" + getNome()
				+ ", getNascimento()=" + getNascimento() + ", getUsername()=" + getUsername() + ", getPassword()="
				+ getPassword() + ", getGrupo()=" + getGrupo() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	
}