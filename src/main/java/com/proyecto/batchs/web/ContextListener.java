package com.proyecto.batchs.web;

import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.proyecto.batchs.util.Constantes;

public class ContextListener implements ServletContextListener {

	private static final Logger LOGGER = Logger.getLogger(ContextListener.class.getName());

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		InputStream strm = ContextListener.class.getClassLoader().getResourceAsStream(Constantes.LOG4J);
		Properties props = new Properties();
		try {
			props.load(strm);
			PropertyConfigurator.configure(props);
		} catch (Exception e) {
			LOGGER.error(e);
		} finally {
			if (strm != null) {
				try {
					strm.close();
				} catch (Exception e2) {
					LOGGER.error(e2);
				}
			}
		}

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
