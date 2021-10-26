package com.hendisantika.web;

import com.hendisantika.core.PersistenceException;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by IntelliJ IDEA.
 * Project : quarkus-rest-api2
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/10/21
 * Time: 06.53
 */
@Provider
public class PersistenceExceptionHandler implements ExceptionMapper<PersistenceException> {

    @Override
    public Response toResponse(PersistenceException exception) {
        return Response.serverError().build();
    }
}
