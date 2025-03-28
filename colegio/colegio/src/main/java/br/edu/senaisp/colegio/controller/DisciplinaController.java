package br.edu.senaisp.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.service.DisciplinaService;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaService disciplinaService;

	@GetMapping
	public ResponseEntity buscarTodos() {
		return ResponseEntity.ok(disciplinaService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity buscarPorId(@PathVariable Long id) {
		return null;
	}

	@PostMapping
	public ResponseEntity gravarDisciplina(@RequestBody Disciplina disciplina) {
		try {
			return ResponseEntity.ok(disciplinaService.gravarDisciplina(disciplina));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity alterarDisciplina(@PathVariable Long id, @RequestBody Disciplina disciplina) {
		try {
			Disciplina d = disciplinaService.alterarPorId(id, disciplina);
			return ResponseEntity.ok().body(d);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity deletarDisciplina(@PathVariable Long id) {
		try {
			Disciplina d = disciplinaService.excluirPorId(id);
			
			if (d == null)
				return ResponseEntity.notFound().build();
			else
				return ResponseEntity.ok(d);			
			
		} catch (Exception e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
		
	}

}
