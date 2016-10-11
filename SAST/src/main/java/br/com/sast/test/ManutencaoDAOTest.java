package br.com.sast.test;

import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sast.domain.Cliente;
import br.com.sast.domain.Funcionario;
import br.com.sast.domain.Manutencao;
import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.dao.ManutencaoDAO;


/**
 * Classe definida para para testar os métodos da classe ManutencaoDAO.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 10/10/2016
 */

public class ManutencaoDAOTest {
	
	@Ignore
	@Test
	public void inserir(){
		
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		
		Funcionario func = funcionarioDAO.consultar(4);
		
		ClienteDAO clienteDAO = new ClienteDAO();
		
		Cliente cliente = clienteDAO.consultar(3);
		
		Manutencao manut = new Manutencao();
		
		ManutencaoDAO manutDAO = new ManutencaoDAO(); 
		
		manut.setBaixa(0);
		manut.setDescProblema("CONEXÃO LENTA");
		manut.setDescricao("CLIENTE RECLAMANDO PARA CARAMBA!");
		manut.setDtAgendamento(new Date());
		manut.setDtExecucao(null);
		manut.setObservacoes("LEVAR ROTEDOR");
		manut.setPrioridade("ALTA");
		manut.setCodigoCliente(cliente);
		manut.setCodigoFuncionario(func);
		
		manutDAO.inserir(manut);
		
	}//Fim do método incluir
	
	@Ignore
	@Test
	public void consultar(){
		
		ManutencaoDAO manutDAO = new ManutencaoDAO();
		
		Manutencao manut = manutDAO.consultar(5);
		
		System.out.println("Descrição da manutenção: " + manut.getDescricao() + "\nPrioridade: " + manut.getPrioridade());
		
	}//Fim do método consultar
	
	@Ignore
	@Test
    public void listar(){
		
		ManutencaoDAO manutDAO = new ManutencaoDAO();

        List<Manutencao> resultado = manutDAO.listar();
        
        for(Manutencao manut : resultado){
            System.out.println(manut);
        }
    }
	
	@Ignore
	@Test
    public void editar(){

        Integer codigo = 5;

        ManutencaoDAO manutDAO = new ManutencaoDAO();

        Manutencao resultado = manutDAO.consultar(codigo);
        
        System.out.println("Manutenção encontrada: " + resultado);
        
        resultado.setDescricao("MANUTENÇÃO PRO LUIZINHO");
        
        manutDAO.editar(resultado);
        
        System.out.println("Manutençao Editada: " + resultado);
    }
	
	@Ignore
    @Test
    public void excluir(){
        
		Integer codigo = 6;

        ManutencaoDAO manutDAO = new ManutencaoDAO();
        
        Manutencao resultado = manutDAO.consultar(codigo);
        
        manutDAO.excluir(resultado);
        
        System.out.println("Manutenção excluída: " + resultado);
        
    }
	
	
}
