package br.com.sast.bean;

/**
 * Classe definida para controlar a comunição entre a classe ClienteDAO e sua
 * Interface Web
 *
 * @author Luís Guilherme Fernandes Ferreira <guihms1@gmail.com>
 * @since Classe criada em 25/10/2016
 */
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;
import br.com.sast.dao.ClienteDAO;
import br.com.sast.dao.PerfilDAO;
import br.com.sast.domain.Cliente;
import br.com.sast.domain.Perfil;
import br.com.sast.util.TreatDate;
import br.com.sast.util.TreatString;
import br.com.sast.util.Util;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import org.omnifaces.util.Faces;

@ManagedBean
@ViewScoped
public class ClienteBean {

    private final Integer codigoCliente = 3;

    private Cliente cliente;
    private List<Cliente> clientes;
    private Integer codigo;
    private Date dataAtual;

    //Chaves estrangeiras
    private List<Perfil> perfis;

    //GETS & SETS
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public List<Perfil> getPerfis() {
        return perfis;
    }

    public void setPerfis(List<Perfil> perfis) {
        this.perfis = perfis;
    }
    
    public Date getDataAtual() {
        return dataAtual;
    }

    public void setDataAtual(Date dataAtual) {
        this.dataAtual = dataAtual;
    }

    //MÉTODOS CRUD
    //método que prepara a tela para inserir novo registro.
    public void novo() {
        
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -15);
        
        setDataAtual(calendar.getTime());

        cliente = new Cliente();

        ClienteDAO clienteDAO = new ClienteDAO();

        //chave estrangeira.
        PerfilDAO perfilDAO = new PerfilDAO();

        clientes = clienteDAO.listar();

        //chave estrangeira.
        perfis = perfilDAO.listar();

    }//fim do método novo

    //método para inserir um novo registro no banco.
    public void salvar() throws ParseException {
        Boolean salvar = Boolean.TRUE;

        if (!Util.isCPFValid(getCliente().getCpf())) {
            getCliente().setCpf("");
            Messages.addGlobalWarn("CPF inválido!");
            salvar = Boolean.FALSE;
        }
        if (!TreatString.isEmailValid(getCliente().getEmail())) {
            getCliente().setEmail("");
            Messages.addGlobalWarn("E-mail inválido!");
            salvar = Boolean.FALSE;
        }
       
        if (salvar) {

            PerfilDAO perfilDAO = new PerfilDAO();

            getCliente().setCodigoPerfil(perfilDAO.buscar(codigoCliente));
            
            ClienteDAO clienteDAO = new ClienteDAO();
            clienteDAO.inserir(cliente);

            Messages.addGlobalInfo("Cliente inserido com sucesso!");

            novo();
        }
    }//fim do método salvar

    //método para listar todos os registros do banco.
    public void listar() {

        ClienteDAO clienteDAO = new ClienteDAO();
        clientes = clienteDAO.listar();

    }//fim do método listar.

    //método para buscar um registro específico no banco.
    public void buscar() {

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -15);
        
        setDataAtual(calendar.getTime());
        
        ClienteDAO clienteDAO = new ClienteDAO();
        cliente = clienteDAO.consultar(codigo);
        
        cliente.setSenha("");
        
        PerfilDAO perfilDAO = new PerfilDAO();
        perfis = perfilDAO.listar();

    }//fim do método buscar

    //método para editar um registro específico no banco.
    public void editar() {
        
         Boolean salvar = Boolean.TRUE;

        if (!Util.isCPFValid(getCliente().getCpf())) {
            getCliente().setCpf("");
            Messages.addGlobalWarn("CPF inválido!");
            salvar = Boolean.FALSE;
        }
        if (!TreatString.isEmailValid(getCliente().getEmail())) {
            getCliente().setEmail("");
            Messages.addGlobalWarn("E-mail inválido!");
            salvar = Boolean.FALSE;
        }
       
        if (salvar) {

            PerfilDAO perfilDAO = new PerfilDAO();

            getCliente().setCodigoPerfil(perfilDAO.buscar(codigoCliente));
        
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.editar(cliente);
        
        Messages.addGlobalInfo("Cliente editado com sucesso!");
        buscar();
        }
    }//fim do método editar

    //método para excluir um registro específico no banco.
    public void excluir() {

        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.excluir(cliente);

        Messages.addGlobalInfo("Cliente deletado com sucesso!");

        try {
            Faces.redirect("clienteListar.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(PerfilBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//fim do método excluir

}
