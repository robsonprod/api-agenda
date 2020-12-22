package br.com.mobitbrasil.interview.domains;

import br.com.mobitbrasil.interview.enums.Uf;
import br.com.mobitbrasil.interview.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoDTO  implements Serializable {

    private final static long serialVersionUID = 1L;

    private String logradouro;

    private String bairro;

    private String cidade;

    @Max(value = 8, message = "Tamanho do cep maior que 8")
    private Integer cep;

    private String uf;

    public Endereco toEndereco() {
        return new Endereco(logradouro, bairro, cidade, cep, Uf.fromSigla(uf));
    }
}
