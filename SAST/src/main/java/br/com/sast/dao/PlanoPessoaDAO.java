package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.PlanoPessoa;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_planopessoa".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class PlanoPessoaDAO {
	
	//Função para inserir dados no banco
	public void inserir(PlanoPessoa planopessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.save(planopessoa);
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
	public List<PlanoPessoa> listar(){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(PlanoPessoa.class);
			consulta.addOrder(Order.asc("codigo"));
			
			List<PlanoPessoa>resultado = consulta.list();
			
			return resultado;
			
		}catch(RuntimeException erro){
			
			throw erro;
			
		}finally{
			
			sessao.close();
			
		}
		
		
	}//Fim do método listar
	
	//Função para buscar um registro no banco
	@SuppressWarnings("deprecation")
	public PlanoPessoa consultar(int codPlanoPessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		PlanoPessoa planopessoa = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(PlanoPessoa.class);
			consulta.add(Restrictions.eq("codigo", codPlanoPessoa));
			
			planopessoa = (PlanoPessoa)consulta.uniqueResult();
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return planopessoa;
		
	}//Fim do método buscar
	
	//Método para editar um registro
	public void editar(PlanoPessoa planopessoa){
		
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
	public void excluir(PlanoPessoa planopessoa){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.delete(planopessoa);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método para excluir
}//Fim da classe
