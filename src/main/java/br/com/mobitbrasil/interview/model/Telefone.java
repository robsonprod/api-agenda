package br.com.mobitbrasil.interview.model;

import br.com.mobitbrasil.interview.json.JsonHelper;
import com.google.gson.annotations.Expose;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "telefones")
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "seq_telefones", sequenceName = "seq_telefones", allocationSize = 1)
    @GeneratedValue(generator = "seq_telefones", strategy =GenerationType.SEQUENCE)
    @Expose(serialize = false)
    private Long id;

    @NotNull(message = "Informe o número do contato")
    @Column(precision = 11)
    private Long numero;

    @Override
    public String toString() {
        return JsonHelper.gson.toJson(this);
    }
}
