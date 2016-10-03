package br.com.sast.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.sast.domain.Fatura;
import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para mapear a entidade "tb_fatura" e seus atributos.
 * 
 * @author Luis Claudio Gonçalves Sanches <luis.cgs@hotmail.com>
 * @since 11/09/2016
 */

public class FaturaDAO {

	public void inserir(Fatura fatura) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			sessao.beginTransaction();

			sessao.save(fatura);

			sessao.getTransaction().commit();

		} catch (RuntimeException erro) {
			sessao.getTransaction().rollback();
			erro.getMessage();

		} finally {
			sessao.close();
		}

	} // Fim do método inserir

	@SuppressWarnings("deprecation")
	public Fatura buscar(Integer codigo) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			Criteria consulta = sessao.createCriteria(Fatura.class);

			consulta.add(Restrictions.eq("codigo", codigo));

			Fatura resultado = (Fatura) consulta.uniqueResult();

			return resultado;

		} catch (RuntimeException erro) {
			throw erro;

		} finally {
			sessao.close();

		}
	} // Fim do método buscar
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Fatura> listar() {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			
			Criteria consulta = sessao.createCriteria(Fatura.class);

			consulta.addOrder(Order.asc("codigo"));

			List<Fatura> resultado = consulta.list();

			return resultado;

		} catch (RuntimeException erro) {
			throw erro;

		} finally {
			sessao.close();

		}
	} // Fim do método listar

	public void excluir(Fatura fatura) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			sessao.beginTransaction();

			sessao.delete(fatura);

			sessao.getTransaction().commit();

		} catch (RuntimeException erro) {
			sessao.getTransaction().rollback();
			erro.getMessage();

		} finally {
			sessao.close();
		}
	} // Fim do método Excluir

	public void editar(Fatura fatura) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();

		try {
			sessao.beginTransaction();

			sessao.update(fatura);

			sessao.getTransaction().commit();

		} catch (RuntimeException erro) {
			sessao.getTransaction().rollback();
			erro.getMessage();

		} finally {
			sessao.close();
		}
	} // Fim do método Editar

}
