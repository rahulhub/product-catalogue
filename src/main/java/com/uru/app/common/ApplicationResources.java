package com.uru.app.common;

import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Girish.Yadav
 * 
 */
@ManagedBean
@ApplicationScoped
public class ApplicationResources {

	@Produces
	@MySQLURUDatabase
	@PersistenceContext(unitName = "urudb")
	private EntityManager em;


}
