package br.com.jlib.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.jlib.dao.CidadeDAO;
import br.com.jlib.domain.Cidade;

@SuppressWarnings("serial")
@ManagedBean(name = "principalBean")
@ViewScoped
public class PrincipalBean implements Serializable {

	private List<String> images;
	private List<Cidade> cidades;
	private Cidade cidade;

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	public void novo(){
		cidade = new Cidade();
	}

	@PostConstruct
	public void init() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			telaMovel();
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar listar as cidades entre em contado com suporte.");
			erro.printStackTrace();
		}
	}
	
	
	//metodo para passar as imagens
	public void telaMovel(){
		images = new ArrayList<String>();
		for (int i = 1; i <= 2; i++) {
			images.add("imagem" + i + ".jpg");
		}
	}

}
