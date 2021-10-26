package com.hendisantika.people.web;

import java.util.UUID;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-rest-api2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/10/21
 * Time: 06.58
 */
public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(UUID id) {
        super("Person with " + id.toString() + " does not exist!");
    }
}
