package br.com.sast.util;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.text.MaskFormatter;

/**
 * Classe para métodos genéricos utilizados em todos os módulos.
 * 
 * @author vanessak
 * @since 1.0
 * @version 1.0, 28/10/14
 */
public final class Util {
	private Util(){}
	/**
	 * Metodo para limpar todos os campos de um Bean qualquer. Procura por metodos que comecem com 'set' e atribui valores padrao: 0, false ou null, conforme o caso.
	 * 
	 * @author Gabriel Ortiz
	 * @since 29/05/2006
	 * @param bean Objeto pojo.
	 */
	public static void limparBean(Object bean) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		short zeroShort = 0;
		char zeroChar = 0;
		byte zeroByte = 0;
		Method[] mets = bean.getClass().getMethods();
		for (Method m : mets) {
			if (m.getName().length() > 3 && "set".equals(m.getName().substring(0, 3))) {
				Class<?> parms[] = m.getParameterTypes();
				if (parms.length == 1) {
					Object[] args = new Object[1];
					String tipo = parms[0].toString();
					if ("boolean".equals(tipo)) {
						args[0] = false;
					} else if ("int".equals(tipo) || "float".equals(tipo) || "double".equals(tipo) || "long".equals(tipo)) {
						args[0] = 0;
					} else if ("short".equals(tipo)) {
						args[0] = zeroShort;
					} else if ("char".equals(tipo)) {
						args[0] = zeroChar;
					} else if ("byte".equals(tipo)) {
						args[0] = zeroByte;
					} else {
						args[0] = null;
					}
					
					m.invoke(bean, args);
				}
			}
		}
	}


	/**
	 * Remove a acentuacao e caracteres especias de uma String
	 * 
	 * @param str
	 * @return String
	 */
	public static String removeAcentuacao(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("[^\\p{ASCII}]", "");
		return str;
	}

	/**
	 * Verificar se número passado como parametro é null ou zero
	 * 
	 * @author Denis F. Gurski (projeto)
	 * @return boolean
	 */
	public static boolean isNullOrZero(Number numero) {
		return numero == null || numero.doubleValue() == 0.0;
	}
	
	/**
	 * Verificar se número passado como parametro não é null ou zero
	 * 
	 * @author Denis F. Gurski (projeto)
	 * @return boolean
	 */
	public static boolean isNotNullOrZero(Number numero) {
		return numero != null && numero.doubleValue() != 0.0;
	}
	
	/**
	 * Verificar se número passado como parametro é null
	 * @author Roberto.Claro (projeto)
	 * @return boolean
	 */
	public static boolean isNull(Object obj) {
		return obj == null;
	}

	/**
	 * Verificar se número passado como parametro não é null
	 * @author Roberto.Claro (projeto)
	 * @return boolean
	 */
	public static boolean isNotNull(Object obj) {
		return obj != null;
	}

	/**
	 * Verifica se uma string é vazia ou nula
	 * @author Denis F. Gurski (implementação)
	 * @param string
	 * @return boolean
	 */
	public static boolean isBlank(String string) {
		if (string != null) {
			return string.trim().isEmpty();
		}
		return true;
	}
	
	/**
	 * Verifica se uma string não é vazia ou não é nula
	 * @author Alailson
	 * @param string
	 * @return boolean
	 */
	public static boolean isNotBlank(String string) {
		return !isBlank(string);
	}
	
	/**
	 * Se uma string for null converte para string vazia.
	 * @author Alailson
	 * @param string
	 * @return string
	 */
	public static String desnullificarString(String string) {
		return isNotNull(string) ? string.trim() : "";
	}

	
	/**
	 * Retorna a diferenca em horas entre duas datas
	 * @param dataInicio
	 * @param dataFim
	 * @return {@link Integer}
	 */
	public static Double diferencaEmHoras(Date dataInicio, Date dataFim) {
		double result = 0;  
		long diferenca = dataFim.getTime() - dataInicio.getTime();  
		long diferencaEmHoras = (diferenca /1000) / 60 / 60;  
		long minutosRestantes = (diferenca / 1000)/60 %60;  
		double horasRestantes = minutosRestantes / 60d;  
		result = diferencaEmHoras + (horasRestantes);  
		
		return result; 
	}
	
	/**
	 * Retorna a diferenca em dias (inteiros) entre duas datas
	 * @param dataInicio
	 * @param dataFim
	 * @return {@link Integer}
	 */
	public static Integer diferencaEmDias(Date dataInicio, Date dataFim) {
		Double result = 0.0;  
		long diferenca = dataFim.getTime() - dataInicio.getTime();  
		long diferencaEmHoras = (diferenca /1000) / 60 / 60;  
		long minutosRestantes = (diferenca / 1000)/60 %60;  
		double horasRestantes = minutosRestantes / 60d;  
		result = (diferencaEmHoras + (horasRestantes))/24;  
		
		return result.intValue(); 
	}
	
	/**
	 * Verifica se o email é válido
	 * @param email
	 * @return
	 */
	public static boolean validarEmail(String email) {
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(email);
		if (m.find()) {
			return true;
		}
		return false;
	}

	/**
	 * Remove todos os caracteres exceto números
	 * @param string
	 * @return
	 */
	public static String soNumeros(String string) {
		if (!isBlank(string)) {
			string = string.replaceAll("[^0123456789]", "");
		}
		return string;
	}
	
	/**
	 * Retorna somente os caracteres especiais
	 * @param string
	 * @return
	 */
	public static String removerCaracteresEspeciais(String string) {
		if (!isBlank(string)) {
			string = TreatString.removerAcentos(string);
			string = string.replaceAll("\\W", "");
		}
		return string;
	}

	/**
	 * Formata um numero para a mascara (DDD) 9999-9999 ou (DDD) 99999-9999.<br>
	 */
	public static String formatarTelefone(Integer numero, Integer ddd) {
		StringBuffer telefone = new StringBuffer("");
		if (ddd != null && ddd > 0) {
			telefone.append("(");
			telefone.append(ddd.toString());
			telefone.append(") ");
		}
		if (numero != null && numero > 0) {
			telefone.append(formatarTelefone(numero.toString()));
		}
		return telefone.toString();
	}

	/**
	 * Formata um telefone para a mascara 9999-9999 ou 99999-9999.<br>
	 * @param String : numero do telefone sem DDD,se for nulo retorna vazio.
	 * @return String : numero do telefone formatado
	 */
	public static String formatarTelefone(String numero) {
		if (Util.isBlank(numero) || numero.length() > 9 || numero.length() < 8) {
			return "";
		}

		if (numero.contains("-")) {
			numero = numero.replace("-", "");
		}

		int qtdeDigito = (numero.length() == 9) ? 5 : 4;

		StringBuffer telefone = new StringBuffer();
		telefone.append(numero.substring(0, qtdeDigito));
		telefone.append("-");
		telefone.append(numero.substring(qtdeDigito));

		return telefone.toString();
	}
	
	/**
	 * Formata um telefone para a mascara (99) 9999-9999 ou (99) 99999-9999.<br>
	 * @param String : numero do telefone sem DDD,se for nulo retorna vazio.
	 * @return String : numero do telefone formatado
	 */
	public static String formatarTelefoneComDDD(String numero) {
		if (Util.isBlank(numero) || numero.length() > 11 || numero.length() < 8) {
			return "";
		}

		if (numero.contains("-")) {
			numero = numero.replace("-", "");
		}

		StringBuffer telefone = new StringBuffer();

		if(numero.length() >= 10){
			int qtdeDigito = (numero.length() == 9) ? 7 : 6;
	
			telefone.append("(");
			telefone.append(numero.substring(0, 2));
			telefone.append(") ");
			telefone.append(numero.substring(2, qtdeDigito));
			telefone.append("-");
			telefone.append(numero.substring(qtdeDigito));
		} else {
			int qtdeDigito = (numero.length() == 9) ? 5 : 4;

			telefone.append(numero.substring(0, qtdeDigito));
			telefone.append("-");
			telefone.append(numero.substring(qtdeDigito));
		}

		return telefone.toString();
	}

	/**
	 * Formata uma data de acordo com o padrão especificado.
	 * <pre>
	 * Exemplos de Padrao:
	 * "HH:mm"                   = 14:30
	 * "HH:mm:ss"                = 14:30:35
	 * "dd/MM/yyyy"              = 10/04/2008
	 * "dd/MM/yyyy HH:mm"        = 10/04/2008 14:30
	 * "dd 'de' MMMM 'de' yyyy"  = 07 de Abril de 2008
	 * "yyyy-MM-dd HH:mm:ss.SSS" = 2008-04-07 18:16:43.991
	 * </pre>
	 * @author Digam
	 * @since 05/04/2008
	 * @param Date
	 * @return String
	 */
	public static String formatarData(Date date, String padrao) {
		String data = "";
		if (date != null && isNotBlank(padrao)) {
			data = new SimpleDateFormat(padrao).format(date);
		}
		return data;
	}
	
	/**
	 * Retorna uma data de acordo com o padrão especificado.
	 * <pre>
	 * Exemplos de Padrao:
	 * "HH:mm"                   = 14:30
	 * "HH:mm:ss"                = 14:30:35
	 * "dd/MM/yyyy"              = 10/04/2008
	 * "dd/MM/yyyy HH:mm"        = 10/04/2008 14:30
	 * "dd 'de' MMMM 'de' yyyy"  = 07 de Abril de 2008
	 * "yyyy-MM-dd HH:mm:ss.SSS" = 2008-04-07 18:16:43.991
	 * </pre>
	 * 
	 * @author Alailson
	 * @since 09/10/2015
	 * @param date
	 * @param padrao
	 * @return Date
	 */
	public static Date parseStringToData(String date, String padrao) {
		if (date != null && isNotBlank(padrao)) {
			try {
				return new SimpleDateFormat(padrao).parse(date);
			} catch (ParseException e) {
			}
		}
		return null;
	}

	/**
	 * Compara se dois objetos são iguais
	 * @author Roberto G. Claro (projeto)
	 * @since 24/02/2015 (projeto)
	 * @author Roberto G. Claro (implementação)
	 * @since 24/02/2015 (implementação)
	 * @param o1
	 * @param o2
	 * @param tipo
	 * @return
	 * @rastreabilidade_requisito UCS_ManterOcorrenciaPreso
	 */
	public static boolean compararObjetos(Object o1, Object o2, Class<?> tipo){
		if(Util.isNull(o1) && Util.isNull(o2)){
			return true;
		} else if(Util.isNull(o1) && Util.isNotNull(o2)){
			return false;
		} else if(Util.isNotNull(o1) && Util.isNull(o2)){
			return false;
		}else{
			return tipo.cast(o1).equals(tipo.cast(o2));
		}
	}
	
	/**
	 * Verifica se o CPF passado é válido
	 * @author Roberto G. Claro (projeto)
	 * @since 09/03/2015 (projeto)
	 * @author Roberto G. Claro (implementação)
	 * @since 09/03/2015 (implementação)
	 * @param valor
	 * @return
	 * @rastreabilidade_requisito UCS_ManterOcorrenciaPreso
	 */
	public static boolean isCPFValid(String valor) {
		valor = Util.soNumeros(valor);
		if (Util.isBlank(valor) || valor.length() != 11) {
			return false;
		}
		String c = valor.substring(0, 9);
		String dv = valor.substring(9, 11);
		Integer d1 = 0;
		for (Integer i = 0; i < 9; i++) {
			d1 += Integer.parseInt("" + c.charAt(i)) * (10 - i);
		}
		
		if (d1 == 0) {
			return false;
		}
		d1 = 11 - (d1 % 11);
		if (d1 > 9) {
			d1 = 0;
		}
		if (Integer.parseInt("" + dv.charAt(0)) != d1) {
			return false;
		}
		d1 *= 2;
		for (Integer i = 0; i < 9; i++) {
			d1 += Integer.parseInt("" + c.charAt(i)) * (11 - i);
		}
		d1 = 11 - (d1 % 11);
		if (d1 > 9) {
			d1 = 0;
		}
		if (Integer.parseInt("" + dv.charAt(1)) != d1 || valor.equals("11111111111") || valor.equals("22222222222") || valor.equals("33333333333") || valor.equals("44444444444")
				|| valor.equals("55555555555") || valor.equals("66666666666") || valor.equals("77777777777") || valor.equals("88888888888") || valor.equals("99999999999")) {
			return false;
		}
		return true;
	}

	/**
	 * Verifica se o CNPJ passado é válido
	 * @author Roberto G. Claro (projeto)
	 * @since 09/03/2015 (projeto)
	 * @author Roberto G. Claro (implementação)
	 * @since 09/03/2015 (implementação)
	 * @param cnpj
	 * @return
	 * @rastreabilidade_requisito UCS_ManterOcorrenciaPreso
	 */
	public static boolean isCNPJValid(String cnpj) {
		if (cnpj == null) {
			return false;
		}
		cnpj = Util.soNumeros(cnpj);
		if (cnpj.length() < 14) {
			return false;
		}
		List<Integer> a = new ArrayList<Integer>();
		Integer b = 0;
		int[] c = new int[] { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
		for (int i = 0; i < 12; i++) {
			a.add(i, Integer.parseInt(cnpj.charAt(i) + ""));
			b += a.get(i) * c[i + 1];
		}
		int x = 0;
		if ((x = b % 11) < 2) {
			a.add(12, 0);
		} else {
			a.add(12, 11 - x);
		}
		b = 0;
		for (int y = 0; y < 13; y++) {
			b += (a.get(y) * c[y]);
		}
		if ((x = b % 11) < 2) {
			a.add(13, 0);
		} else {
			a.add(13, 11 - x);
		}
		if ((Integer.parseInt("" + cnpj.charAt(12)) != a.get(12).intValue()) || (Integer.parseInt("" + cnpj.charAt(13)) != a.get(13).intValue())) {
			return false;
		}
		return true;
	}

	/**
	 * Trata CNPJ passado, completa com 0 a esquerda ate 14 posicoes e filtra somente numeros
	 * @author Roberto G. Claro (projeto)
	 * @since 09/03/2015 (projeto)
	 * @author Roberto G. Claro (implementação)
	 * @since 09/03/2015 (implementação)
	 * @param cnpj
	 * @return
	 * @rastreabilidade_requisito UCS_ManterOcorrenciaPreso
	 */
	public static String escapeCNPJ(String cnpj) {
		cnpj = Util.soNumeros(cnpj);
		if (Util.isBlank(cnpj)) {
			return null;
		}
		return Util.completeZeroToLeft(cnpj, 14);
	}

	/**
	 *  Trata CPF passado, completa com 0 a esquerda ate 11 posicoes e filtra somente numeros
	 * @author Roberto G. Claro (projeto)
	 * @since 09/03/2015 (projeto)
	 * @author Roberto G. Claro (implementação)
	 * @since 09/03/2015 (implementação)
	 * @param cpf
	 * @return
	 * @rastreabilidade_requisito UCS_ManterOcorrenciaPreso
	 */
	public static String escapeCPF(String cpf) {
		cpf = Util.soNumeros(cpf);
		if (Util.isBlank(cpf)) {
			return null;
		}
		return Util.completeZeroToLeft(cpf, 11);
	}

	/**
	 * Completa o valor passado, colocando zero a esquerda.
	 *
	 * @author Roberto G. Claro (projeto)
	 * @since 09/03/2015 (projeto)
	 * @author Roberto G. Claro (implementação)
	 * @since 09/03/2015 (implementação)
	 * @param value - objeto que contem o valor a ser avaliado
	 * @param size - numero total de caracteres que o retorno deve ter
	 * @return String
	 * @rastreabilidade_requisito UCS_ManterOcorrenciaPreso
	 */
	public static String completeZeroToLeft(Object value, Integer size) {
		if (value == null || isBlank(value.toString())) {
			return null;
		}
		if (size.equals(value.toString().length())) {
			return value.toString();
		}
		StringBuilder sb = new StringBuilder(value.toString());
		while (sb.length() < size) {
			sb.insert(0, "0");
		}
		return sb.toString();
	}

	/**
	 * Formatar CPF
	 *
	 * @author Roberto G. Claro (projeto)
	 * @since 09/03/2015 (projeto)
	 * @author Roberto G. Claro (implementação)
	 * @since 09/03/2015 (implementação)
	 * @param cpf
	 * @return
	 * @rastreabilidade_requisito UCS_ManterOcorrenciaPreso
	 */
	public static String formatarCPF(String cpf) {
		cpf = Util.soNumeros(cpf);
		return formatString(cpf, "###.###.###-##");
	}
	
	/**
	 * Formatar CEP
	 * @since 30/09/2015 10:03:32
	 * @author Roberto G Claro <roberto.claro@sigma.com.br> (Projeto)
	 * @since 30/09/2015 10:03:32
	 * @author Roberto G Claro <roberto.claro@sigma.com.br>  (Implementação)
	 * @param cep :String
	 * @return 
	 * @rastreabilidade_requisito UCS_RegistrarFrequencia
	 */
	public static String formatarCEP(String cep) {
		cep = Util.soNumeros(cep);
		return formatString(cep, "##.###-###");
	}

	/**
	 * Formatar CNPJ
	 *
	 * @author Roberto G. Claro (projeto)
	 * @since 09/03/2015 (projeto)
	 * @author Roberto G. Claro (implementação)
	 * @since 09/03/2015 (implementação)
	 * @param cnpj
	 * @return
	 * @rastreabilidade_requisito UCS_ManterOcorrenciaPreso
	 */
	public static String formatarCNPJ(String cnpj) {
		cnpj = Util.soNumeros(cnpj);
		return formatString(cnpj, "##.###.###/####-##");
	}

	private static String formatString(String str, String mask) {
		if (str == null || str.trim().isEmpty()) {
			return "";
		}
		try {
			MaskFormatter mf = new MaskFormatter(mask);
			mf.setValueContainsLiteralCharacters(false);
			return mf.valueToString(str);
		} catch (ParseException e) {
			throw new RuntimeException("Erro ao formatar string. " + e.getMessage());
		}
	}

	/**
	 * Converte as Strings NULL de um DTO em "" (Vazia) a fim de tratar erros com XDocReport
	 *
	 * @author Roberto G. Claro (projeto)
	 * @since 20/03/2015 (projeto)
	 * @author Roberto G. Claro (implementação)
	 * @since 20/03/2015 (implementação)
	 * @param object
	 * @return void
	 * @rastreabilidade_requisito UCS_AutorizacaoPreso
	 */
	public static void converterNullEmVazia(Object object) {
		try {
			for(Field field : object.getClass().getDeclaredFields()) {
				if(String.class.equals(field.getType())) {
					boolean accessible = field.isAccessible();
					field.setAccessible(true);
					String valor = (String)field.get(object);
					if(valor == null) {
						field.set(object, "");
					}
					field.setAccessible(accessible);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Método responsável por ajustar o enconding
	 *
	 * @author Leonan Mattos - <leonan.mattos@sigma.com.br> (implementação)
	 * @since 24/07/2015
	 * @return
	 */
	public static String converterEncoding(String string, String encondingAtual, String novoEncoding) throws UnsupportedEncodingException {
		if (Util.isBlank(string) || Util.isBlank(encondingAtual) || Util.isBlank(novoEncoding)) {
			return "";
		}
		
		return new String(string.getBytes(encondingAtual), novoEncoding);
	}
	
	
	public static Date dataFim(Date data){
		if(Util.isNull(data)){
			return null;
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(data);
		
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		cal.set(Calendar.MILLISECOND, 59);
		return cal.getTime();
	}
	
	/**
	 * Formata Integer para Hora HH:mm
	 * @author Leonan Mattos - <leonan.mattos@sigma.com.br>
	 * @since 27/08/2015
	 * @param hora :Integer
	 * @return String
	 */
	public static String formatarHora(Integer hora) {
		if (Util.isNotNull(hora)) {
			StringBuilder strHora = new StringBuilder(hora.toString());
			if(strHora.length() == 4) {
				strHora = strHora.insert(strHora.length() - 2, ":");
			} else if (strHora.length() == 3) {
				strHora = strHora.insert(0, "0");
				strHora = strHora.insert(strHora.length() - 2, ":");
			}
			
			return strHora.toString();
		}
		
		return "";
	}
	
	/**
	 * Retorna <code>true</code> se todos as Strings(campos) estão vazios.
	 * 
	 * @author Alailson
	 * @since 13/10/2015
	 * @param campos
	 * @return <code>true</code> se todos os campos estão vazios.
	 */
	public static boolean validarCamposVazios(String ... campos) {
		boolean retorno = true;
		
		for(String campo: campos) {
			if(isNotBlank(campo)) {
				retorno = false;
			}
		}
		
		return retorno;
	}
	
	/**
	 * Valida o DDD informado
	 * @author eholiveira
	 * @since 06/11/2015
	 * @param ddd :String
	 * @return boolean
	 */
	public static boolean validarDDDTelefone(String ddd){
		if(Util.isBlank(ddd)){
			return false;
		}
		
		Integer num = Integer.parseInt(ddd);
		if(num < 11 || num > 99){
			return false;
		}
		return true;
	}
	
	/**
	 * Valida o telefone celular informado, se returnar TRUE
	 * @author eholiveira
	 * @since 06/11/2015
	 * @param telefone :String
	 * @return boolean
	 */
	public static boolean validarTelefoneCelular(String telefone){
		String t = soNumeros(telefone);
		if(Util.isBlank(t)){
			return false;
		}
		
		//DDD invalido
		if(!validarDDDTelefone(t.substring(0, 2))){
			return false;
		}
		
		Integer primeiroDigito = Integer.parseInt(t.charAt(2) + "");
		Integer ddd = Integer.parseInt(t.substring(0, 2));
		
		//Grupo de DDDs que já possuem o nono dígito
		if(((ddd >= 11 && ddd <= 28) || (ddd >= 31 && ddd <= 38) || (ddd >= 71 && ddd <= 79) || (ddd >= 81 && ddd <= 99)) ){
			if(t.length() != 11) {
				return false;
			} 
			if(primeiroDigito != 9){
				return false;
			}
		} 
		
		//Grupo de DDDs que NÃO possuem o nono dígito
		if(ddd >= 41 && ddd <= 69){
			if(t.length() != 10){
				return false;
			}
			if((primeiroDigito > 9 || primeiroDigito < 7)){
				return false;
			}
		} 
		
		return true;
	}
	
	/**
	 * Valida o telefone fixo informado
	 * @author eholiveira
	 * @since 06/11/2015
	 * @param telefone :String
	 * @return boolean
	 */
	public static boolean validarTelefoneFixo(String telefone){
		String t = soNumeros(telefone);
		if(Util.isBlank(t)){
			return true;
		}

		if(!validarDDDTelefone(t.substring(0, 2))){
			return false;
		}
		
		//tamanho invalido
		if(t.length() != 10){
			return false;
		}
		
		Integer primeiroDigito = Integer.parseInt(t.charAt(2) + ""); 
		if(primeiroDigito < 2 || primeiroDigito > 5){
			return false;
		}
		return true;
	}

	/**
	 * Retorna formatado o stackTrace, para auxiliar na resolução do mesmo.
	 * @author vanessak
	 * @since 11/12/2015
	 * @param e :Exception
	 * @return String
	 */
	public static String logarErro(Exception e) {
		StackTraceElement[] list = e.getStackTrace();
		StringBuffer erro = new StringBuffer();
		for (StackTraceElement stackTraceElement : list) {
			erro.append(stackTraceElement.toString());
			erro.append("\n");
		}
		return erro.toString();
	}
	
	/**
	 * 
	 * Deixa apenas os numeros na string
	 * @since 11/01/2016 13:30:32
	 * @author Yan Felipe de Souza <yan.felipe@sigma.com.br>(Projeto)
	 * @since 11/01/2016 13:30:32
	 * @author  (Implementação)
	 * @param value
	 * @return String
	 */
	
	public static final String filterOnlyNumber(String value) {
		if (isBlank(value)) {
			return null;
		}
		return value.replaceAll("\\D", "");
	}
	
	public static String formatarOrdemServico(String os) {
		return formatString(os, "##########/####");
	}
	
	/**
	 * Gera o dígito verificador de um RG do PR
	 * @author eholiveira
	 * @since 16/06/2016
	 * @param rg
	 * @return {@link Integer}
	 */
	public static Integer gerarRGDVPR(String rg){
		Integer digito = -1;
		Integer peso = 2;
		Integer soma = 0;
		
		for (int i = rg.length() - 1; i >= 0; --i) {
			if(peso > 7){
				peso = 2;
			}
			soma += (Integer.parseInt(rg.charAt(i) + "") * peso);
			peso++;
		}
		
		soma %= 11;
		if(11 - soma < 10){
			digito = 11 - soma;
		} else {
			digito = 0;
		}
		
		return digito;
	}
	
	/**
	 * Utilizado na comunicação com o mainframe
	 * @param value
	 * @param qtd
	 * @return {@link String}
	 */
	@Deprecated
	public static String tratarStringMainframe(String value, int qtd) {
		if (value == null || value.equals("null"))
			value = "";

		StringBuffer retorno = new StringBuffer();
		if (Util.checkIfNumber(value)) {
			if (value.length() >= qtd) {
				retorno.append(value.substring(0, qtd));
			} else {
				for (int i = value.length(); i < qtd; i++) {
					retorno.append("0");
				}
				retorno.append(value);
			}
		} else {
			if (value.length() >= qtd) {
				retorno.append(value.substring(0, qtd));
			} else {
				retorno.append(value);
				for (int i = value.length(); i < qtd; i++) {
					retorno.append(" ");
				}
			}
		}
		return retorno.toString();
	}
	
	/**
	 * Utilizado na comunicação com o mainframe <br>
	 * Remove e retorna uma parte de uma string 
	 * @param stringEntrada
	 * @param tamanho
	 * @return {@link String}
	 */
	@Deprecated
	public static String retornaValor(StringBuffer stringEntrada, int tamanho){
		String retorno = stringEntrada.substring(0, tamanho);
		stringEntrada.delete(0, tamanho);
		return retorno;
	}
	
	/**
	 * Converte um Date para uma String no formato repassado<br>
	 * @param data
	 * @param formato ("ddMMyyyy" ou "yyyyMMdd")
	 * @return
	 */
	@Deprecated
	public static String formataDataMainframe(java.util.Date data, String formato) {
		String strRetorno;
		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		if ((data != null))
			strRetorno = formatter.format(data); 
		else
			strRetorno = "";
		return strRetorno;  
	}
	
	/**
	 * Verifica se a string recebida é um numero
	 * @param in
	 * @return {@link Boolean}
	 */
	public static boolean checkIfNumber(String in) {
		try {
			Long.parseLong(in);
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
	
	/**
	 * Metodo responsavel por copiar o Arquivo fisico para o response
	 *
	 * @author Guilherme Pigosso Nunes <guilherme.nunes@sigma.com.br>
	 * @since 12/05/2015 17:37:32
	 * @param streamArquivo
	 * @param outputStream
	 * @throws Exception
	 */
	public static void copiarNioArquivo(InputStream streamArquivo, OutputStream outputStream) throws Exception {
		byte[] buffer = new byte[128 * 1024];
		try {
			for(int length = 0; (length = streamArquivo.read(buffer)) != -1;) {
				outputStream.write(buffer, 0, length);
			}
		} finally {
			streamArquivo.close();

			try {
				outputStream.flush();
			} catch (Exception e) {
				outputStream.close();
			}
		}
	}

	public static String obterNomeAnexo(String valor) {
		if (valor == null) {
			valor = "";
		}
		
		return valor.substring((valor.lastIndexOf("/") + 1), valor.lastIndexOf("."));
	}
	
}