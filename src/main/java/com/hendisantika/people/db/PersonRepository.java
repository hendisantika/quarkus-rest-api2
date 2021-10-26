package com.hendisantika.people.db;

import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-rest-api2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/10/21
 * Time: 06.54
 */
@ApplicationScoped
// @Singleton
public class PersonRepository {

    private static final String FIND_ALL = "SELECT * FROM people";
    private static final String FIND_ALL_BY_ID = "SELECT * FROM people WHERE id = ?";
    private static final String INSERT = "INSERT INTO people (id, name, age) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE people SET name = ?, age = ? WHERE id = ?";
    private static final String DELETE = "DELETE FROM people WHERE id = ?";

    private final DataSource dataSource;
}
