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
	
	@Column(name = "cnpj", nullable = false, unique = true)
	private String cnpj;
	
	@Column(name = "endereco", nullable = false)
	private String endereco;
	
	@Column(length = 45, nullable = false)
	private String bairro;
	
	@Column(length = 5, nullable = false)
	private String numero;
	
	@Column(length = 25, nullable = false)
	private String cidade;
	
	@Column(length = 2, nullable = false)
	private String estado;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(name = "telefone", nullable = false)
	private String telefone;
	
	public Integer getCodigoEmpresa() {
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(Integer codigoEmpresa) {
		this.codigoEmpresa = codigoEmpresa;
	}
	public String getNomeEmpresa() {
		return nomeEmpresa;
	}

	public void setNomeEmpresa(String nomeEmpresa) {
		this.nomeEmpresa = nomeEmpresa;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	@Override
	public String toString() {
		return "Empresa [codigoEmpresa= " + codigoEmpresa + ", nomeEmpresa=" + nomeEmpresa + ", razaoSocial="
				+ razaoSocial + ", cnpj=" + cnpj + ", endereco=" + endereco + ", bairro=" + bairro + ", numero="
				+ numero + ", cidade=" + cidade + ", estado=" + estado + ", email=" + email + ", telefone=" + telefone
				+ "]";
	}
	
	
	
}
