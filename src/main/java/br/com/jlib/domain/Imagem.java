package br.com.jlib.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@SuppressWarnings("serial")
@Entity
public class Imagem extends GenericDomain{
	@Column
	private String descricao;
	@Column
	private String nome;
	@Column
	private Byte imagem[];

	
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Byte[] getImagem() {
		return imagem;
	}
	public void setImagem(Byte[] imagem) {
		this.imagem = imagem;
	}




}
