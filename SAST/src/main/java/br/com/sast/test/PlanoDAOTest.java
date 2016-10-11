package br.com.sast.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import br.com.sast.dao.PlanoDAO;
import br.com.sast.domain.Plano;

/**
 * Classe definida para para testar os métodos da classe PlanoDAO.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 31/08/2016
 */

public class PlanoDAOTest {

	@Test
	public void inserir(){
		
		Plano plano = new Plano();
		
		plano.seDescricao("testetres");
		plano.setGarantia(70);
		plano.setTipoConexao("Fumaça");
		plano.setValor(99.90);
		plano.setVelocidade(5500);
		
		PlanoDAO planoDAO = new PlanoDAO();
		
		planoDAO.inserir(plano);
	}
	
	@Test
    public void listar(){
		
		PlanoDAO planoDAO = new PlanoDAO();

        List<Plano> resultado = planoDAO.listar();
        
        for(Plano plano : resultado){
            System.out.println(plano);
        }
    }
	
    @Test
    @Ignore
    public void buscar(){
    	
        Integer codigo = 17;
        
        PlanoDAO planoDAO = new PlanoDAO();
        
        Plano resultado = planoDAO.buscar(codigo);
        
        System.out.println("Objeto encontrado: " + resultado);
    }
    
    @Test
    @Ignore
    public void excluir(){
        Integer codigo = 18;

        PlanoDAO planoDAO = new PlanoDAO();
        
        Plano resultado = planoDAO.buscar(codigo);
        
        System.out.println("Objeto excluído " + resultado);
        
        planoDAO.excluir(resultado);
    }
    
    @Test
    @Ignore
    public void editar(){

        Integer codigo = 17;

        PlanoDAO planoDAO = new PlanoDAO();

        Plano resultado = planoDAO.buscar(codigo);
        
        System.out.println("Objeto encontrado " + resultado);
        
        resultado.setTipoConexao("TipoEditado");
        
        planoDAO.editar(resultado);
        
        System.out.println("Objeto Editado: " + resultado);
    }
}
