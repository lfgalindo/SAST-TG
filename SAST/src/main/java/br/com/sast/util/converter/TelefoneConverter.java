package br.com.sast.util.converter;

import br.com.sast.util.Util;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter(value="telefoneConverter")
public class TelefoneConverter implements Converter {

	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) throws ConverterException {
		return arg2;
	}

	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) throws ConverterException {
		if(arg2 == null){
			return "";
		}
		return Util.formatarTelefoneComDDD(arg2.toString());
	}
}