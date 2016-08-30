package br.com.sast.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/*
 * Classe responsável por modelar a tabela PlanoPessoa
 * @author Luís Guilherme Fernandes Ferreira
 * @since Classe criada em 30/08/2016
 */

@Entity
public class PlanoPessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Pessoa codigoPessoa;
	
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
	
	
	
}
