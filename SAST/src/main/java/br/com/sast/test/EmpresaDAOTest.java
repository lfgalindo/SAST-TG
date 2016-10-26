package br.com.sast.test;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.com.sast.dao.EmpresaDAO;
import br.com.sast.domain.Empresa;


/**
 * Classe definida para para testar os métodos da classe EmpresaDAO.
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 11/10/2016
 */

public class EmpresaDAOTest {
	
	@Ignore
	@Test
	public void inserir(){
		
		Empresa empresa = new Empresa();
		
		empresa.setBairro("BAIRRO DA EMPRESA");
		empresa.setCidade("CHAVANTES");
		empresa.setCnpj("02587858700016");
		empresa.setEmail("email@email.com");
		empresa.setEndereco("RUA DA EMPRESA");
		empresa.setEstado("SP");
		empresa.setNomeEmpresa("LUIZINHO COMPANY");
		empresa.setNumero("06");
		empresa.setRazaoSocial("LUIZINHO COMPANY LTDA.");
		empresa.setTelefone("1433428877");
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		empresaDAO.inserir(empresa);
		
	}// Fim do método inserir
	
	@Ignore
	@Test
	public void consultar(){
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		
		Empresa empresa = empresaDAO.buscar(15);
		
		System.out.println("Nome da empresa: " + empresa.getNomeEmpresa() + "\nRazão Social: " + empresa.getRazaoSocial());
		
	}//Fim do método consultar
	
	@Ignore
	@Test
    public void listar(){
		
		EmpresaDAO empresaDAO = new EmpresaDAO();

        List<Empresa> resultado = empresaDAO.listar();
        
        for(Empresa empresa : resultado){
            System.out.println(empresa);
        }
        
    }// Fim do método listar
	
	@Ignore
	@Test
    public void editar(){

        Integer codigo = 16;

        EmpresaDAO empresaDAO = new EmpresaDAO();

        Empresa resultado = empresaDAO.buscar(codigo);
        
        System.out.println("Objeto encontrado " + resultado);
        
        resultado.setNomeEmpresa("LUIZÃO");
        
        empresaDAO.editar(resultado);
        
        System.out.println("Objeto Editado: " + resultado);
        
    }// Fim do método editar
	
	@Ignore
	@Test
    public void excluir(){
        Integer codigo = 16;

        EmpresaDAO empresaDAO = new EmpresaDAO();
        
        Empresa resultado = empresaDAO.buscar(codigo);
        
        empresaDAO.excluir(resultado);
        
        System.out.println("Objeto excluído " + resultado);
        
    }
	
}
