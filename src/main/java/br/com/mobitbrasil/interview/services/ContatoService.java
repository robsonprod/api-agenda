package br.com.mobitbrasil.interview.services;

import br.com.mobitbrasil.interview.beans.AgendaBean;
import br.com.mobitbrasil.interview.beans.ContatoBean;
import br.com.mobitbrasil.interview.domains.ContatoDTO;
import lombok.val;

import javax.ejb.EJB;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import static com.sun.mail.iap.Response.OK;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/contatos")
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class ContatoService {

    @EJB
    private AgendaBean agendaBean;
    @EJB
    private ContatoBean contatoBean;

	@GET
    @Path("/{agendaId}")
    public Response index(@PathParam(value = "agendaId") Long agendaId) {

	    val results = contatoBean.findAllByAgendaId(agendaId)
                .stream()
                .map(ContatoDTO::new)
                .collect(Collectors.toList());

		return Response.ok(results).build();
    }
	
	@POST
    @Path("/{agendaId}")
    public Response add(@Valid ContatoDTO contatoDTO, @PathParam(value = "agendaId") Long agendaId) {

	    val agenda = agendaBean.findById(agendaId)
                .orElseThrow(() -> new IllegalArgumentException("Agenda não encontrada"));

        if (Objects.isNull(agenda.getContatos())) agenda.setContatos(new ArrayList<>());

        agenda.getContatos().add(contatoDTO.toContato());
        agendaBean.update(agenda);

        return Response.ok(contatoDTO).build();
    }
	
	@PUT
    public Response update() {

        return Response.status(OK)
                .type(APPLICATION_JSON)
                .entity("{value: \"Update\"}").build();
    }
	
	@DELETE
    @Path("/{id}")
    public Response remove(@PathParam(value = "id") Long id) {

        return Response.status(OK)
                .type(APPLICATION_JSON)
                .entity("{value: \"Remove\"}").build();
    }

}
