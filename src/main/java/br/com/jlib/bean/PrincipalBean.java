package br.com.jlib.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.jlib.dao.CidadeDAO;
import br.com.jlib.dao.TipoDAO;
import br.com.jlib.domain.Cidade;
import br.com.jlib.domain.Tipo;

@SuppressWarnings("serial")
@ManagedBean(name = "principalBean")
@ViewScoped
public class PrincipalBean implements Serializable {

	private List<Cidade> cidades;
	private List<Tipo> tipos;
	private Cidade cidade;
	private Tipo tipo;

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
	
	public List<Tipo> getTipos() {
		return tipos;
	}

	public void setTipos(List<Tipo> tipos) {
		this.tipos = tipos;
	}
	
	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public void novo(){
		cidade = new Cidade();
	}

	@PostConstruct
	public void init() {
		try {
			listarCidades();
			listarTipo();
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar listar as cidades entre em contado com suporte.");
			erro.printStackTrace();
		}
	}
	
	
	
	
	public void listarCidades(){
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();
			
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar listar as cidades entre em contado com suporte.");
			erro.printStackTrace();
		}
	}
	
	public void listarTipo(){
		try {
			TipoDAO tipoDAO = new TipoDAO();
			tipos = tipoDAO.listar();
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar listar as cidades entre em contado com suporte.");
			erro.printStackTrace();
		}
	}

}
