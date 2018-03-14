package com.library.hasanth.resources;


import java.util.Locale;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class ChangeLocale {
		private static String locale;

		public ChangeLocale() {
			locale="en";
			}
		public static String getLocale() {
			return locale;
			}
		public static void setLocale(String locale) {
			ChangeLocale.locale = locale;
		}
		public String changeLang(String loca){
			locale=loca;
			FacesContext.getCurrentInstance().getViewRoot().setLocale(new Locale(locale));
			return "";
		}
	
}
