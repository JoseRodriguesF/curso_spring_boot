package br.edu.senaisp.colegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Aluno;
import br.edu.senaisp.colegio.repository.AlunoRepository;
import br.edu.senaisp.colegio.repository.TurmaRepository;


@Service
public class AlunoService {

	@Autowired
	private AlunoRepository repoAluno;
	
	@Autowired
	private TurmaRepository repoTurma;

	public Aluno gravarAluno(Aluno a) {
		try {
			return repoAluno.save(a);
		}catch(Exception e) {
			throw new RuntimeException("Não foi possivel inserir o aluno");
		}
	}

	public List<Aluno> buscarTodos() {

		return repoAluno.findAll();
	}

	public Aluno buscarPorId(Long id) {
		Optional<Aluno> op = repoAluno.findById(id);
		
		return op.orElse(null);
	}

	public Aluno alterarAluno(Long id, Aluno a) {
		 Optional<Aluno> op = repoAluno.findById(id);
	      
	      if (op.isPresent()) {
	    	  a.setId(id);
	      	  return repoAluno.save(a);
	      }
	      else
	    	  return null;
	}

	public Aluno excluirPorId(Long id) {
		try {
			Aluno a = buscarPorId(id);
			if (a != null) {
				repoAluno.deleteById(id);
				return a;
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
		return null;
	}
}
