package br.com.sast.test;

import java.util.Date;

import org.junit.Test;

import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.PerfilDAO;
import br.com.sast.domain.Cliente;
import br.com.sast.domain.Perfil;

/**
 * Classe definida para para testar os métodos da classe ClienteDAO.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 09/10/2016
 */

public class ClienteDAOTest {
	
	@Test
	public void inserir(){
		
		Cliente cliente = new Cliente();
		
		PerfilDAO perfilDAO = new PerfilDAO();
		
		Perfil perfil = perfilDAO.buscar(3);
		
		cliente.setNome("Luís Guilherme Fernandes Ferreira");
		cliente.setRazao("Luís Guilherme Fernandes Ferreira");
		cliente.setBairro("Vila Santa Tereza");
		cliente.setCidade("Chavantes");
		cliente.setComplemento("Casa");
		cliente.setCpf("44568786819");
		cliente.setEmail("guihms1@gmail.com");
		cliente.setEndereco("Rua José de Souza Carvalho");
		cliente.setEstado("Solteiro");
		cliente.setEstado("SÃO PAULO");
		cliente.setLogin("guihms1");
		cliente.setNascimento(new Date());
		cliente.setNumero("06");
		cliente.setRg("469823732");
		cliente.setSenha("senha");
		cliente.setTelefone("996440052");
		cliente.setCodigoPerfil(perfil);
		
		
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.inserir(cliente);
		
	}

}
