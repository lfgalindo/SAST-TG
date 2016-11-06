package br.com.sast.util;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;

@Stateless
public class Relatorio {

	/**
	 * Gera o relatorio passado, o metodo ja adiciona parametros padroes para o projeto "logoParana" e "logoPolicia"
	 */
	public <T> byte[] gerarRelatorio(String nomeRelatorio, List<T> lista, Map<String, Object> parametros) {
		if(parametros == null) {
			parametros = new HashMap<String, Object>();
		}

		try(InputStream jasper = Relatorio.class.getResourceAsStream("/gov/pr/celepar/relatorio/jasper/" + nomeRelatorio);) {

			JRBeanCollectionDataSource beanDS = new JRBeanCollectionDataSource(lista);
			JasperPrint print = JasperFillManager.fillReport(jasper, parametros, beanDS);

			return JasperExportManager.exportReportToPdf(print);
		} catch (Exception e) {
			throw new RuntimeException("Falha gerar relatorio", e);
		}
	}

	public <T> byte[] gerarRelatorioXLSL(String nomeRelatorio, List<T> lista, String[] sheetNames, Map<String, Object> parametros) {
		if(parametros == null) {
			parametros = new HashMap<String, Object>();
		}

		try(InputStream jasper = Relatorio.class.getResourceAsStream("/gov/pr/celepar/relatorio/jasper/" + nomeRelatorio);) {

			JRBeanCollectionDataSource beanDS = new JRBeanCollectionDataSource(lista);

			JasperPrint print = JasperFillManager.fillReport(jasper, parametros, beanDS);

			SimpleXlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
			configuration.setOnePagePerSheet(true);
			configuration.setDetectCellType(true);
			configuration.setCollapseRowSpan(false);

			if(sheetNames != null) {
				configuration.setSheetNames(sheetNames);
			}

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			JRXlsExporter exporter = new JRXlsExporter();
			exporter.setExporterInput(new SimpleExporterInput(print));
			exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(baos));
			exporter.setConfiguration(configuration);

			exporter.exportReport();

			return baos.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException("Falha gerar relatorio", e);
		}
	}
}
