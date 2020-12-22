package br.com.mobitbrasil.interview.services;

import br.com.mobitbrasil.interview.beans.AgendaBean;
import br.com.mobitbrasil.interview.domains.AgendaDTO;
import lombok.val;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/agendas")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class AgendaService {

    @EJB
    private AgendaBean agendaBean;

    @GET
    public Response index() {
        List<AgendaDTO> data = agendaBean.findAll()
                .stream()
                .map(AgendaDTO::new)
                .collect(Collectors.toList());

        return Response.ok(data).build();
    }

    @GET
    @Path("/{id}")
    public Response findById(@PathParam(value = "id") Long id) {

        val agenda = agendaBean.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Agenda não encontrada"));

        return Response.ok(agenda).build();
    }

    @POST
    public Response save(@Valid AgendaDTO agenda) {
        val result = agendaBean.save(agenda.toAgenda());
        return Response.ok(result).build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam(value = "id") Long id) {

        agendaBean.delete(id);

        return Response.ok().build();
    }
}
