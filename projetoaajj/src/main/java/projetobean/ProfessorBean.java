package projetobean;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import projetoEntidades.Professor;

@ViewScoped
@Named
public class ProfessorBean {
    
	@Inject
	private Map<Integer, Professor> professores;
    
	private Professor professor;
	private String professorBusca;
	
	public Map<Integer, Professor> getProfessores() {
    	return professores;
	}
	
	@PostConstruct
	public void setProfessores(Map<Integer, Professor> professores) {
    	this.professores = professores;
	}
    
	public Professor getProfessor() {
   	 return professor;
    }
    public void setProfessor(Professor professor) {
   	 this.professor = professor;
    }
    public String getProfessorBusca() {
   	 return professorBusca;
    }
    public void setProfessorBusca(String professorBusca) {
   	 this.professorBusca = professorBusca;
    }
    
    public void adicionarProfessor() {
   	 Professor professor2 = professores.get(professor.getIdProfessor());
   	 
    	if (professor2 == null) {
   		 professores.put(professor.getIdProfessor(), professor);    
       	 
    	}else {
   		 professor2.setDescricao(professor.getDescricao());
   		 professor2.setIdade(professor.getIdade());
   		 professor2.setNome(professor.getNome());
   		 professor2.setIdProfessor(professor.getIdProfessor());
    	}
    	professor = new Professor();
	}
    
	public void removerProfessor(Integer idProfessor) {
   	 professores.remove(idProfessor);
	}
    
	public ProfessorBean() {
   	 professor = new Professor();
   	 professores = new HashMap<Integer, Professor>();
	}
}
