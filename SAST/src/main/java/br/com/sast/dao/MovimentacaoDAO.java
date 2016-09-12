package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Movimentacao;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para mapear a entidade "tb_movimentacao" e seus atributos.
 * 
 * @author Luis Claudio Gonçalves Sanches <luis.cgs@hotmail.com>
 * @since 29/08/2016
 */

public class MovimentacaoDAO {
	
	public void inserir(Movimentacao movimentacao) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			sessao.beginTransaction();

			sessao.save(movimentacao);

			sessao.getTransaction().commit();

		} catch (RuntimeException erro) {
			sessao.getTransaction().rollback();
			erro.getMessage();

		} finally {
			sessao.close();
		}

	} // Fim do método inserir

	@SuppressWarnings("deprecation")
	public Movimentacao buscar(Integer codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Movimentacao.class);

			consulta.add(Restrictions.eq("codigo", codigo));

			Movimentacao resultado = (Movimentacao) consulta.uniqueResult();

			return resultado;

		} catch (RuntimeException erro) {
			throw erro;

		} finally {
			sessao.close();

		}
	} // Fim do método buscar
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Movimentacao> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			
			Criteria consulta = sessao.createCriteria(Movimentacao.class);

			consulta.addOrder(Order.asc("codigo"));

			List<Movimentacao> resultado = consulta.list();

			return resultado;

		} catch (RuntimeException erro) {
			throw erro;

		} finally {
			sessao.close();

		}
	} // Fim do método listar

	public void excluir(Movimentacao movimentacao) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			sessao.beginTransaction();

			sessao.delete(movimentacao);

			sessao.getTransaction().commit();

		} catch (RuntimeException erro) {
			sessao.getTransaction().rollback();
			erro.getMessage();

		} finally {
			sessao.close();
		}
	} // Fim do método Excluir

	public void editar(Movimentacao movimentacao) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			sessao.beginTransaction();

			sessao.update(movimentacao);

			sessao.getTransaction().commit();

		} catch (RuntimeException erro) {
			sessao.getTransaction().rollback();
			erro.getMessage();

		} finally {
			sessao.close();
		}
	} // Fim do método Editar
	
}
