package br.com.sast.test;

import java.util.List;
import org.junit.Ignore;
import org.junit.Test;
import br.com.sast.dao.PerfilDAO;
import br.com.sast.domain.Perfil;

/**
 * Classe definida para para testar os métodos da classe PerfilDAO.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 31/08/2016
 */

public class PerfilDAOTest {

	@Test
    @Ignore
	public void inserir(){
		
		Perfil perfil = new Perfil();
		Integer dado = 5;
		
		perfil.setCodigo(dado);
		perfil.setGerenciarCaixas(dado);
		perfil.setNomePerfil("TesteCinco");
		perfil.setGerenciarCargos(dado);
		perfil.setGerenciarConfiguracoes(dado);
		perfil.setGerenciarFaturas(dado);
		perfil.setGerenciarManutencoes(dado);
		perfil.setGerenciarMovimentacoes(dado);
		perfil.setGerenciarPessoas(dado);
		perfil.setGerenciarPlanos(dado);
		
		PerfilDAO perf = new PerfilDAO();
		
		perf.inserir(perfil);	
	}
	
	@Test
    @Ignore
    public void listar(){
		
		PerfilDAO perfilDAO = new PerfilDAO();

        List<Perfil> resultado = perfilDAO.listar();
        
        for(Perfil perfil : resultado){
            System.out.println(perfil);
        }
    }
	
    @Test
    @Ignore
    public void buscar(){
    	
        Integer codigo = 4;
        
        PerfilDAO perfilDAO = new PerfilDAO();
        
        Perfil resultado = perfilDAO.buscar(codigo);
        
        System.out.println("Objeto encontrado: " + resultado);
    }
    
    @Test
    public void excluir(){
        Integer codigo = 5;

        PerfilDAO perfilDAO = new PerfilDAO();
        
        Perfil resultado = perfilDAO.buscar(codigo);
        
        System.out.println("Objeto excluído " + resultado);
        
        perfilDAO.excluir(resultado);
    }
    
    @Test
    @Ignore
    public void editar(){

        Integer codigo = 3;

        PerfilDAO perfilDAO = new PerfilDAO();

        Perfil resultado = perfilDAO.buscar(codigo);
        
        System.out.println("Objeto encontrado " + resultado);
        
        resultado.setNomePerfil("TesteTres");
        
        perfilDAO.editar(resultado);
        
        System.out.println("Objeto Editado: " + resultado);
    }
	
}
