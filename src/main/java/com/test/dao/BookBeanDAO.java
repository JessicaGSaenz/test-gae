package com.test.dao;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.googlecode.objectify.ObjectifyService;
import com.test.data.BookBean;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class BookBeanDAO {

    private static final Logger LOGGER = Logger.getLogger(BookBeanDAO.class.getName());

    /**
     * @return list of books beans
     */
    public List<BookBean> list() {
    	
        LOGGER.info("Retrieving list of beans");
        return ObjectifyService.ofy().load().type(BookBean.class).order("author").list();
        
    }

    /**
     * @param id
     * @return book bean with given id
     */
    public BookBean get(Long id) {
    	
        LOGGER.info("Retrieving bean " + id);
        return ObjectifyService.ofy().load().type(BookBean.class).id(id).now();
        
    }

    /**
     * Saves given bean
     * @param bean
     */
    public void save(BookBean bean) {
    	
        if (bean == null) {
            throw new IllegalArgumentException("null book object");
        }
        
        LOGGER.info("Saving bean " + bean.getName());
        //ObjectifyService.ofy().save().entity(bean).now();
        DatastoreService db = DatastoreServiceFactory.getDatastoreService();
        db.put(new Entity("p2", 2007));
        
    }

    /**
     * Deletes given bean
     * @param bean
     */
    public void delete(BookBean bean) {
        
    	if (bean == null) {
            throw new IllegalArgumentException("null book object");
        }
    	
        LOGGER.info("Deleting bean " + bean.getId());
        ObjectifyService.ofy().delete().entity(bean);
        
    }

    /**
     * Search given bean
     * @param text
     * @return
     */
	public List<BookBean> search(String text) {
		
		LOGGER.info("Retrieving bean " + text);
		List<BookBean> totalBooks = ObjectifyService.ofy().load().type(BookBean.class).list();
		
        return totalBooks.stream()
        				.filter(bo -> bo.toSearch().toUpperCase().contains(text.toUpperCase()))
        				.collect(Collectors.toList());
        
	}
}
