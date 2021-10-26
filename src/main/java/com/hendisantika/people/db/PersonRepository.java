package com.hendisantika.people.db;

import com.hendisantika.core.db.PersistenceException;
import com.hendisantika.people.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    public PersonRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Person> findAll() {
        List<Person> result = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(FIND_ALL);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                result.add(
                        new Person(
                                UUID.fromString(resultSet.getString("id")),
                                resultSet.getString("name"),
                                resultSet.getInt("age")));
            }
        } catch (SQLException e) {
            throw new PersistenceException("boom", e.getCause());
        }
        return result;
    }
}
