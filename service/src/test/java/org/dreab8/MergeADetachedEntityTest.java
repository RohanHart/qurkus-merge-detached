/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.dreab8;

import javax.ws.rs.core.MediaType;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.h2.H2DatabaseTestResource;
import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * @author Andrea Boriero
 */
@QuarkusTest
@QuarkusTestResource(H2DatabaseTestResource.class)
public class MergeADetachedEntityTest {
	private final static String expectedNameAfterMerge = "modified_name";
	private final static String expectedSurnameAfterMerge = "modified_surname";

	@Test
	public void testIt() {
		ResponseBody response = RestAssured.given().header( "Content-Type", MediaType.APPLICATION_JSON ).when().post(
				"/testentity/persist?name=original" ).body();

		Integer id = response.path( "id" );

		String json = "{\"id\":" + id +",\"surname\":\"" + expectedSurnameAfterMerge + "\",\"name\":\"" + expectedNameAfterMerge + "\"}";

		RestAssured.given().body( json ).header( "Content-Type", MediaType.APPLICATION_JSON ).when().post(
				"/testentity/merge" ).body();

		ResponseBody body = RestAssured.given().header( "Content-Type", MediaType.APPLICATION_JSON ).when().get( "/testentity/find?id=" + id ).body();

		assertThat( body.path( "id" ), is( 1 ) );
		assertThat( body.path( "name" ), is( expectedNameAfterMerge ) );
		assertThat( body.path( "surname" ), is( expectedSurnameAfterMerge ) );
	}

}
