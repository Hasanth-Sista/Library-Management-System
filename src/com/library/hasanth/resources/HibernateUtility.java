package com.library.hasanth.resources;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtility {


		private static final String CONFIGURATION_LOCATION = "com/library/hasanth/resources/hibernate.cfg.xml";
		private static SessionFactory sessionFactory = null;
		private static ServiceRegistry serviceRegistry;

		public static SessionFactory getSessionFactory() {
			return sessionFactory;
		}
		
		public synchronized static SessionFactory createSessionFactory() {
			if (sessionFactory == null) 
			{
				try {
					// Step1 : Loading the configuration details from
					// hibernate.cfg.xml
					Configuration configuration = new Configuration()
							.configure(CONFIGURATION_LOCATION);

					// Step2 : Creating ServiceRegistry using the
					// StandardServiceRegistryBuilder and Configuration defined in
					// Step 1
					serviceRegistry = new StandardServiceRegistryBuilder()
							.applySettings(configuration.getProperties()).build();

					// Step3 : Creating the SessionFactory using the Configuration
					// and serviceRegistry.
					sessionFactory = configuration
							.buildSessionFactory(serviceRegistry);
					
				} catch (Exception e) {
					LibraryLogger.logError("HibernateUtility",
							"createSessionFactory", e.getMessage());
						throw e;
				}
			}
			return sessionFactory;
		}
		public static void closeSessionFactory()
		{
			if(sessionFactory!=null)
			{
				sessionFactory.close();
				
			}
		}

	

}
