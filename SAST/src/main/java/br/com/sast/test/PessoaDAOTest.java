package br.com.sast.test;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sast.dao.PerfilDAO;
import br.com.sast.dao.ClienteDAO;
import br.com.sast.domain.Perfil;
import br.com.sast.domain.Cliente;

/**
 * Classe definida para para testar os métodos da classe PesssoaDAO.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 01/09/2016
 */

public class PessoaDAOTest {

	@Test
	@Ignore
	public void inserir(){
		
		PerfilDAO perfilDAO = new PerfilDAO();
		Date data = new Date();
	
		Cliente cliente = new Cliente();
		
		Perfil perfil = perfilDAO.buscar(4);
		
		cliente.setNome("LUIZINHO");
		cliente.setTelefone("99999");
		cliente.setNascimento(data);
		cliente.setLogin("LUIZIN");
		cliente.setEmail("LUIZINHO@NET");
		cliente.setCpf("88888");
		cliente.setEndereco("RUA DO LUIZINHO");
		cliente.setCodigoPerfil(perfil);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(cliente);
		
		
	}//Fim do método inserir
	
	@Test
	public void consultar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = clienteDAO.consultar(1);
		
		System.out.println(cliente);
		
	}//Fim do método consultar
	
}
