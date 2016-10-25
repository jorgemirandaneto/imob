package br.com.jlib.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class JLibConfig extends ResourceConfig {
	public JLibConfig(){
		packages("br.pro.delfino.drogaria.service");
	}
}
