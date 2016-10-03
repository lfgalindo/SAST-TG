package br.com.sast.test;

import java.util.Date;
import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.sast.dao.CaixaDAO;
import br.com.sast.dao.PessoaDAO;
import br.com.sast.domain.Caixa;
import br.com.sast.domain.Pessoa;

/**
 * Classe definida para para testar os métodos da classe CaixaDAO.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 31/08/2016
 */

public class CaixaDAOTest {
	
	@Test
    //@Ignore
	public void inserir(){
		PessoaDAO pessoaDAO = new PessoaDAO();
		Caixa caixa = new Caixa();
		
		
		Pessoa pessoa = pessoaDAO.consultar(1);
		
		caixa.setCodigo(2);
		caixa.setDtCriacao(new Date());
		caixa.setPessoa(pessoa);
		caixa.setRemovido(0);
		
		CaixaDAO caixaDAO = new CaixaDAO();
		
		caixaDAO.inserir(caixa);
	}
	
	@Test
    public void listar(){
		
		CaixaDAO caixaDAO = new CaixaDAO();

        List<Caixa> resultado = caixaDAO.listar();
        
        for(Caixa caixa : resultado){
            System.out.println(caixa);
        }
    }
	
    @Test
    @Ignore
    public void buscar(){
    	
        Integer codigo = 13;
        
        CaixaDAO caixaDAO = new CaixaDAO();
        
        Caixa resultado = caixaDAO.buscar(codigo);
        
        System.out.println("Objeto encontrado: " + resultado);
    }
    
    @Test
    @Ignore
    public void excluir(){
        Integer codigo = 13;

        CaixaDAO caixaDAO = new CaixaDAO();
        
        Caixa resultado = caixaDAO.buscar(codigo);
        
        System.out.println("Objeto excluído " + resultado);
        
        caixaDAO.excluir(resultado);
    }
    
    @Test
    @Ignore
    public void editar(){

        Integer codigo = 14;

        CaixaDAO caixaDAO = new CaixaDAO();

        Caixa resultado = caixaDAO.buscar(codigo);
        
        System.out.println("Objeto encontrado " + resultado);
        
        resultado.setRemovido(10);
        
        caixaDAO.editar(resultado);
        
        System.out.println("Objeto Editado: " + resultado);
    }	

}
