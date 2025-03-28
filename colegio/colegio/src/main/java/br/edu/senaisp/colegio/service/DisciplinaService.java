package br.edu.senaisp.colegio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinaRepository repoDisciplina;

	public List<Disciplina> buscarTodos() {
		return repoDisciplina.findAll();
	}
	
	public Disciplina bsucarPorId(Long id) {
		return repoDisciplina.findById(id).orElse(null);
	}

	public Disciplina gravarDisciplina(Disciplina d) {
		try {
			return repoDisciplina.save(d);
		} catch (Exception e) {
			throw new RuntimeException("Não foi possivel inserir a disciplina");
		}
	}

	public Disciplina alterarPorId(Long id, Disciplina disciplina) {
		Optional<Disciplina> op = repoDisciplina.findById(id);

		if (op.isPresent()) {
			disciplina.setId(id);
			return repoDisciplina.save(disciplina);
		} else {
			return null;
		}

	}

	public Disciplina excluirPorId(Long id) {
		try {
			Opitional<Disciplina> d = repoDisciplina.findAllById(id);
			if (d != null) {
				repoDisciplina.deleteById(id);
				return d;
			}
		}catch (Exception e) {
				throw new RuntimeException("Error: " + e.getMessage());
			}
			return null;
	}
}
