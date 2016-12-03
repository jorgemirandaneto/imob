package br.com.jlib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Example;

import br.com.jlib.domain.Bairro;
import br.com.jlib.domain.Cidade;
import br.com.jlib.util.HibernateUtil;

public class BairroDAO extends GenericDAO<Bairro> {

	@SuppressWarnings("unchecked")
	public List<Bairro> listaBairro(Cidade cidade) {
		Session sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		List<Bairro> resultado;
		Bairro bairro = new Bairro();
		try {
			bairro.setCidade(cidade);
			Example exampleBairro = Example.create(bairro);
			Example exampleCidade = Example.create(bairro.getCidade());
			resultado = sessao.createCriteria(Bairro.class).add(exampleBairro).createCriteria("cidade")
					.add(exampleCidade).list();

		} catch (Exception erro) {
			throw erro;
		} finally {
			sessao.close();
		}
		return resultado;
	}

}
