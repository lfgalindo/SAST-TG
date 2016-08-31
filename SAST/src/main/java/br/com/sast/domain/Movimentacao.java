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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
	


/**
 * Classe definida para mapear a entidade "tb_movimentacao" e seus atributos.
 * 
 * @author Luis Claudio Gonçalves Sanches <luis.cgs@hotmail.com>
 * @since 29/08/2016
 */

@Entity
@Table (name="tb_movimentacao")
public class Movimentacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigoMovimentacao;
	
	@ManyToOne( fetch = FetchType.EAGER )
	@JoinColumn( name = "codigoCaixa" )
	private Caixa caixa;
	
	@Column(name = "descricao", length = 255, nullable = false)
	private String descricao;
	
	@Column(name = "data", length = 10,nullable = false)
	private Date data;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "abertura",nullable = true)
	private Date abertura;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fechamento",nullable = true)
	private Date fechamento;
	
	@Column(name = "valor",nullable = false)
	private Double valor;
	
	@Column(name = "formaPagamento", nullable = false)
	private String formaPagamento;
	
}
