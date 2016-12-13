package br.com.sast.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
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
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		cliente.setBairro("Vila Santa Tereza");
		cliente.setCidade("Chavantes");
		cliente.setComplemento("Casa");
		cliente.setCpf("44568786819");
		cliente.setEmail("guihms1@gmail.com");
		cliente.setEndereco("Rua José de Souza Carvalho");
		cliente.setEstadoCivil("Solteiro");
		cliente.setEstado("SP");
		cliente.setLogin("guihms1");
		cliente.setNascimento(new Date());
		cliente.setNumero("06");
		cliente.setRg("469823734");
		cliente.setSenha("123");
		cliente.setTelefone("996440052");
		cliente.setNome("Luís Guilherme Fernandes Ferreira");
		cliente.setRazao("Luís Guilherme Fernandes Ferreira");
		cliente.setCodigoPerfil(perfil);
		
		clienteDAO.inserir(cliente);
		
	}//Fim do método incluir
	
	@Ignore
	@Test
	public void consultar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = clienteDAO.consultar(4);
		
		System.out.println("Nome do cliente: " + cliente.getNome() + "\nTelefone: " + cliente.getTelefone());
		
	}//Fim do método consultar
	
	@Ignore
	@Test
    public void listar(){
		
		ClienteDAO clienteDAO = new ClienteDAO();

        List<Cliente> resultado = clienteDAO.listar();
        
        for(Cliente cliente : resultado){
            System.out.println(cliente);
        }
    }
	
	@Ignore
	@Test
    public void editar(){

        Integer codigo = 4;

        ClienteDAO clienteDAO = new ClienteDAO();

        Cliente resultado = clienteDAO.consultar(codigo);
        
        System.out.println("Cliente encontrado " + resultado);
        
        resultado.setNome("LUIZINHO GALINDO");
        
        clienteDAO.editar(resultado,false);
        
        System.out.println("Cliente Editado: " + resultado);
    }
	
	@Ignore
    @Test
    public void excluir(){
        
		Integer codigo = 7;

        ClienteDAO clienteDAO = new ClienteDAO();
        
        Cliente resultado = clienteDAO.consultar(codigo);
        
        clienteDAO.excluir(resultado);
        
        System.out.println("Cliente excluído " + resultado);
        
    }
	
}
