package br.com.jlib.bean;

import java.util.List;
import javax.annotation.PostConstruct;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

import org.omnifaces.util.Messages;
import org.primefaces.context.RequestContext;

import br.com.jlib.dao.BairroDAO;
import br.com.jlib.dao.CidadeDAO;
import br.com.jlib.dao.EmpresaDAO;
import br.com.jlib.dao.TipoDAO;
import br.com.jlib.dao.UsuarioDAO;
import br.com.jlib.domain.Bairro;
import br.com.jlib.domain.Cidade;
import br.com.jlib.domain.Empresa;
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
	private Empresa empresa;

	public void novo() {
		cidade = new Cidade();
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
		try {
			listarCidades();
			listarTipo();
			iniciaUsuario();
			iniciaEmpresa();
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar listar as cidades entre em contado com suporte.");
			erro.printStackTrace();
		}
	}

	public void listarCidades() {
		try {
			CidadeDAO cidadeDAO = new CidadeDAO();
			cidades = cidadeDAO.listar();

		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar listar as cidades entre em contado com suporte.");
			erro.printStackTrace();
		}
	}

	public void listarTipo() {
		try {
			TipoDAO tipoDAO = new TipoDAO();
			tipos = tipoDAO.listar();
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar listar as cidades entre em contado com suporte.");
			erro.printStackTrace();
		}
	}

	public void listarBairro(AjaxBehaviorEvent event) {
		try {
			setBairroOcultar(false);
			BairroDAO bairroDAO = new BairroDAO();
			bairros = bairroDAO.listaBairro(cidade);
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar listar os bairros entre em contado com suporte.");
			erro.printStackTrace();
		}
	}

	public void novoUsuario() {
		try {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			if (usuario.getNome() != null && !usuario.getNome().equals("")) {
				if (usuario.getEmail() != null && !usuario.getEmail().equals("")) {
					if (usuario.getUsuario() != null && !usuario.getUsuario().equals("")) {
						if (usuario.getSenha() != null && !usuario.getSenha().equals("")) {
							iniciaEmpresa();
							usuarioDAO.salvar(usuario);
							novo();
							Messages.addGlobalInfo("Usuário cadastrado com sucesso!");
						} else {
							Messages.addGlobalWarn("Campo senha é obrigatorio!");
						}
					} else {
						Messages.addGlobalWarn("Campo usuario é obrigatorio!");
					}
				} else {
					Messages.addGlobalWarn("Campo email é obrigatorio!");
				}
			} else {
				Messages.addGlobalWarn("Campo nome completo é obrigatorio!");
			}
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
			if (empresa.getNome() != null && !empresa.getNome().equals("")) {
				if (empresa.getCnpj() != null && !empresa.getCnpj().equals("")) {
					if (empresa.getEndereco() != null && !empresa.getEndereco().equals("")) {
						if (empresa.getUsuario() != null && !empresa.getUsuario().equals("")) {
							if (empresa.getSenha() != null && !empresa.getSenha().equals("")) {
								iniciaUsuario();
								empresaDAO.salvar(empresa);
								novo();
								Messages.addGlobalInfo("Empresa cadastrada com sucesso!");
							} else {
								Messages.addGlobalWarn("Campo senha é obrigatorio!");
							}
						} else {
							Messages.addGlobalWarn("Campo usuario é obrigatorio!");
						}
					} else {
						Messages.addGlobalWarn("Campo endereço é obrigatorio!");
					}
				} else {
					Messages.addGlobalWarn("Campo cnpj é obrigatorio!");
				}
			} else {
				Messages.addGlobalWarn("Campo nome é obrigatorio!");
			}
			
			RequestContext context = RequestContext.getCurrentInstance();
			context.execute("PF('dilogoCadastrar').show();");
		} catch (Exception erro) {
			Messages.addGlobalInfo("Erro ao tentar gravar empresa entre em contado com suporte.");
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

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

}
