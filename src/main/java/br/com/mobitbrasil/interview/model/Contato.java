package br.com.mobitbrasil.interview.model;

import br.com.mobitbrasil.interview.json.JsonHelper;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "contatos")
@NamedQueries({
        @NamedQuery(
                name = "Contato.findByIdAndAgendaId",
                query = "SELECT e FROM Contato e WHERE e.agenda.id = :agendaId AND e.id = :id"
        ),
        @NamedQuery(
                name = "Contato.findAllByAgendaId",
                query = "SELECT e FROM Contato e WHERE e.agenda.id = :agendaId"
        )
})
public class Contato implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_contatos", sequenceName = "seq_contatos", allocationSize = 1)
    @GeneratedValue(generator = "seq_contatos", strategy = GenerationType.SEQUENCE)
    @Expose(serialize = false)
    private Long id;

    @Column(length = 100)
    private String nome;

    @SerializedName("sobrenome")
    @Column(name = "sobrenome", length = 100)
    private String sobreNome;
    
    @Column(length = 11)
    private String cpf;
    
    @Email
    @Column(length = 100)
    private String email;

    @Embedded
    @AttributeOverrides(value = {
            @AttributeOverride(name = "logradouro", column = @Column(name = "end_logradouro")),
            @AttributeOverride(name = "bairro", column = @Column(name = "end_bairro")),
            @AttributeOverride(name = "cep", column = @Column(name = "end_cep")),
            @AttributeOverride(name = "cidade", column = @Column(name = "end_cidade")),
            @AttributeOverride(name = "uf", column = @Column(name = "end_uf")),
    })
    private Endereco endereco;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "contato_id")
    @Fetch(FetchMode.JOIN)
    private List<Telefone> telefones;

    @ManyToOne(fetch = FetchType.LAZY)
    private Agenda agenda;

    @Override
    public String toString() {
        return JsonHelper.gson.toJson(this);
    }
}
