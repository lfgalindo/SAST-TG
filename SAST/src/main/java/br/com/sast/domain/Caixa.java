package br.com.sast.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe definida para mapear a entidade "tb_caixa" e seus atributos.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */
@Entity
public class Caixa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@Temporal(TemporalType.DATE)
	private Date dtCriacao;
	
	@Column(nullable = false)
	private Integer removido;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	/** Setters e Getters **/
	
	public void setCodigo(Integer codigo){
		this.codigo = codigo;
	}
	public Integer getCodigo(){
		return codigo;
	}
	
	public void setDtCriacao(Date dtCriacao){
		this.dtCriacao = dtCriacao;
	}
	public Date getDtCriacao(){
		return dtCriacao;
	}
	
	public void setRemovido(Integer removido){
		this.removido = removido;
	}
	public Integer dtRemovido(){
		return removido;
	}
	
	public void setPessoa(Pessoa pessoa){
		this.pessoa = pessoa;
	}
	public Pessoa getPessoa(){
		return pessoa;
	}
	
}
