package br.com.mobitbrasil.interview.domains;

import br.com.mobitbrasil.interview.model.Agenda;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
public class AgendaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    @NotEmpty(message = "Titulo vazio")
    @NotNull(message = "O titulo deve ser informado")
    private String titulo;

    public AgendaDTO(Agenda agenda) {
        this.id = agenda.getId();
        this.titulo = agenda.getTitulo();
    }

    public Agenda toAgenda() {
        return new Agenda(null, titulo, null);
    }
}
