package br.com.jlib.util;

import java.util.List;

import org.junit.Test;

import br.com.jlib.dao.BairroDAO;
import br.com.jlib.domain.Bairro;
import br.com.jlib.domain.Cidade;

public class EstadoDAOTest {
	
	@Test
	public static void listar(){
		Cidade cidade = new Cidade();
		cidade.setCodigo(2);
		cidade.setNome("Eusebio");
		BairroDAO bairroDAO = new BairroDAO();
		List<Bairro> resultado = bairroDAO.listaBairro(cidade);
		for(Bairro bairro:resultado)
			System.out.println(bairro.getNome());
	}
	
	public static void main(String[] args) {
		listar();
	}
	}
