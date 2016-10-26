package br.com.sast.bean;

/**
 * Classe definida para controlar a comunição entre a classe ClienteDAO e sua Interface Web
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since Classe criada em 25/10/2016
 */

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.PerfilDAO;
import br.com.sast.domain.Cliente;
import br.com.sast.domain.Perfil;

@ManagedBean
@ViewScoped
public class ClienteBean {
	
	private Cliente cliente;
	private List<Cliente> clientes;
	private Integer codigo;
	
	//Chaves estrangeiras
	private List<Perfil> perfis;
	
	//GETS & SETS
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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
	
	
	//MÉTODOS CRUD
	
	//método que prepara a tela para inserir novo registro.
	public void novo(){
		
		cliente = new Cliente();
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		//chave estrangeira.
		PerfilDAO perfilDAO = new PerfilDAO();
		
		clientes = clienteDAO.listar();
		
		//chave estrangeira.
		perfis = perfilDAO.listar();
		
	}//fim do método novo
	
	//método para inserir um novo registro no banco.
	public void salvar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(cliente);
		
		//FIXME: Classe ClienteBean: Erro omnifaces, comando Messages.addGlobalInfo
		//Messages.addGlobalInfo("Cliente inserido com sucesso!");
		
	}//fim do método salvar
	
	//método para listar todos os registros do banco.
	public void listar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clientes = clienteDAO.listar();
		
	}//fim do método listar.
	
	//método para buscar um registro específico no banco.
	public void buscar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		cliente = clienteDAO.consultar(codigo);
		
		PerfilDAO perfilDAO = new PerfilDAO();
		perfis = perfilDAO.listar();
		
	}//fim do método buscar
	
	//método para editar um registro específico no banco.
	public void editar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.editar(cliente);
		
		//FIXME: Classe ClienteBean: Erro omnifaces, comando Messages.addGlobalInfo
		//Messages.addGlobalInfo("Cliente editado com sucesso!");
		
	}//fim do método editar
	
	//método para excluir um registro específico no banco.
	public void excluir(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.excluir(cliente);
		
		//FIXME: Classe ClienteBean: Erro omnifaces, comando Messages.addGlobalInfo
		//Messages.addGlobalInfo("Cliente deletado com sucesso!");
		
	}//fim do método excluir
	
}
