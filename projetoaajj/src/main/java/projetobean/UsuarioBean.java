package projetobean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import projetoEntidades.Usuario;

@ViewScoped
@Named
public class UsuarioBean implements Serializable{
	
	@Inject
	private Map<Integer, Usuario> usuarios;

	private Usuario usuario;
	private String usuarioBusca;

	public Map<Integer, Usuario> getUsuarios() {
		return usuarios;
	}
	
	@PostConstruct
	public void setUsuarios(Map<Integer, Usuario> usuarios) {
		this.usuarios = usuarios;
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

	public void adicionarUsuario() {
		Usuario usuario2 = usuarios.get(usuario.getIdUsuario());

		if (usuario2 == null) {
			usuarios.put(usuario.getIdUsuario(), usuario);

		} else {
			usuario2.setDescricao(usuario.getDescricao());
			usuario2.setIdade(usuario.getIdade());
			usuario2.setNome(usuario.getNome());
			usuario2.setPeso(usuario.getPeso());
			usuario2.setIdUsuario(usuario.getIdUsuario());
		}
		usuario = new Usuario();
	}

	public void removerUsuario(Integer idUsuario) {
		usuarios.remove(idUsuario);
	}

	public UsuarioBean() {
		usuario = new Usuario();
		usuarios = new HashMap<Integer, Usuario>();
	}
}
