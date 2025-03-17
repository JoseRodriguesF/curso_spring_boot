
package br.edu.senaisp.loja.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.loja.model.Produto;
import br.edu.senaisp.loja.service.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity<Produto> insereProduto(@RequestBody Produto a) {
		try {
			produtoService.gravarProdutoTexto(a);
			return new ResponseEntity<Produto>(a, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Produto>(HttpStatus.BAD_REQUEST);
		}
}

}
