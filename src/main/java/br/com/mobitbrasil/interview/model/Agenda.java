package br.com.mobitbrasil.interview.model;

import br.com.mobitbrasil.interview.json.JsonHelper;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "agendas")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonbPropertyOrder({"id", "titulo", "contatos"})
@NamedQueries({
        @NamedQuery(name = "Agenda.findAll", query = "SELECT e FROM Agenda e")
})
public class Agenda implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_agendas", sequenceName = "seq_agendas", allocationSize = 1)
    @GeneratedValue(generator = "seq_agendas", strategy =GenerationType.SEQUENCE)
    private Long id;

    @NotNull(message = "Informe o título da agenda")
    @NotEmpty(message = "O título não pode ser vazio")
    @Column(length = 100)
    private String titulo;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "agenda_id")
    @Fetch(FetchMode.JOIN)
    private List<Contato> contatos;

    @Override
    public String toString() {
        return JsonHelper.gson.toJson(this);
    }
}
