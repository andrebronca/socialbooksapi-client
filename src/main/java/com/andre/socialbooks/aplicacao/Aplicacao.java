package com.andre.socialbooks.aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import com.andre.socialbooks.client.LivrosClient;
import com.andre.socialbooks.client.domain.Livro;

public class Aplicacao {
	
	public static void main(String[] args) {
		salvarLivro();
		listarLivros();
		
		
		
	}
	
	private static void salvarLivro() {
		LivrosClient livroCliente = new LivrosClient();
		Livro livro = new Livro();
		livro.setNome("Easy code simplicity");
		livro.setEditora("kbook");
		SimpleDateFormat publicacao = new SimpleDateFormat("dd/MM/yyyy");
		try {
			livro.setPublicacao(publicacao.parse("01/01/2018"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		livro.setResumo("Aborda boas práticas de codificação");
		
		String localizacao = livroCliente.salvar(livro);
		System.out.println("URI do livro salvo: "+ localizacao);
	}
	
	private static void listarLivros() {
		LivrosClient livrosClient = new LivrosClient();
		List<Livro> listaLivros = livrosClient.listar();
		
		for (Livro livro : listaLivros) {
			System.out.println("Livro: "+ livro.getNome());
		}
	}
}
