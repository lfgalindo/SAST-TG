package br.com.sast.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GenerationType;
import javax.persistence.Column;

/**
 * Classe definida para mapear a entidade "tb_plano" e seus atributos.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */
@Entity
@Table(name = "tb_plano")
public class Plano {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@Column(length = 45, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Integer velocidade;
	
	@Column(nullable = false)
	private Integer garantia;
	
	@Column(length = 45, nullable = false)
	private String tipoConexao;
	
	@Column(nullable = false)
	private Double valor;
	
	/** Setters e Getters **/
	
	public void setCodigo(Integer codigo){
		this.codigo = codigo;
	}
	public Integer getCodigo(){
		return codigo;
	}
	
	public void seDescricao(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao(){
		return descricao;
	}
	
	public void setVelocidade(Integer velocidade){
		this.velocidade = velocidade;
	}
	public Integer getVelocidade(){
		return velocidade;
	}
	
	public void setGarantia(Integer garantia){
		this.garantia = garantia;
	}
	public Integer getGarantia(){
		return garantia;
	}
	
	public void setTipoConexao(String tipoConexao){
		this.tipoConexao = tipoConexao;
	}
	public String getTipoConexao(){
		return tipoConexao;
	}
	
	public void setValor(Double valor){
		this.valor = valor;
	}
	public Double getValor(){
		return valor;
	}
	
	public String toString(){
		return "Plano código: " + getCodigo() + ", tipo " + getTipoConexao();
	}
	
}
