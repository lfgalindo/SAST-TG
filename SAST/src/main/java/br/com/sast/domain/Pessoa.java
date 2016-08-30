package br.com.sast.domain;

import java.util.Date;

import javax.persistence.Entity;

/*
 * Classe responsável por modelar a tabela Pessoa
 * @author Luís Guilherme Fernandes Ferreira
 * @since Classe criada em 30/08/2016
 */

@Entity
public class Pessoa {

	private int codigo;
	private String nome; 
	private String endereco;
	private String telefone;
	private String cpf; 
	private String email;
	private String login;
	private Date nascimento;
	
	
	
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
	
}
