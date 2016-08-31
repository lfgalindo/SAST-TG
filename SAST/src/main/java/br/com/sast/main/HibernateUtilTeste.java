package br.com.sast.main;

import br.com.sast.util.HibernateUtil;

/**
 * Classe definida para testar a conexão com o banco de dados 
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 31/08/2016
 */

public class HibernateUtilTeste {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
        HibernateUtil.getSessionFactory().close();
    }
}