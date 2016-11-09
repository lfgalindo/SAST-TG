/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sast.bean;

import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.PlanoClienteDAO;
import br.com.sast.domain.Cliente;
import br.com.sast.domain.PlanoCliente;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.com.sast.dao.PlanoDAO;
import br.com.sast.domain.Plano;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.omnifaces.util.Faces;

/**
 * Classe definida para controlar a comunição entre a classe ClienteDAO e sua
 * Interface Web
 *
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since Classe criada em 03/11/2016
 */
@ManagedBean
@ViewScoped
public class PlanoClienteBean {

    private PlanoCliente planocliente;
    private List<PlanoCliente> planoclientes;
    private Integer codigo;
    private Integer codCli;

    //chaves estrangeiras
    private List<Plano> planos;
    private List<Cliente> clientes;

    //método que prepara a tela para inserir novo registro.
    public void novo() {

        planocliente = new PlanoCliente();

        PlanoClienteDAO planoclienteDAO = new PlanoClienteDAO();
        planoclientes = planoclienteDAO.listar();

        //chave estrangeira.
        PlanoDAO planoDAO = new PlanoDAO();

        ClienteDAO clienteDAO = new ClienteDAO();
        getPlanocliente().setCodigoCliente(clienteDAO.consultar(codCli));

        //chave estrangeira.
        planos = planoDAO.listar();
        clientes = clienteDAO.listar();

    }//fim do método novo

    //MÉTODOS CRUD
    //método para inserir um novo registro no banco.
    public void salvar() {

        PlanoClienteDAO planoclienteDAO = new PlanoClienteDAO();
        ClienteDAO clienteDAO = new ClienteDAO();
        planocliente.setCodigoCliente(clienteDAO.consultar(codCli));
        planoclienteDAO.inserir(planocliente);

        Messages.addGlobalInfo("Atribuição de plano inserida com sucesso!");

        novo();

    }//fim do método salvar

    //método para listar todos os registros do banco.
    public void listar() {

        PlanoClienteDAO planoclienteDAO = new PlanoClienteDAO();
        planoclientes = planoclienteDAO.listar();

    }//fim do método listar.

    public void listarPlanCli() {

        PlanoClienteDAO planoclienteDAO = new PlanoClienteDAO();
        planoclientes = planoclienteDAO.listarPlanCli(codCli);

    }//fim do método listar.

    //método para buscar um registro específico no banco.
    public void buscar() {

        PlanoClienteDAO planoclienteDAO = new PlanoClienteDAO();
        planocliente = planoclienteDAO.consultar(codigo);

        PlanoDAO planoDAO = new PlanoDAO();
        planos = planoDAO.listar();

        ClienteDAO clienteDAO = new ClienteDAO();
        clientes = clienteDAO.listar();

    }//fim do método buscar

    //método para editar um registro específico no banco.
    public void editar() {

        PlanoDAO planoDAO = new PlanoDAO();
        planos = planoDAO.listar();

        PlanoClienteDAO planoclienteDAO = new PlanoClienteDAO();
        planoclienteDAO.editar(planocliente);

        Messages.addGlobalInfo("Atribuição de plano editada com sucesso!");
        buscar();

    }//fim do método editar

    //método para excluir um registro específico no banco.
    public void excluir() {

        PlanoClienteDAO planoclienteDAO = new PlanoClienteDAO();
        planoclienteDAO.excluir(planocliente);

        Messages.addGlobalInfo("Atribuição de plano deletada com sucesso!");

        try {
            Faces.redirect("clienteListar.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//fim do método excluir

    //GETS & SETS
    public Integer getCodCli() {
        return codCli;
    }

    public void setCodCli(Integer codCli) {
        this.codCli = codCli;
    }

    public PlanoCliente getPlanocliente() {
        return planocliente;
    }

    public void setPlanocliente(PlanoCliente planocliente) {
        this.planocliente = planocliente;
    }

    public List<PlanoCliente> getPlanoclientes() {
        return planoclientes;
    }

    public void setPlanoclientes(List<PlanoCliente> planoclientes) {
        this.planoclientes = planoclientes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Plano> getPlanos() {
        return planos;
    }

    public void setPlanos(List<Plano> planos) {
        this.planos = planos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}
