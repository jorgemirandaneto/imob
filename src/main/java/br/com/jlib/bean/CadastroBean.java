package br.com.jlib.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import br.com.jlib.dao.EmpresaDAO;
import br.com.jlib.dao.UsuarioDAO;
import br.com.jlib.domain.Empresa;
import br.com.jlib.domain.Usuario;

@SuppressWarnings("serial")
@ManagedBean(name = "cadastroBean")
@ViewScoped
public class CadastroBean implements Serializable {
	private Usuario usuario;
	private Empresa empresa;
	private boolean botaoPessoaFisica = false;
	private boolean botaoPessoaJuridica = true;

	public void novo() {
		iniciaUsuario();
		iniciaEmpresa();
	}

	public void iniciaEmpresa() {
		empresa = new Empresa();
	}

	public void iniciaUsuario() {
		usuario = new Usuario();
	}

	@PostConstruct
	public void init() {
		iniciaUsuario();
		iniciaEmpresa();

	}
	
	public void painelPesEmpresa(){
		iniciaEmpresa();
		botaoPessoaJuridica = true;
		botaoPessoaFisica = false;
	}
	
	public void painelPesFisica(){
		iniciaUsuario();
		botaoPessoaFisica = true;
		botaoPessoaJuridica = false;
	}
	
	public void novoUsuario() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			iniciaEmpresa();
			usuarioDAO.salvar(usuario);
			novo();
			Messages.addGlobalInfo("Usuário cadastrado com sucesso!");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dilogoCadastrar').show();");
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar gravar usuário entre em contado com suporte.");
			erro.printStackTrace();
		}
	}

	public void novaEmpresa() {
		try {
			EmpresaDAO empresaDAO = new EmpresaDAO();
			iniciaUsuario();
			empresaDAO.salvar(empresa);
			novo();
			Messages.addGlobalInfo("Empresa cadastrada com sucesso!");
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dilogoCadastrar').show();");
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar gravar empresa entre em contado com suporte.");
			erro.printStackTrace();
		}
	}
	
	public void cadastro(){
		if(botaoPessoaFisica == true){
			novoUsuario();
			return;
		}
		if (botaoPessoaJuridica == true) {
			novaEmpresa();
			return;
		}
	}

	// getter e setter
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public boolean isBotaoPessoaFisica() {
		return botaoPessoaFisica;
	}

	public void setBotaoPessoaFisica(boolean botaoPessoaFisica) {
		this.botaoPessoaFisica = botaoPessoaFisica;
	}

	public boolean isBotaoPessoaJuridica() {
		return botaoPessoaJuridica;
	}

	public void setBotaoPessoaJuridica(boolean botaoPessoaJuridica) {
		this.botaoPessoaJuridica = botaoPessoaJuridica;
	}
	
	

}
