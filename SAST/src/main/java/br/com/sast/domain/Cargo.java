package br.com.sast.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * Classe responsável por modelar a tabela Cargo
 * @author Luís Guilherme Fernandes Ferreira
 * @since Classe criada em 30/08/2016
 */

@Entity
public class Cargo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column(length = 45, nullable = false)
	private String nome;
	
	@Column(length = 45, nullable = false)
	private String descricao;
	
	//GETS & SETS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
