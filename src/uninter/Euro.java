package uninter;

public class Euro extends Moeda {

	public Euro(double valorInicial) {
		this.valor = valorInicial;
	}

	public void info() {
		System.out.println("Euro = " + valor);

	}

	public double converter() {
		return this.valor * 5.6;
	}

	@Override
	public boolean equals(Object objeto) {
		if (this.getClass() != objeto.getClass()) {
			return false;
		}

		// cast
		Euro objetoMoedaEuro = (Euro) objeto;

		if (this.valor != objetoMoedaEuro.valor) {
			return false;
		}

		return true;
	}

}
