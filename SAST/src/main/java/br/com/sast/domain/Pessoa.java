package br.com.sast.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Classe responsável por modelar a tabela Pessoa
 * @author Luís Guilherme Fernandes Ferreira
 * @since Classe criada em 30/08/2016
 */

@Entity
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column(length = 45, nullable = false)
	private String nome; 
	
	@Column(length = 45, nullable = false)
	private String endereco;
	
	@Column(length = 13, nullable = false)
	private String telefone;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cpf; 
	
	@Column(length = 30, nullable = false)
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;	
	
	@Column(length = 20, nullable = false)
	private String login;
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Cargo codigoCargo;
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public Date getNascimento() {
		return nascimento;
	}
	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}
	public Cargo getCodigoCargo() {
		return codigoCargo;
	}
	public void setCodigoCargo(Cargo codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	
	
}
