package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Perfil;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_perfil".
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */

public class PerfilDAO {
	
	// Método que fará a persistência no banco para inserir um perfil 
	public void inserir(Perfil perfil){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	
        try {
        	sessao.beginTransaction();

            sessao.save(perfil);

            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
        	sessao.getTransaction().rollback();
            erro.getMessage();
            
        } finally {
            sessao.close();
        }
				
	} // Fim do método inserir
	
	// Método que fará a persistência no banco para listar todos os perfis armazenados
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Perfil> listar(){
		
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            Criteria consulta = sessao.createCriteria(Perfil.class);
            
            consulta.addOrder(Order.asc("nomePerfil"));
            
            List<Perfil> resultado = consulta.list();
            
            return resultado;
            
        }catch(RuntimeException erro){
            throw erro;
            
        } finally{
            sessao.close();
            
        }
    } // Fim do método listar
	
	// Método que fará a persistência no banco para buscar um determinado perfil

	@SuppressWarnings("deprecation")
	public Perfil buscar(Integer codigo){
		
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            Criteria consulta = sessao.createCriteria(Perfil.class);
            
            consulta.add(Restrictions.eq("codigo", codigo));

            Perfil resultado = (Perfil)consulta.uniqueResult();

            return resultado;
            
        }catch(RuntimeException erro){
            throw erro;
            
        } finally{
            sessao.close();
            
        }
    } // Fim do método buscar
    
	// Método que fará a persistência no banco para excluir um perfil
    public void excluir(Perfil perfil){
    	
        Session sessao = HibernateUtil.getSessionFactory().openSession();
                
        try{
            sessao.beginTransaction();
            
            sessao.delete(perfil);
            
            sessao.getTransaction().commit();
            
        }catch(RuntimeException erro){
        	sessao.getTransaction().rollback();
            erro.getMessage();

        } finally{
            sessao.close();
        }       
    } // Fim do método Excluir
    
    // Método que fará a persistência no banco para editar um perfil
    public void editar(Perfil perfil){
    	
        Session sessao = HibernateUtil.getSessionFactory().openSession();
        
        try{
            sessao.beginTransaction();
            
            sessao.update(perfil);
            
            sessao.getTransaction().commit();
            
        }catch(RuntimeException erro){
                sessao.getTransaction().rollback();
                erro.getMessage();
                
        } finally{
            sessao.close();
        }       
    } // Fim do método Editar

} // Fim da classe
