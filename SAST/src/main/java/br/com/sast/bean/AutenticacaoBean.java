package br.com.sast.bean;

import br.com.sast.dao.FuncionarioDAO;
import br.com.sast.domain.Funcionario;
import javax.annotation.PostConstruct;

/**
 * Classe definida para controlar a autenticação de Usuários
 * @author Luiz Felipe Magalhães Galindo <lfgalindo@live.com>
 * @since 04/10/2016
 */
public class AutenticacaoBean {
    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
    private Funcionario funcionario;
    private Funcionario funcionarioLogado;
    
    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    public void setFuncionarioLogado(Funcionario funcionarioLogado) {
        this.funcionarioLogado = funcionarioLogado;
    }
       
    @PostConstruct
    public void iniciar() {
        funcionario = new Funcionario();
    }

    public void autenticar() {
        //try {
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
            funcionarioLogado = funcionarioDAO.autenticar(funcionario.getLogin(), funcionario.getSenha());
            
            //if(funcionarioLogado == null){
              //  Messages.addGlobalError("Login e/ou senha incorreta(s)");
                //return;
            //}
    }

    
}
