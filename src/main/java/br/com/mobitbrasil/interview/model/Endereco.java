package br.com.mobitbrasil.interview.model;

import javax.persistence.*;
import javax.validation.constraints.Max;

import br.com.mobitbrasil.interview.enums.Uf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class Endereco {

	@Column(length = 200)
	private String logradouro;

	@Column(length = 100)
	private String bairro;

	@Column(length = 100)
	private String cidade;

	@Max(value = 8, message = "Tamanho do cep maior que 8")
	@Column(precision = 8)
	private Integer cep;

	@Enumerated(EnumType.STRING)
	private Uf uf;
}
