package com.tarea.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.tarea.entidades.Cliente;
import com.tarea.entidades.Pais;






public class Main {
	static final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
			.configure() // configures settings from hibernate.cfg.xml
			.build();
	
	static SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
	
	private static EntityManagerFactory emf= Persistence.createEntityManagerFactory("Persistencia");

	public static void main(String[] args) {
		Pais pais= new Pais("Ecuador");
		ingresarPais(pais);
		
		Cliente persona= new Cliente("Brayn","Villa","CEde�o",pais);
		ingresarPersona(persona);
		
		
		
		

		
	}
	static void ingresarPersona(Cliente persona) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(persona);
		session.getTransaction().commit();
		session.close();
	}
	
	static void ingresarPais(Pais pais) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(pais);
		session.getTransaction().commit();
		session.close();

	}
	
	static void imprimirDatos() {
		EntityManager em= emf.createEntityManager();
		Pais pais=em.find(Pais.class, 1);
		
	}
	
	
}