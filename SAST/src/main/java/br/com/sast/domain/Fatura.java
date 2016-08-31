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
import javax.persistence.Table;

/**
 * Classe definida para mapear a entidade "tb_fatura" e seus atributos.
 * 
 * @author Luis Claudio Gonçalves Sanches <luis.cgs@hotmail.com>
 * @since 29/08/2016
 */

@Entity
@Table(name = "tb_fatura")
public class Fatura {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigoFatura;
	
	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "codigoPessoa" )
	private Pessoa pessoa;
	
	@Column(name = "codigoBarra", length = 255, nullable = false)
	private String codigoBarra;
	
	@Column(name = "observacao", length = 255, nullable = false)
	private String observacao;
	
	@Column(name = "valor",nullable = false)
	private Double valor;
	
	@Column(name = "juros",nullable = false)
	private Double juros;
	
	@Column(name = "desconto",nullable = false)
	private Double desconto;
	
	@Column(name = "dataExpedicao", length = 10,nullable = false)
	private Date dataExpedicao;
	
	@Column(name = "dataVencimento", length = 10,nullable = false)
	private Date dataVencimento;
	
	@Column(name = "situacao",nullable = false)
	private Boolean situacao;
}
