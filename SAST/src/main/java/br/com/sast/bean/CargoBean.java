package br.com.sast.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.dao.CargoDAO;
import br.com.sast.domain.Cargo;
import br.com.sast.domain.Cargo;

@ManagedBean
@ViewScoped
public class CargoBean {

	private Cargo cargo;
	private List<Cargo> cargos;
	private Integer codigo;
	
	public void novo(){
		cargo = new Cargo();
	}
	
	public void salvar(){
		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.inserir(cargo);
		Messages.addGlobalInfo("Cargo inserida com sucesso!");
	}
	
	public void listar(){
		CargoDAO cargoDAO = new CargoDAO();
		cargos = cargoDAO.listar();
	}
	
	public void buscar(){
		CargoDAO cargoDAO = new CargoDAO();
		cargo = cargoDAO.consultar(codigo);
	}
	
	public void editar(){
		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.editar(cargo);
		Messages.addGlobalInfo("Cargo editada com sucesso!");
		
	}
	
	public void excluir(){
		CargoDAO cargoDAO = new CargoDAO();
		cargoDAO.excluir(cargo);
		Messages.addGlobalInfo("Cargo excluída com sucesso!");
	}
	
	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public List<Cargo> getCargos() {
		return cargos;
	}
	public void setCargos(List<Cargo> cargos) {
		this.cargos = cargos;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
