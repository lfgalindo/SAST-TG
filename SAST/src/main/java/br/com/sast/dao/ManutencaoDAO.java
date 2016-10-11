package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Manutencao;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para realizar a persistência na entidade "tb_manutencao".
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since 31/08/2016
 */

public class ManutencaoDAO {
	
	//Método para inserir dados no banco.
	public void inserir(Manutencao manutencao){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.save(manutencao);
			sessao.beginTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
		}
		
	}//Fim do método inserir
	
	//Método para listar todos os registros do banco.
	@SuppressWarnings({"deprecation", "unchecked"})
	public List<Manutencao> listar(){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			Criteria consulta = sessao.createCriteria(Manutencao.class);
			
			consulta.addOrder(Order.asc("codigo"));
			
			List<Manutencao> resultado = consulta.list();
			
			return resultado;
			
		}catch(RuntimeException erro){
			
			throw erro;
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método listar
	
	
	//Método para consulta um registro do banco.
	@SuppressWarnings("deprecation")
	public Manutencao consultar(int CodManutencao){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Manutencao manutencao = null;
		
		try{
			
			Criteria consulta = sessao.createCriteria(Manutencao.class);
			consulta.add(Restrictions.eq("codigo", CodManutencao));
			
			manutencao = (Manutencao)consulta.uniqueResult();
			
		}catch(RuntimeException erro){
			
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
		return manutencao;
		
	}// Fim do método buscar
	
	//Método para editar um registro do banco
	public void editar(Manutencao manutencao){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.update(manutencao);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método editar
	
	//Método para excluir um registro do banco
	public void excluir(Manutencao manutencao){
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
			
			sessao.beginTransaction();
			sessao.delete(manutencao);
			sessao.getTransaction().commit();
			
		}catch(RuntimeException erro){
			
			sessao.getTransaction().rollback();
			erro.getMessage();
			
		}finally{
			
			sessao.close();
			
		}
		
	}//Fim do método excluir
	

}//Fim da classe
