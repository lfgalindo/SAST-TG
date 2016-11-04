package br.com.sast.util;

import java.io.Serializable;
import javax.faces.application.FacesMessage;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;
import org.omnifaces.util.Messages;
import org.omnifaces.util.Messages.Message;

import org.primefaces.component.datatable.DataTable;



@Named
@ManagedBean
@ApplicationScoped
public class DataTableUtil implements Serializable {

	private static final long serialVersionUID = 2599154038390984756L;
	public final static int QTDE_REGISTROS_PAGINA = 15;
	public final static int QTDE_REGISTROS_PAGINA_MODAL = 5;

	private DataTable dataTable;

	private DataTable lazyDataTable;
	
	private DataTable modaLazyDataTable;

	/**
	 * Retorna um datable simples (sem lazy loading) com as configurações definidas para o sistema.
	 *
	 * @param dataTable
	 */
	public DataTable getDataTable() {
		return dataTable;
	}

	/**
	 * Configura um datable simples (sem lazy loading) com as configurações definidas para o sistema.
	 *
	 * @param dataTable
	 */
	public void setDataTable(DataTable dataTable) {
		dataTable.setLazy(false);
		configurarDataTable(dataTable);
	}

	/**
	 * Retorna um datable com lazy loading e as configurações definidas para o sistema.
	 *
	 * @return DataTable
	 */
	public DataTable getLazyDataTable() {
		return lazyDataTable;
	}

	/**
	 * Configura um datable com lazy loading e as configurações definidas para o sistema.
	 *
	 * @param dataTable
	 */
	public void setLazyDataTable(DataTable lazyDataTable) {
		lazyDataTable.setLazy(true);
		configurarDataTable(lazyDataTable);
	}

	public DataTable getModaLazyDataTable() {
		return modaLazyDataTable;
	}

	public void setModaLazyDataTable(DataTable modaLazyDataTable) {
		modaLazyDataTable.setLazy(true);
		configurarDataTable(modaLazyDataTable);
		modaLazyDataTable.setRows(QTDE_REGISTROS_PAGINA_MODAL);
	}

	private void configurarDataTable(DataTable dataTable) {
		dataTable.setPaginator(true);
		dataTable.setRows(QTDE_REGISTROS_PAGINA);
		dataTable.setPaginatorAlwaysVisible(false);
		dataTable.setReflow(false);
		dataTable.setCurrentPageReportTemplate("{currentPage} de {totalPages} ");
		dataTable.setPaginatorTemplate("{CurrentPageReport} {FirstPageLink} {PreviousPageLink} {PageLinks} {NextPageLink} {LastPageLink}");
                
	}
}
