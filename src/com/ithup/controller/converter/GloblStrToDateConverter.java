package com.ithup.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * S - source:
 * T - target:
 * @author ithup
 *
 */
public class GloblStrToDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
