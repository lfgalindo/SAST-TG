package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Pessoa;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_pessoa".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class PessoaDAO {
	
	//Método para inserir dados no banco
	public void inserir(Pessoa pessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.save(pessoa);
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
	public List<Pessoa> listar(){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(Pessoa.class);
			consulta.addOrder(Order.asc("codigo"));
			
			List<Pessoa> resultado = consulta.list();
			
			return resultado;
			
		}catch(RuntimeException erro){
			
			throw erro;
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método listar
	
	
	//Método para buscar um registro do banco.
	@SuppressWarnings("deprecation")
	public Pessoa consultar(int codCli){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		Pessoa pessoa = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(Pessoa.class);
			
			consulta.add(Restrictions.eq("codigo", codCli));
			
			pessoa = (Pessoa)consulta.uniqueResult();
			
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return pessoa;
		
	}// Fim da classe consultar
	
	//Método para editar um registro do banco
	public void editar(Pessoa pessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.update(pessoa);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método editar
	
	//Método para excluir um registro do banco
	public void excluir(Pessoa pessoa){
		
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
