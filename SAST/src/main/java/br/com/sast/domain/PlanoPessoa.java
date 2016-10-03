package br.com.sast.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Classe definida para mapear a entidade "tb_planopessoa" e seus atributos.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 30/08/2016
 */

@Entity
@Table(name = "tb_planopessoa")
public class PlanoPessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Pessoa codigoPessoa;
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Plano codigoPlano;
	
	//GETS & SETS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Pessoa getCodigoPessoa() {
		return codigoPessoa;
	}

	public void setCodigoPessoa(Pessoa codigoPessoa) {
		this.codigoPessoa = codigoPessoa;
	}

	public Plano getCodigoPlano() {
		return codigoPlano;
	}

	public void setCodigoPlano(Plano codigoPlano) {
		this.codigoPlano = codigoPlano;
	}
	
	
	
}
