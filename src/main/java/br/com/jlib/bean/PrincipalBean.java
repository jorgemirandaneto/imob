package br.com.jlib.bean;


import java.util.List;
import javax.annotation.PostConstruct;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.omnifaces.util.Messages;

import br.com.jlib.dao.BairroDAO;
import br.com.jlib.dao.CidadeDAO;
import br.com.jlib.dao.TipoDAO;
import br.com.jlib.dao.UsuarioDAO;
import br.com.jlib.domain.Bairro;
import br.com.jlib.domain.Cidade;
import br.com.jlib.domain.Tipo;
import br.com.jlib.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean(name = "principalBean")
@ViewScoped
public class PrincipalBean implements Serializable {

	private List<Cidade> cidades;
	private List<Tipo> tipos;
	private Cidade cidade;
	private Tipo tipo;
	private List<Bairro> bairros;
	private Bairro bairro;
	private boolean bairroOcultar;
	private Usuario usuario;

	

	public void novo(){
		cidade = new Cidade();
		usuario = new Usuario();
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
	
	public void listarBairro(AjaxBehaviorEvent event){
		try {
			setBairroOcultar(false);
			BairroDAO bairroDAO = new BairroDAO();
			bairros = bairroDAO.listaBairro(cidade);
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar listar os bairros entre em contado com suporte.");
			erro.printStackTrace();
		}
	}
	
	public void novoUsuario(){
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			usuarioDAO.salvar(usuario);
			
			novo();
			
			Messages.addGlobalInfo("Usuário cadastrado com sucesso!");
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar gravar usuário entre em contado com suporte.");
			erro.printStackTrace();
		}
	}
	
// Get e set	
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

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}
	
	public boolean isBairroOcultar() {
		return bairroOcultar;
	}

	public void setBairroOcultar(boolean bairroOcultar) {
		this.bairroOcultar = bairroOcultar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	

}
