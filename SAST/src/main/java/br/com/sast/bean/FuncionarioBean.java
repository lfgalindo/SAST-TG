package br.com.sast.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sast.domain.Cargo;
import br.com.sast.domain.Funcionario;
import br.com.sast.domain.Perfil;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class FuncionarioBean implements Serializable{

	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	private Integer codigo;
	
	// Chaves estrangeiras
	private List<Perfil> perfis;
	private List<Cargo> cargos;
	
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public List<Perfil> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
}
