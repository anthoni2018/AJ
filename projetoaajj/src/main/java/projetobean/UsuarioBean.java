package projetobean;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import projetoDao.DaoUsu;
import projetoEntidades.Usuario;
import projetoServicos.PersistenciaDacException;

@ViewScoped
@Named
public class UsuarioBean implements Serializable{
	
	@Inject
	private DaoUsu dao;

	private Usuario usuario;
	private String usuarioBusca;

	public Usuario getUsuario1() {
		return usuario;
	}
	
	@PostConstruct
	public void setUsuarios(Map<Integer, Usuario> usuarios) {
		this.usuario = usuario;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getUsuarioBusca() {
		return usuarioBusca;
	}

	public void setUsuarioBusca(String usuarioBusca) {
		this.usuarioBusca = usuarioBusca;
	}

	public void adicionarUsuario()throws PersistenciaDacException{
		Usuario usuario2 = dao.getByID(usuario.getIdUsuario());

		if (usuario2 == null) {
			dao.save(usuario);

		} else {
			usuario2.setDescricao(usuario.getDescricao());
			usuario2.setIdade(usuario.getIdade());
			usuario2.setNome(usuario.getNome());
			usuario2.setPeso(usuario.getPeso());
			usuario2.setIdUsuario(usuario.getIdUsuario());
		}
		usuario = new Usuario();
	}

	public void removerUsuario(Integer idUsuario)throws PersistenciaDacException {
		Usuario usuario2 = dao.getByID(idUsuario);
		dao.delete(usuario2);
	}

	public UsuarioBean() {
		usuario = new Usuario();
		dao = new DaoUsu();
	}
}
