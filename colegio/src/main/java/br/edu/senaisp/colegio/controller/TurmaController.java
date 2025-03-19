package br.edu.senaisp.colegio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.colegio.model.Turma;
import br.edu.senaisp.colegio.service.TurmaService;

@RestController
@RequestMapping("/api/turma")
public class TurmaController {
	
	@Autowired
	private TurmaService turmaService;
	
	//para devolver respostas de requisição
	@PostMapping
	public ResponseEntity inserir(@RequestBody Turma turma) {
		try {
			Turma t = turmaService.gravarTurma(turma);
			return ResponseEntity.ok(t);
			
	}catch(Exception e){
		return ResponseEntity.badRequest().body(e.getMessage());		
		}
}
}
