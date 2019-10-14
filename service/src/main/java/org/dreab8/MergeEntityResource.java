/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.dreab8;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * @author Andrea Boriero
 */

@Path("/testentity")
@ApplicationScoped
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MergeEntityResource {

	@Inject
	TestEntityService service;

	@POST
	@Path("/merge")
	public void merge(TestEntity testEntity) {
		service.merge( testEntity );
	}

	@GET
	@Path("/find")
	public TestEntity find(@QueryParam("id") Long id) {
		return service.find( id );
	}

	@POST
	@Path("/persist")
	public TestEntity persist(@QueryParam("name") String name) {
		return service.persist( name );
	}
}
