package com.test.rest;

import com.google.appengine.tools.remoteapi.RemoteApiInstaller;
import com.google.appengine.tools.remoteapi.RemoteApiOptions;
import com.test.dao.BookBeanDAO;
import com.test.data.BookBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/book")
@Produces("application/json;charset=utf-8")
@Api(value = "book", description = "Book service")
public class BookResource {

    private BookBeanDAO bookBeanDAO;
    
    public BookResource() {
    	
        this.bookBeanDAO = new BookBeanDAO();
        
    }

    @GET
    @ApiOperation("list books")
    public Response list() {
    	
        return Response.ok(this.bookBeanDAO.list()).build();
        
    }

    @GET
    @Path("/{id}")
    @ApiOperation("get book object")
    public Response get(@PathParam("id") Long id) {
    	
        BookBean bean = this.bookBeanDAO.get(id);
        
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        
        return Response.ok(bean).build();
        
    }

    @POST
    @Consumes("application/json;charset=utf-8")
    @ApiOperation("save book object")
    public Response save(BookBean bean) {
       
    	//Conectar con datastore remote
    	/*RemoteApiOptions options = new RemoteApiOptions()
        	    .server("https://caramel-caster-231015.appspot.com/", 443)
        	    .useApplicationDefaultCredential();
    	
    	RemoteApiInstaller installer = new RemoteApiInstaller();
    	
    	try {
			
    		installer.install(options);
    		
		} catch (IOException e) {
			
			e.printStackTrace();
			
		}*/
    	
    	this.bookBeanDAO.save(bean);
        return Response.ok().build();
        
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("delete book object")
    public Response delete(@PathParam("id") Long id) {
    	
    	BookBean bean = this.bookBeanDAO.get(id);
        
    	if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    	
        this.bookBeanDAO.delete(bean);
        return Response.ok().build();
        
    }
    
    @GET
    @Path("/searchBook/{text}")
    @ApiOperation("search book objetc")
    public Response search(@PathParam("text") String text) {
    	
    	return Response.ok(this.bookBeanDAO.search(text)).build();
    	
    }
    
}
