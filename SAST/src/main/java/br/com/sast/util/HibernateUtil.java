package br.com.sast.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


/**
 * Classe definida para gerenciar sessões de conexão com o banco.
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 30/08/2016
 */

public class HibernateUtil {
	
	private static final SessionFactory sessionFactory = buildSessionFactory();
   
	private static SessionFactory buildSessionFactory(){
		
		try{
			// Cria um SessionFactory de acordo com o hibernate.cfg.xml
			Configuration configuration = new Configuration();
			configuration.configure();
			
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties()).build();
			
			SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
			return sessionFactory;
		} 
		catch (Throwable e){
			// Mensagem de erro
			System.out.println("Erro na criação da fábrica de sessão." + e.getMessage());
			throw new ExceptionInInitializerError(); 
		}
	}
		
	public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
} // Fim da Classe
