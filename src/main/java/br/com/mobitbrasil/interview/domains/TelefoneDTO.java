package br.com.mobitbrasil.interview.domains;


import br.com.mobitbrasil.interview.model.Telefone;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TelefoneDTO implements Serializable {

    private final static long serialVersionUID = 1L;

    @Length(max = 11, message = "Numero informado e invalido")
    @NotNull(message = "Numero deve ser informado")
    private Long numero;

    public Telefone toTelefone() {
        return new Telefone(null, numero);
    }

    public TelefoneDTO(Telefone telefone) {
        this.numero = telefone.getNumero();
    }
}
