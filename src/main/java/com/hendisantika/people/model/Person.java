package com.hendisantika.people.model;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-rest-api2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/10/21
 * Time: 06.55
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.UUID;

// maybe write a super short post on how to serialize but not deserialize fields - https://stackoverflow.com/questions/16019834/ignoring-property-when-deserializing
// json ignore doesn't really cut it here
@JsonIgnoreProperties(value = {"id"}, allowGetters = true)
public class Person {

    private UUID id;
    private String name;
    private int age;

    public Person(UUID id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
