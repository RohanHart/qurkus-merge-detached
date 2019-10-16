package org.dreab8.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.dreab8.model.Client;
import org.dreab8.model.Office;
import org.dreab8.model.Request;
import org.dreab8.model.User;

/**
 * @author Andrea Boriero
 */
@Path("/manyToOne")
@ApplicationScoped

public class ManyToOneResource {

	@Inject
	EntityManager em;

	@POST
	@Path("/create/request")
	@Transactional
	public Long createRequest(@QueryParam("userId") Long userId) {
		User user = em.find( User.class, userId );
		Request request = new Request();
		request.setUser( user );
		em.persist( request );
		return request.getId();
	}

	@POST
	@Path("/create/user")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public User createUser() {
		User user = new User();
		Office office = new Office();
		Client client = new Client();
		office.setClient( client );
		user.setOffice( office );
		em.persist( client );
		em.persist( office );
		em.persist( user );
		return user;
	}

	@GET
	@Path("/request/client")
	@Transactional
	@Produces(MediaType.APPLICATION_JSON)
	public Client getkRequestClientId(@QueryParam("requestId") Long requestId) {
		Request request = em.find( Request.class, requestId );
		Client client = request.getUser().getOffice().getClient();
		return client;
	}
}
