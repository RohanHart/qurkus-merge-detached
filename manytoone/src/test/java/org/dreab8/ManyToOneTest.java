package org.dreab8;

import javax.ws.rs.core.MediaType;

import org.junit.jupiter.api.Test;

import org.jboss.logging.Logger;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Andrea Boriero
 */
@QuarkusTest
public class ManyToOneTest {
    private static final Logger log = Logger.getLogger( ManyToOneTest.class);

    @Test
    public void testRequestHasAnAssociatedClient() {
        log.info(">>> Creating User with Office and Client");
        ResponseBody responseBody = RestAssured.given().header( "Content-Type", MediaType.APPLICATION_JSON).when().post(
                "/manyToOne/create/user").body();
        log.info("User created <<<");

        Integer userId = responseBody.path("id");

        log.info(">>> Creating a Request associated with the created User");

        responseBody = RestAssured.given().when().post(
                "/manyToOne/create/request?userId=" + userId).body();

        log.info("Request created <<<");

        responseBody = RestAssured.given().header( "Content-Type", MediaType.APPLICATION_JSON).when().get(
                "/manyToOne/request/client?requestId=" + responseBody.asString() ).body();

        assertThat(responseBody.path("id"), not(nullValue()));
    }
}
