package br.com.mobitbrasil.interview.domains;

import br.com.mobitbrasil.interview.model.Contato;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ContatoDTO implements Serializable {

    private final static long serialVersionUID = 1L;

    private Long id;

    @NotNull(message = "Nome não informado")
    @NotEmpty(message = "Nome não deve ser vazio")
    @Size(max = 100, message = "Nome só pode ter até 100 caracteres")
    private String nome;

    @NotNull(message = "Sobrenome não informado")
    @NotEmpty(message = "Sobrenome não deve ser vazio")
    @Size(max = 100, message = "Sobrenome só pode ter até 100 caracteres")
    private String sobrenome;

    @NotNull(message = "CPF não informado")
    @NotEmpty(message = "CPF não deve ser vazio")
    @Length(min = 11, max = 11, message = "Tamanho do CPF superior a 11 posições")
    private String cpf;

    @NotNull(message = "E-mail não informado")
    @NotEmpty(message = "E-mail não deve ser vazio")
    @Email
    private String email;

    private EnderecoDTO endereco;

    private List<TelefoneDTO> telefones;

    public ContatoDTO(Contato contato) {
        this.id = contato.getId();
        this.cpf = contato.getCpf();
        this.email = contato.getEmail();
        this.nome = contato.getNome();
        this.sobrenome = contato.getSobreNome();

        if (Objects.nonNull(contato.getTelefones())) {
            this.telefones = contato.getTelefones().stream().map(TelefoneDTO::new).collect(Collectors.toList());
        }

        if (Objects.nonNull(contato.getEndereco())) {
            val uf = (Objects.nonNull(contato.getEndereco().getUf()))
                    ? contato.getEndereco().getUf().sigla()
                    : null;

            this.endereco = new EnderecoDTO(
                    contato.getEndereco().getLogradouro(),
                    contato.getEndereco().getBairro(),
                    contato.getEndereco().getCidade(),
                    contato.getEndereco().getCep(),
                    uf
            );
        }
    }

    public Contato toContato() {
        val telefones = Objects.nonNull(this.telefones)
                ? this.telefones.stream().map(TelefoneDTO::toTelefone).collect(Collectors.toList())
                : null;

        return new Contato(null, nome, sobrenome, cpf, email, endereco.toEndereco(), telefones, null);
    }
}
