package br.com.mobitbrasil.interview.providers;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;

@Provider
public class ExceptionMapperProvider implements ExceptionMapper<ConstraintViolationException> {

    @Override
    public Response toResponse(ConstraintViolationException e) {
        return Response.status(BAD_REQUEST)
                .entity(HandlerExceptionProvider.prepareMessage(e))
                .type(MediaType.APPLICATION_JSON_TYPE)
                .build();
    }
}
