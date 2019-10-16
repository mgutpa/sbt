package com.sbt.util;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.Nullable;

public class Utility {

	public static String getLocaleMessage(String key, @Nullable Object[] params, Locale locale, MessageSource messageSource) {
		String message="";
		try {
			 message = messageSource.getMessage(key,params,LocaleContextHolder.getLocale());
		} catch (NoSuchMessageException e) {
			message = messageSource.getMessage(key,params,locale);
		}
		
		return message;
	}
}
