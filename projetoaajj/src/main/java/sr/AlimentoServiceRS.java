package sr;

import javax.inject.Inject;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;

import projetoEntidades.Alimento;
import projetobean.AlimentoService;

@Path("/user")
public class AlimentoServiceRS {
	@Inject
	private AlimentoService alimentoService;
	
	// http://localhost:8080/aj/rest/user/nome/1
	@GET
	@Path("/nome/{idalimento}")
	@Produces("text/html")
	public String getNome(@PathParam("idalimento") Long idalimento) {
		return "<h1>"+alimentoService.getByID(idalimento).getNome()+"</h1>";
	}
	// http://localhost:8080/AJ/rest/alimento/list
	@GET
	@Path("/list")
	@Produces("text/html")
	public String list() {
		String retorno = "<ul>";
		List<Alimento> alimentos = alimentoService.getAll();
		for(Alimento u: alimentos) {
			retorno += "<li>"+u.getNome()+"</li>";
		}
		return retorno + "</ul>";
	}
	
	
	@GET
	@Path("/add/{user}")
	public String add(@PathParam("user") PathSegment atributos) {
		MultivaluedMap<String, String> matrixParameters = atributos.getMatrixParameters();
		String nome = matrixParameters.getFirst("nome");
		String caloria = matrixParameters.getFirst("caloria");
		String idalimento = matrixParameters.getFirst("idalimento");
		String peso = matrixParameters.getFirst("idpeso");
		String password = matrixParameters.getFirst("password");
		String username = matrixParameters.getFirst("alimento");
		Alimento u = new Alimento();
		u.setCaloria(caloria);
		u.setPeso(peso);
		u.setGrupo("OUTROS");
		u.setIdAlimento(Long.parseLong(idalimento));
		u.setNome(nome);
		u.setPassword(password);
		u.setAlimento(alimentonome);
		alimentoService.salvar(u);
		return "Salvo com sucesso";
	}
	
	public AlimentoService getAlimentoService() {
		return alimentoService;
	}
	
	public void setUserService(AlimentoService alimentoService) {
		this.alimentoService = alimentoService;
	}

}
