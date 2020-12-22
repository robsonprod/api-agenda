package br.com.mobitbrasil.interview.enums;

public enum Uf {
	
	AM("Amazonas", "AM", "Manaus"),
	AL("Alagoas", "AL", "Maceió"),
	AC("Acre", "AC", "Rio Branco"),
	AP("Amapá", "AP", "Macapá"),
	BA("Bahia", "BA", "Salvador"),
	PA("Pará", "PA", "Belém"),
	MT("Mato Grosso", "MT", "Cuiabá"),
	MG("Minas Gerais", "MG", "Belo Horizonte"),
	MS("Mato Grosso do Sul", "MS", "Campo Grande"),
	GO("Goiás", "GO", "Goiânia"),
	MA("Maranhão", "MA", "São Luís"),
	RS("Rio Grande do Sul", "RS", "Porto Alegre"),
	TO("Tocantins", "TO", "Palmas"),
	PI("Piauí", "PI", "Teresina"),
	SP("São Paulo", "SP", "São Paulo"),
	RO("Rondônia", "RO", "Porto Velho"),
	RR("Roraima", "RR", "Boa Vista"),
	PR("Paraná", "PR", "Curitiba"),
	CE("Ceará", "CE", "Fortaleza"),
	PE("Pernambuco", "PE", "Recife"),
	SC("Santa Catarina", "SC", "Florianópolis"),
	PB("Paraíba", "PB", "João Pessoa"),
	RN("Rio Grande do Norte", "RN", "Natal"),
	ES("Espírito Santo", "ES", "Vitória"),
	RJ("Rio de Janeiro", "RJ", "Rio de Janeiro"),
	SE("Sergipe", "SE", "Aracaju"),
	DF("Distrito Federal", "DF", "Brasília");
	
	private final String nome;
	private final String sigla;
	private final String capital;

	Uf(final String nome, final String sigla, final String capital) {
		this.nome = nome;
		this.sigla = sigla;
		this.capital = capital;
	}
	
	public static Uf fromUF(final String nomeUf) {
		for (final Uf uf : Uf.values()) {
			if (uf.nome.equalsIgnoreCase(nomeUf)) {
				return uf;
			}
		}

		throw new IllegalArgumentException(nomeUf);
	}
	
	public static Uf fromSigla(final String sigla) {
		for (final Uf uf : Uf.values()) {
			if (uf.sigla.equalsIgnoreCase(sigla)) {
				return uf;
			}
		}

		throw new IllegalArgumentException(sigla);
	}
	
	public static Uf fromCapital(final String capital) {
		for (final Uf uf : Uf.values()) {
			if (uf.capital.equalsIgnoreCase(capital)) {
				return uf;
			}
		}

		throw new IllegalArgumentException(capital);
	}
	
	public String sigla() {
		return this.sigla;
	}

	public String nome() {
		return this.nome;
	}

	public String capital() {
		return this.capital;
	}

}
