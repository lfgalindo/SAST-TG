package br.com.sast.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe definida para mapear a entidade "tb_manutencao" e seus atributos.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 30/08/2016
 */

@Entity
@Table(name = "tb_manutencao")
public class Manutencao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column(length = 255, nullable = false)
	private String descricao;
	
	@Column(length = 255, nullable = false)
	private String descProblema;
	
	@Column(length = 255, nullable = true)
	private String observacoes;
	
	@Column(length = 15, nullable = false)
	private String prioridade;
	
	@Temporal(TemporalType.DATE)
	private Date dtAgendamento;
	
	@Temporal(TemporalType.DATE)
	private Date dtExecucao;
	
	@Column(nullable = false)
	private int baixa;
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Pessoa codigoCliente;
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Pessoa codigoFuncionario;
	
	//GETS & SETS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescProblema() {
		return descProblema;
	}

	public void setDescProblema(String descProblema) {
		this.descProblema = descProblema;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Date getDtAgendamento() {
		return dtAgendamento;
	}

	public void setDtAgendamento(Date dtAgendamento) {
		this.dtAgendamento = dtAgendamento;
	}

	public Date getDtExecucao() {
		return dtExecucao;
	}

	public void setDtExecucao(Date dtExecucao) {
		this.dtExecucao = dtExecucao;
	}

	public int getBaixa() {
		return baixa;
	}

	public void setBaixa(int baixa) {
		this.baixa = baixa;
	}

	public Pessoa getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(Pessoa codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public Pessoa getCodigoFuncionario() {
		return codigoFuncionario;
	}

	public void setCodigoFuncionario(Pessoa codigoFuncionario) {
		this.codigoFuncionario = codigoFuncionario;
	}

}
