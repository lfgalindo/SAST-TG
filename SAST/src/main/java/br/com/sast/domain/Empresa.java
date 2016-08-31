package br.com.sast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Requisito Funional 03 (Configurações Gerais)
 * Classe definida para mapear a entidade "tb_empresa" e seus atributos.
 * 
 * @author Luis Claudio Gonçalves Sanches <luis.cgs@hotmail.com>
 * @since 29/08/2016
 */

@Entity
@Table(name = "tb_empresa")
public class Empresa {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigoEmpresa;
	
	@Column(name = "nomeEmpresa", length = 255, nullable = false)
	private String nomeEmpresa;
	
	@Column(name = "razaoSocial", length = 255, nullable = false)
	private String razaoSocial;
	
	@Column(name = "cnpj", nullable = false)
	private String cnpj;
	
	@Column(name = "endereco", nullable = false)
	private String endereco;
	
	@Column(name = "telefone", nullable = false)
	private String telefone;
	
	@Column(name = "cobrarJuros",nullable = false)
	private Double cobrarJuros;
	
	@Column(name = "percentualJuros",nullable = false)
	private Double percentualJuros;
	
	@Column(name = "multa",nullable = false)
	private Double multa;
}
