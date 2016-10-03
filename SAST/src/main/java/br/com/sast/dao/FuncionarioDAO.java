package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Funcionario;
import br.com.sast.util.HibernateUtil;


/**
 * Classe definida para realizar a persistência na entidade "tb_funcionario".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class FuncionarioDAO {
	
	//Método para inserir dados no banco
	public void inserir(Funcionario cliente){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.save(cliente);
			sessao.beginTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método inserir
	
	
	//Método para listar os registros do banco
	@SuppressWarnings({"deprecation", "unchecked"})
	public List<Funcionario> listar(){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			consulta.addOrder(Order.asc("codigo"));
			
			List<Funcionario> resultado = consulta.list();
			
			return resultado;
			
		}catch(RuntimeException erro){
			
			throw erro;
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método listar
	
	
	//Método para buscar um registro do banco.
	@SuppressWarnings("deprecation")
	public Funcionario consultar(int codCli){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Funcionario pessoa = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(Funcionario.class);
			
			consulta.add(Restrictions.eq("codigo", codCli));
			
			pessoa = (Funcionario)consulta.uniqueResult();
			
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return pessoa;
		
	}// Fim da classe consultar
	
	//Método para editar um registro do banco
	public void editar(Funcionario cliente){
		
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
	public void excluir(Funcionario pessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.delete(pessoa);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método excluir
	

} //Fim da classe PessoaDAO
