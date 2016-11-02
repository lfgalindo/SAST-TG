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
 * Classe definida para mapear a entidade "tb_funcionario" e seus atributos.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 30/08/2016
 */

@Entity
@Table(name = "tb_funcionario")
public class Funcionario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	@Column(length = 45, nullable = false)
	private String nome; 
	
	@Column(length = 45, nullable = false)
	private String endereco;
	
	@Column(length = 45, nullable = false)
	private String bairro;
	
	@Column(length = 5, nullable = false)
	private String numero;
	
	@Column(length = 45 , nullable = true)
	private String complemento;
	
	@Column(length = 25, nullable = false)
	private String cidade;
	
	@Column(length = 2, nullable = false)
	private String estado;
	
	@Column(length = 13, nullable = false)
	private String telefone;
	
	@Column(length = 14, nullable = false, unique = true)
	private String cpf; 
	
	@Column(length = 20, nullable = false, unique = true)
	private String rg;
	
	@Column(length = 20, nullable = false)
	private String estadoCivil;
	
	@Column(length = 30, nullable = false)
	private String email;
	
	@Temporal(TemporalType.DATE)
	private Date nascimento;	
	
	@Column(length = 20, nullable = false)
	private String login;
	
	@Column(length = 32, nullable = false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Perfil codigoPerfil;
	
	@ManyToOne
	@JoinColumn(nullable = false, unique = false)
	private Cargo codigoCargo;
	
	@Temporal(TemporalType.DATE)
	private Date dataAdmissao;
	
	@Temporal(TemporalType.DATE)
	private Date dataDemissao;
	
	@Column(length = 45, nullable = false)
	private String formacao;
	
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
	
	public Perfil getCodigoPerfil() {
		return codigoPerfil;
	}
	public void setCodigoPerfil(Perfil codigoPerfil) {
		this.codigoPerfil = codigoPerfil;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Cargo getCodigoCargo() {
		return codigoCargo;
	}
	public void setCodigoCargo(Cargo codigoCargo) {
		this.codigoCargo = codigoCargo;
	}
	public Date getDataAdmissao() {
		return dataAdmissao;
	}
	public void setDataAdmissao(Date dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}
	public Date getDataDemissao() {
		return dataDemissao;
	}
	public void setDataDemissao(Date dataDemissao) {
		this.dataDemissao = dataDemissao;
	}
	public String getFormacao() {
		return formacao;
	}
	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}
	public String toString(){
		return "O funcionário " + codigo + " é o resultado";
	}
	
}
