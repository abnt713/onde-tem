package org.ondetem.data.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseEntityFinder {

	@Autowired
	private EntityManagerFactory entityManagerFactory;
	/** Hibernate Full Text Entity Manager. */
	private FullTextEntityManager ftem;

	public BaseEntityFinder() {
		super();
	}

	protected EntityManager getEntityManager() {
	    return getEntityManagerFactory().createEntityManager();
	}
	
	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}

	/**
	 * Method to manually update the Full Text Index. This is not required if inserting entities
	 * using this Manager as they will automatically be indexed. Useful though if you need to index
	 * data inserted using a different method (e.g. pre-existing data, or test data inserted via
	 * scripts or DbUnit).
	 * @throws InterruptedException 
	 */
	public void forceUpdateSearchIndexes() throws InterruptedException {
	    getFullTextEntityManager().createIndexer().startAndWait();
	}

	/**
	 * Convenience method to get Full Text Entity Manager. Protected scope to assist mocking in Unit
	 * Tests.
	 * @return Full Text Entity Manager.
	 */
	protected FullTextEntityManager getFullTextEntityManager() {
	    if (ftem == null) {
	        ftem = Search.getFullTextEntityManager(getEntityManager());
	        try {
				ftem.createIndexer().startAndWait();
			} catch (InterruptedException e) {//TODO: tratar exceção
				e.printStackTrace();
			}
	    }
	    return ftem;
	}
}