package org.ondetem.data.jpa;

import java.util.List;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.ondetem.data.MarkersFinder;
import org.ondetem.entities.Marker;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class JPAMarkersFinder extends BaseEntityFinder implements MarkersFinder{

    @SuppressWarnings("unchecked")
	@Override
    @Transactional(readOnly=true)
	public List<Marker> search(String query) {
    	FullTextEntityManager fullTextEntityManager = getFullTextEntityManager();
    	
		// create native Lucene query unsing the query DSL
		// alternatively you can write the Lucene query using the Lucene query parser
		// or the Lucene programmatic API. The Hibernate Search DSL is recommended though
		QueryBuilder qb = fullTextEntityManager.getSearchFactory()
		    .buildQueryBuilder().forEntity(Marker.class).get();
		org.apache.lucene.search.Query luceneQuery = qb
		  .keyword()
		  .fuzzy()
		  .onFields("label")
		  .matching(query)
		  .createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery =
		    fullTextEntityManager.createFullTextQuery(luceneQuery, Marker.class);
		
		// execute search
		return (List<Marker>)jpaQuery.getResultList();
	}

}
