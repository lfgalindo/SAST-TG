package br.com.sast.util;

import java.sql.Connection;
import java.sql.SQLException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;

/**
 * Classe definida para gerenciar sessões de conexão com o banco.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */

public class HibernateUtil {
 
    private static final SessionFactory sessionFactory = buildSessionFactory();
 
    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration()
            		.configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Connection getConexao() {
        Session sessao = sessionFactory.openSession();
        
        Connection conexao = sessao.doReturningWork(new ReturningWork<Connection>() {
            @Override
            public Connection execute(Connection cnctn) throws SQLException {
                return cnctn;
            }
        });
        
        return conexao;
    }
} // Fim da Classe
