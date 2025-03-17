package br.edu.senaisp.loja.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;

import br.edu.senaisp.loja.model.Produto;

@Service
public class ProdutoService {

	public void gravarProdutoTexto(Produto a) throws Exception{
		
		String nomeArq = "produto"+a.getId()+".txt";
		String caminhoArq = "c:\\Temp\\produtos\\";
		
		try {
			FileWriter arq = new FileWriter(caminhoArq +nomeArq);
			
			PrintWriter pw = new PrintWriter(arq);
			pw.print(a.getId()+";");
			pw.print(a.getNome()+";");
			pw.print(a.getPreco()+";");
			
			pw.close();
		}catch (IOException e) {
			throw new Exception("Erro ao tentar gravar no arquivo!");
			
		}
		
		
		
	}

}
