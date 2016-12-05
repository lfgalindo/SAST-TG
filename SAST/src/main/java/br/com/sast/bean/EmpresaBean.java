package br.com.sast.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.sast.dao.EmpresaDAO;
import br.com.sast.domain.Empresa;

@ManagedBean
@ViewScoped
public class EmpresaBean {
	
	private Empresa empresa;
	private List<Empresa> empresas;
	private Integer codigo;
	
	public void novo(){
		empresa = new Empresa();
	}
	
	public void salvar(){
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.inserir(empresa);
		Messages.addGlobalInfo("Empresa inserida com sucesso!");
	}
	
	public void listar(){
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresas = empresaDAO.listar();
	}
	
	public void buscar(){
		EmpresaDAO empresaDAO = new EmpresaDAO();
		//empresa = empresaDAO.buscar(codigo);
                empresa = empresaDAO.buscar();
	}
	
	public void editar(){
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.editar(empresa);
		Messages.addGlobalInfo("Empresa editada com sucesso!");
		
	}
	
	public void excluir(){
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.excluir(empresa);
		Messages.addGlobalInfo("Empresa excluída com sucesso!");
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public List<Empresa> getEmpresas() {
		return empresas;
	}
	public void setEmpresas(List<Empresa> empresas) {
		this.empresas = empresas;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
