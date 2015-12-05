package org.ondetem.data.jpa;

import java.io.InputStream;

import org.dbunit.DBTestCase;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ondetem.data.MarkersFinder;
import org.ondetem.test.TestContextConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestContextConfiguration.class)
public class JPAMarkersFinderTest extends DBTestCase{

	/** Logger. */
    private static Logger LOG = LoggerFactory.getLogger(JPAMarkersFinderTest.class);

//    @Autowired
    private MarkersFinder markersFinder;
    @Autowired
//    private JPAMarkersDAO markersDAO;
    
    @Before
    public void setup() throws Exception {
//        DatabaseOperation.CLEAN_INSERT.execute(getDatabaseConnection(), getDataSet());
    }

    @After
    public void tearDown() {
//        deleteBooks();
    }

//    @Test
    public void verifyInjectedDependencies(){
    	Assert.assertNotNull(markersFinder);
//    	Assert.assertNotNull(markersDAO);
    }
    
    @Override
    protected IDataSet getDataSet() throws Exception {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("test-data-set.xml");
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        return builder.build(inputStream);
    }

    /**
     * Get the underlying database connection from the JPA Entity Manager (DBUnit needs this connection).
     * @return Database Connection
     * @throws Exception
     */
    private IDatabaseConnection getDatabaseConnection() throws Exception {
//        return new DatabaseConnection(((SessionImpl) (markersFinder.getEntityManager().getDelegate())).connection());
    	return null;
    }

    /**
     * Tests the expected results for searching for 'Space' in SCF-FI books.
     */
    @Test
    public void testSciFiBookSearch() throws Exception {

//        bookManager.listAllBooks();
//        bookManager.updateFullTextIndex();
//        List<Book> results = bookManager.search(BookCategory.SCIFI, "Space");
//
//        assertEquals("Expected 2 results for SCI FI search for 'Space'", 2, results.size());
//        assertEquals("Expected 1st result to be '2001: A Space Oddysey'", "2001: A Space Oddysey", results.get(0).getTitle());
//        assertEquals("Expected 2nd result to be 'Apollo 13'", "Apollo 13", results.get(1).getTitle());
    }

    private void deleteBooks() {
        LOG.info("Deleting Books...-");
//        bookManager.deleteAllBooks();
    }

}
