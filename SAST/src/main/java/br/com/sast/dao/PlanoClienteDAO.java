package br.com.sast.dao;

import br.com.sast.domain.Cliente;
import br.com.sast.domain.Plano;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.PlanoCliente;
import br.com.sast.util.HibernateUtil;
import java.util.ArrayList;

/**
 * Classe definida para realizar a persistência na entidade "tb_planopessoa".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class PlanoClienteDAO {
    
    private static ClienteDAO clienteDAO;
	
	//Função para inserir dados no banco
	public void inserir(PlanoCliente planocliente){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
                        //Cliente cliente = clienteDAO.consultar(planocliente.getCodigoCliente().getCodigo());
                        //PlanoCliente planoClienteSalvar = new PlanoCliente();
                        
                        //planoClienteSalvar.setCodigo(planocliente.getCodigo());
                        //planoClienteSalvar.setCodigoCliente(cliente);
                        //planoClienteSalvar.setCodigoPlano(planocliente.getCodigoPlano());
                        
			sessao.save(planocliente);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método inserir
	
	//Função para listar todos os registros da tabela planopessoa
	@SuppressWarnings({"deprecation", "unchecked"})
	public List<PlanoCliente> listar(){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(PlanoCliente.class);
			consulta.addOrder(Order.asc("codigo"));
			
			List<PlanoCliente>resultado = consulta.list();
			
			return resultado;
			
		}catch(RuntimeException erro){
			
			throw erro;
			
		}finally{
			
			sessao.close();
			
		}
		
		
	}//Fim do método listar
	
         // Método que fará a persistência no banco para listar todos os planos armazenados
    @SuppressWarnings({"deprecation", "unchecked"})
    public List<PlanoCliente> listarPlanosCliente(Integer codigo) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(PlanoCliente.class);
            
            ClienteDAO clienteDAO = new ClienteDAO();
            
            consulta.add(Restrictions.eq("codigoCliente", clienteDAO.consultar(codigo)));
            List<PlanoCliente> resultado = consulta.list();
            List<Plano> resultadoPlanoCliente = new ArrayList<>();
            
            Criteria consultaPlano = sessao.createCriteria(Plano.class);
            resultado.forEach((planoCliente) -> {
                resultadoPlanoCliente.add(planoCliente.getCodigoPlano());
            });
            
            return resultado;

        } catch (RuntimeException erro) {
            throw erro;

        } finally {
            sessao.close();

        }
    } // Fim do método listar
        
	//Função para buscar um registro no banco
	 @SuppressWarnings({"deprecation", "unchecked"})
	public PlanoCliente consultar(int codPlanoPessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		PlanoCliente planopessoa = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(PlanoCliente.class);
			consulta.add(Restrictions.eq("codigo", codPlanoPessoa));
			
			planopessoa = (PlanoCliente)consulta.uniqueResult();
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return planopessoa;
		
	}//Fim do método buscar
	
	//Método para editar um registro
	public void editar(PlanoCliente planopessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.update(planopessoa);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método editar
	
	//Função para excluir um registro
	public void excluir(PlanoCliente planocliente){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.delete(planocliente);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método para excluir
}//Fim da classe
