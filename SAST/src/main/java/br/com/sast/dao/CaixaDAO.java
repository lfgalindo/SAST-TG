package br.com.sast.dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import br.com.sast.domain.Caixa;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_caixa".
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */

public class CaixaDAO {
	
	// Método que fará a persistência no banco para inserir um caixa
	public void inserir(Caixa caixa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	
        try {
        	sessao.beginTransaction();

            sessao.save(caixa);

            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
        	sessao.getTransaction().rollback();
            erro.getMessage();
            
        } finally {
            sessao.close();
        }
        
	} // Fim do método inserir
	
	// Método que fará a persistência no banco para listar todos os caixas armazenados
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Caixa> listar(){
		
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            Criteria consulta = sessao.createCriteria(Caixa.class);
            
            consulta.addOrder(Order.asc("pessoa"));
            
            List<Caixa> resultado = consulta.list();
            
            return resultado;
            
        }catch(RuntimeException erro){
            throw erro;
            
        } finally{
            sessao.close();
            
        }
    } // Fim do método listar
	
	// Método que fará a persistência no banco para buscar um determinado caixa
	@SuppressWarnings("deprecation")
	public Caixa buscar(Integer codigo){
			
	        Session sessao = HibernateUtil.getSessionFactory().openSession();
	        
	        try{
	            Criteria consulta = sessao.createCriteria(Caixa.class);
	            
	            consulta.add(Restrictions.eq("codigo", codigo));

	            Caixa resultado = (Caixa)consulta.uniqueResult();

	            return resultado;
	            
	        }catch(RuntimeException erro){
	            throw erro;
	            
	        } finally{
	            sessao.close();
	            
	        }
	    } // Fim do método buscar
	    
		// Método que fará a persistência no banco para excluir um caixa
	    public void excluir(Caixa caixa){
	    	
	        Session sessao = HibernateUtil.getSessionFactory().openSession();
	                
	        try{
	            sessao.beginTransaction();
	            
	            sessao.delete(caixa);
	            
	            sessao.getTransaction().commit();
	            
	        }catch(RuntimeException erro){
	        	sessao.getTransaction().rollback();
	            erro.getMessage();

	        } finally{
	            sessao.close();
	        }       
	    } // Fim do método Excluir
	    
	    // Método que fará a persistência no banco para editar um caixa
	    public void editar(Caixa caixa){
	    	
	        Session sessao = HibernateUtil.getSessionFactory().openSession();
	        
	        try{
	            sessao.beginTransaction();
	            
	            sessao.update(caixa);
	            
	            sessao.getTransaction().commit();
	            
	        }catch(RuntimeException erro){
	                sessao.getTransaction().rollback();
	                erro.getMessage();
	                
	        } finally{
	            sessao.close();
	        }       
	    } // Fim do método Editar
	
}// Fim da Classe
