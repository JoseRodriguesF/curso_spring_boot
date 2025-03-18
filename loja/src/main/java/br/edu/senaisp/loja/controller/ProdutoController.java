
package br.edu.senaisp.loja.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.loja.model.Produto;
import br.edu.senaisp.loja.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity insereProduto(@Valid @RequestBody Produto a, BindingResult blindingResult) {
	if(blindingResult.hasErrors()) 
		{return ResponseEntity.badRequest().body(blindingResult.getAllErrors());
		}
		try {
			produtoService.gravarProdutoTexto(a);
			return new ResponseEntity<Produto>(a, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}	
	}
}



