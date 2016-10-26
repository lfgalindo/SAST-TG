package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Cliente;
import br.com.sast.util.HibernateUtil;


/**
 * Classe definida para realizar a persistência na entidade "tb_cliente".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class ClienteDAO {
	
	//Método para inserir dados no banco
	public void inserir(Cliente cliente){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
	
        try {
        	sessao.beginTransaction();

            sessao.save(cliente);

            sessao.getTransaction().commit();

        } catch (RuntimeException erro) {
        	sessao.getTransaction().rollback();
            erro.getMessage();
            
        } finally {
            sessao.close();
        }
				
	} // Fim do método inserir
	
	
	//Método para listar os registros do banco
	@SuppressWarnings({"deprecation", "unchecked"})
	public List<Cliente> listar(){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(Cliente.class);
			consulta.addOrder(Order.asc("codigo"));
			
			List<Cliente> resultado = consulta.list();
			
			return resultado;
			
		}catch(RuntimeException erro){
			
			throw erro;
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método listar
	
	
	//Método para buscar um registro do banco.
	@SuppressWarnings("deprecation")
	public Cliente consultar(int codCli){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Cliente pessoa = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(Cliente.class);
			
			consulta.add(Restrictions.eq("codigo", codCli));
			
			pessoa = (Cliente)consulta.uniqueResult();
			
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return pessoa;
		
	}// Fim da classe consultar
	
	//Método para editar um registro do banco
	public void editar(Cliente cliente){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.update(cliente);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método editar
	
	//Método para excluir um registro do banco
	public void excluir(Cliente cliente){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.delete(cliente);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método excluir
	

} //Fim da classe PessoaDAO
