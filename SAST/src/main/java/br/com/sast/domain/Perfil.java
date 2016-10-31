package br.com.sast.domain;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe definida para mapear a entidade "tb_perfil" e seus atributos.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */

@Entity
@Table(name = "tb_perfil")
public class Perfil {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer codigo;
	
	@Column(length = 45, nullable = false)
	private String nomePerfil;
	
	@Column(nullable = false)
	private Integer gerenciarClientes;
	
	@Column(nullable = false)
	private Integer gerenciarFuncionarios;
	
	@Column(nullable = false)
	private Integer gerenciarCargos;
	
	@Column(nullable = false)
	private Integer gerenciarPlanos;
	
	@Column(nullable = false)
	private Integer gerenciarManutencoes;
	
	@Column(nullable = false)
	private Integer gerenciarConfiguracoes;
	
	/** Setters e Getters **/
	
	public void setCodigo(Integer codigo){
		this.codigo = codigo;
	}
	public Integer getCodigo(){
		return codigo;
	}
	
	public void setNomePerfil(String nomePerfil){
		this.nomePerfil = nomePerfil;
	}
	public String getNomePerfil(){
		return nomePerfil;
	}
	
	
	public void setGerenciarCargos(Integer gerenciarCargos){
		this.gerenciarCargos = gerenciarCargos;
	}
	public Integer getGerenciarCargos(){
		return gerenciarCargos;
	}
	
	public void setGerenciarPlanos(Integer gerenciarPlanos){
		this.gerenciarPlanos = gerenciarPlanos;
	}
	public Integer getGerenciarPlanos(){
		return gerenciarPlanos;
	}
	
	public void setGerenciarManutencoes(Integer gerenciarManutencoes){
		this.gerenciarManutencoes = gerenciarManutencoes;
	}
	public Integer getGerenciarManutencoes(){
		return gerenciarManutencoes;
	}
	
	public void setGerenciarConfiguracoes(Integer gerenciarConfiguracoes){
		this.gerenciarConfiguracoes = gerenciarConfiguracoes;
	}
	public Integer getGerenciarConficuracoes(){
		return gerenciarConfiguracoes;
	}
	
    public Integer getGerenciarClientes() {
		return gerenciarClientes;
	}
	public void setGerenciarClientes(Integer gerenciarClientes) {
		this.gerenciarClientes = gerenciarClientes;
	}
	public Integer getGerenciarFuncionarios() {
		return gerenciarFuncionarios;
	}
	public void setGerenciarFuncionarios(Integer gerenciarFuncionarios) {
		this.gerenciarFuncionarios = gerenciarFuncionarios;
	}
	public Integer getGerenciarConfiguracoes() {
		return gerenciarConfiguracoes;
	}
	public String toString(){
		return "Perfil " + codigo + ": { " + nomePerfil + " }";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + Objects.hashCode(this.gerenciarClientes);
        hash = 83 * hash + Objects.hashCode(this.gerenciarFuncionarios);
        hash = 83 * hash + Objects.hashCode(this.gerenciarCargos);
        hash = 83 * hash + Objects.hashCode(this.gerenciarPlanos);
        hash = 83 * hash + Objects.hashCode(this.gerenciarManutencoes);
        hash = 83 * hash + Objects.hashCode(this.gerenciarConfiguracoes);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Perfil other = (Perfil) obj;
        if (!Objects.equals(this.gerenciarClientes, other.gerenciarClientes)) {
            return false;
        }
        if (!Objects.equals(this.gerenciarFuncionarios, other.gerenciarFuncionarios)) {
            return false;
        }
        if (!Objects.equals(this.gerenciarCargos, other.gerenciarCargos)) {
            return false;
        }
        if (!Objects.equals(this.gerenciarPlanos, other.gerenciarPlanos)) {
            return false;
        }
        if (!Objects.equals(this.gerenciarManutencoes, other.gerenciarManutencoes)) {
            return false;
        }
        if (!Objects.equals(this.gerenciarConfiguracoes, other.gerenciarConfiguracoes)) {
            return false;
        }
        return true;
    }
        
        
    
}
