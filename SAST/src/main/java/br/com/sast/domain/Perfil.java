package br.com.sast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe definida para mapear a entidade "tb_perfil" e seus atributos.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */

@Entity
@Table(name = "tb_perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@Column(length = 45, nullable = false)
	private String nomePerfil;
	
	@Column(nullable = false)
	private Integer gerenciarPessoas;
	
	@Column(nullable = false)
	private Integer gerenciarFaturas;
	
	@Column(nullable = false)
	private Integer gerenciarCargos;
	
	@Column(nullable = false)
	private Integer gerenciarPlanos;
	
	@Column(nullable = false)
	private Integer gerenciarCaixas;
	
	@Column(nullable = false)
	private Integer gerenciarMovimentacoes;
	
	@Column(nullable = false)
	private Integer gerenciarManutencoes;
	
	@Column(nullable = false)
	private Integer gerenciarConfiguracoes;
	
	/** Setters e Getters **/
	
	public void setCodigo(Integer codigo){
		this.codigo = codigo;
	}
	public Integer getCodigo(){
		return codigo;
	}
	
	public void setNomePerfil(String nomePerfil){
		this.nomePerfil = nomePerfil;
	}
	public String getNomePerfil(){
		return nomePerfil;
	}
	
	public void setGerenciarPessoas(Integer gerenciarPessoas){
		this.gerenciarPessoas = gerenciarPessoas;
	}
	public Integer getGerenciarPessoas(){
		return gerenciarPessoas;
	}
	
	public void setGerenciarFaturas(Integer gerenciarFaturas){
		this.gerenciarFaturas = gerenciarFaturas;
	}
	public Integer getGerenciarFaturas(){
		return gerenciarFaturas;
	}
	
	public void setGerenciarCargos(Integer gerenciarCargos){
		this.gerenciarCargos = gerenciarCargos;
	}
	public Integer getGerenciarCargos(){
		return gerenciarCargos;
	}
	
	public void setGerenciarPlanos(Integer gerenciarPlanos){
		this.gerenciarPlanos = gerenciarPlanos;
	}
	public Integer getGerenciarPlanos(){
		return gerenciarPlanos;
	}
	
	public void setGerenciarCaixas(Integer gerenciarCaixas){
		this.gerenciarCaixas = gerenciarCaixas;
	}
	public Integer getGerenciarCaixas(){
		return gerenciarCaixas;
	}
	
	public void setGerenciarMovimentacoes(Integer gerenciarMovimentacoes){
		this.gerenciarMovimentacoes = gerenciarMovimentacoes;
	}
	public Integer getGerenciarMovimentacoes(){
		return gerenciarMovimentacoes;
	}
	
	public void setGerenciarManutencoes(Integer gerenciarManutencoes){
		this.gerenciarManutencoes = gerenciarManutencoes;
	}
	public Integer getGerenciarManutencoes(){
		return gerenciarManutencoes;
	}
	
	public void setGerenciarConfiguracoes(Integer gerenciarConfiguracoes){
		this.gerenciarConfiguracoes = gerenciarConfiguracoes;
	}
	public Integer getGerenciarConficuracoes(){
		return gerenciarConfiguracoes;
	}
	
}
