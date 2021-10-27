package com.hendisantika;

import com.hendisantika.people.model.Person;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-rest-api2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/10/21
 * Time: 07.01
 */
@QuarkusTest
public class PersonResourceTest {

    @Test
    @Disabled
    public void testPostAndGet() {
        // test doesn't really work since its connecting to the postgres container im running
        Person person = new Person(UUID.randomUUID(), "naruto", 26);
        given()
                .when()
                .contentType(ContentType.JSON)
                .body(person)
                .post("/people")
                .then()
                .statusCode(200);
        Person fromResponse = given().when().get("/people").then().statusCode(200).extract().as(Person.class);
        assertNotEquals(person.getId(), fromResponse.getId());
        assertEquals(person.getName(), fromResponse.getName());
        assertEquals(person.getAge(), fromResponse.getAge());
    }
}
